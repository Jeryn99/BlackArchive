package net.SpectrumFATM.black_archive.fabric.entity.custom;

import net.SpectrumFATM.black_archive.fabric.BlackArchive;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.Random;
import java.util.UUID;

public class DalekPuppetEntity extends HostileEntity {
    private UUID playerUUID;
    private int skinId;

    public DalekPuppetEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        BlackArchive.LOGGER.info("DalekPuppetEntity initialized");

        Random random = new Random();
        skinId = random.nextInt(8);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 5.0F, 0.02F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 2.0D));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, false,
                livingEntity -> !(livingEntity instanceof DalekEntity || DalekPuppetEntity.class.isAssignableFrom(livingEntity.getClass()))));
    }

    public static DefaultAttributeContainer.Builder createDalekSlaveAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public int getSkinId() {
        return this.skinId;
    }
}
