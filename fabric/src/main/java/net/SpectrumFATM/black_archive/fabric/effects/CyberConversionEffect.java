package net.SpectrumFATM.black_archive.fabric.effects;

import net.SpectrumFATM.black_archive.fabric.BlackArchive;
import net.SpectrumFATM.black_archive.fabric.entity.ModEntities;
import net.SpectrumFATM.black_archive.fabric.entity.custom.CybermanEntity;
import net.SpectrumFATM.black_archive.fabric.entity.custom.DalekPuppetEntity;
import net.SpectrumFATM.black_archive.fabric.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class CyberConversionEffect extends StatusEffect {
    public CyberConversionEffect() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (player.age % 200 == 0) {
                player.damage(player.getDamageSources().generic(), 1.0f);
            }

            if (player.getHealth() <= 1f && !player.isDead()) {
                CybermanEntity cybermanEntity = new CybermanEntity(ModEntities.CYBERMAN, player.getWorld());
                cybermanEntity.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.bodyYaw, player.getPitch());
                player.getWorld().spawnEntity(cybermanEntity);
                player.setHealth(0); // Ensure the player is marked as dead
            }
        }
    }
}