package net.SpectrumFATM.black_archive.fabric.network;

import net.SpectrumFATM.black_archive.fabric.BlackArchive;
import net.SpectrumFATM.black_archive.fabric.config.BlackArchiveConfig;
import net.SpectrumFATM.black_archive.fabric.sound.ModSounds;
import net.SpectrumFATM.black_archive.fabric.util.SpaceTimeEventUtil;
import net.SpectrumFATM.black_archive.fabric.util.WorldUtil;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VortexTeleportPacket {
    public static final Identifier ID = new Identifier(BlackArchive.MOD_ID, "vortex_teleport");
    private static final int COOLDOWN_TIME = BlackArchiveConfig.COMMON.vortexManipulatorCooldown.get() * 20;

    public static void send(double x, double y, double z, String dimension) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
        buf.writeString(dimension);
        ClientPlayNetworking.send(ID, buf);
    }

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ID, (server, player, handler, buf, responseSender) -> {
            double x = buf.readDouble();
            double y = buf.readDouble();
            double z = buf.readDouble();
            String dimension = buf.readString(32767);

            server.execute(() -> {
                SpaceTimeEventUtil.setComplexSpaceTimeEvent(player, true);
                BlackArchive.LOGGER.info(String.valueOf(SpaceTimeEventUtil.isComplexSpaceTimeEvent(player)));

                if (player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem())) {
                    player.sendMessage(Text.literal("You must wait before teleporting again.").formatted(Formatting.RED), false);
                    return;
                }

                Identifier dimensionId = new Identifier(dimension);
                RegistryKey<World> dimensionKey = RegistryKey.of(RegistryKeys.WORLD, dimensionId);
                ServerWorld targetWorld = server.getWorld(dimensionKey);

                if (targetWorld != null) {
                    player.getServerWorld().spawnParticles(ParticleTypes.SMOKE, player.getX(), player.getY(), player.getZ(), 10, 0.5, 0.5, 0.5, 0.0);
                    player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.VORTEX_TP, SoundCategory.PLAYERS, 0.25f, 1.0f);

                    BlockPos safePos = WorldUtil.findSafeLandingPos(targetWorld, x, y, z);

                    if (safePos != null) {
                        player.teleport(targetWorld, safePos.getX(), safePos.getY(), safePos.getZ(), player.getYaw(), player.getPitch());
                        targetWorld.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.VORTEX_TP, SoundCategory.PLAYERS, 0.25f, 1.0f);
                        if (!player.isCreative()) {
                            player.getItemCooldownManager().set(player.getMainHandStack().getItem(), COOLDOWN_TIME);
                        }
                    } else {
                        player.sendMessage(Text.literal("No suitable ground position.").formatted(Formatting.RED), false);
                    }
                }
            });
        });
    }
}