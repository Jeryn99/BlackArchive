package net.SpectrumFATM.black_archive.fabric.entity.custom;

import net.SpectrumFATM.black_archive.fabric.BlackArchive;
import net.SpectrumFATM.black_archive.fabric.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CybermanEntity extends HostileEntity implements RangedAttackMob {

    private int firingTicks = 0; // Counter to track firing time
    private static final TrackedData<Boolean> IS_FIRING = DataTracker.registerData(CybermanEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public CybermanEntity(EntityType<CybermanEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_FIRING, false);
    }

    @Override
    public void tick() {
        super.tick();

        // Server-side logic
        if (!this.getWorld().isClient) {
            if (this.getTarget() != null) {
                if (!isFiring()) {
                    setFiring(true);
                    firingTicks = 0;  // Reset firing timer when firing starts
                }
            }

            // If currently firing, increment the counter
            if (isFiring()) {
                firingTicks++;

                // If 100 ticks (5 seconds) have passed, stop firing
                if (firingTicks >= 100) {
                    setFiring(false);
                }
            }
        }

        BlackArchive.LOGGER.info("Cyberman isFiring: " + isFiring());
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 2.0D, 40, 15.0F));  // Ranged attack goal
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 5.0F, 0.02F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 2.0D));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, false,
                livingEntity -> !(livingEntity instanceof CybermanEntity)));
    }

    public static DefaultAttributeContainer.Builder createCyberAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_ARMOR, 10.0)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 5.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 8.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        super.playStepSound(pos, state);
        this.getWorld().getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(8), entity -> true)
                .forEach(entity -> entity.playSound(ModSounds.CYBERMAN_STEP, 0.5F, 1.0F));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        double armX = this.getX() - 0.5 * Math.cos(Math.toRadians(this.bodyYaw));
        double armY = this.getY() + this.getHeight() * 0.75;
        double armZ = this.getZ() - 0.5 * Math.sin(Math.toRadians(this.bodyYaw));

        LaserEntity laser = new LaserEntity(this.getWorld(), this, 2.0f, false);
        laser.setPosition(armX, armY, armZ);

        double d0 = target.getY() + (target.getHeight() / 2.0) - laser.getY();
        double d1 = target.getX() - laser.getX();
        double d2 = d0;
        double d3 = target.getZ() - laser.getZ();
        laser.setVelocity(d1, d2, d3, 1.6f, 0.0f);

        this.getWorld().spawnEntity(laser);
    }

    public boolean isFiring() {
        return this.dataTracker.get(IS_FIRING);
    }

    public void setFiring(boolean firing) {
        this.dataTracker.set(IS_FIRING, firing);
    }
}
