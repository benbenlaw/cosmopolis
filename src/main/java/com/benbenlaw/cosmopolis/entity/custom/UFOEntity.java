package com.benbenlaw.cosmopolis.entity.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class UFOEntity extends Animal implements FlyingAnimal, PlayerRideableJumping {

    private static Logger logger = LogUtils.getLogger();

    private float playerJumpDelta;
    public UFOEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.FOLLOW_RANGE, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    protected void playerRide(Player player) {
        if (!this.level.isClientSide) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getFirstPassenger();
    }

    @Override
    public boolean isPushable() {
        return !this.isVehicle();
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isFlying())
            this.setDeltaMovement(this.getDeltaMovement().add(0D, -0.05F, 0));
    }

    @Override
    public void travel(@NotNull Vec3 pTravelVector) {
        if (this.isAlive()) {
            LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
            if (this.isVehicle() && livingentity != null) {
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

//                if (this.onGround && this.playerJumpDelta == 0) {
//                    f = 0.0F;
//                    f1 = 0.0F;
//                }

                logger.info("Jump Delta: {}", this.playerJumpDelta);
                if (this.playerJumpDelta > 0.0F) {
                    double d0 = this.getBlockJumpFactor();
                    double d1 = d0 + this.getJumpBoostPower();
                    Vec3 vec3 = this.getDeltaMovement();
                    this.setDeltaMovement(this.getDeltaMovement().add(vec3.x, d1, vec3.z));
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
                    if (f1 > 0.0F) {
                        float f2 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpDelta), 0.0D, (double)(0.4F * f3 * this.playerJumpDelta)));
                    }

                    this.playerJumpDelta = 0.0F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3(f, pTravelVector.y, f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.tryCheckInsideBlocks();
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(pTravelVector);
            }
        }
    }



    @Override
    public @NotNull InteractionResult mobInteract(@NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        if (!this.isVehicle() && pPlayer.getItemInHand(pHand).isEmpty()) {
            this.playerRide(pPlayer);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel p_146743_, @NotNull AgeableMob p_146744_) {
        return null;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround;
    }

    @Override
    public void onPlayerJump(int pJumpPower) {
        if (pJumpPower < 0) {
            pJumpPower = 0;
        }

        if (pJumpPower >= 90) {
            this.playerJumpDelta = 1.0F;
        } else {
            this.playerJumpDelta = 0.4F + 0.4F * (float)pJumpPower / 90.0F;
        }
    }

    @Override
    public boolean canJump() {
        return true;
    }

    @Override
    public void handleStartJump(int pJumpPower) {

    }

    @Override
    public void handleStopJump() {

    }
}