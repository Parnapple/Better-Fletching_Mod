package com.parnapple.betterfletching.entities;

import com.parnapple.betterfletching.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EnderArrow extends AbstractArrow {
    public EnderArrow(EntityType<? extends EnderArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public EnderArrow(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.ENDER_ARROW.get(), pShooter, pLevel);
    }

    public EnderArrow(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypes.ENDER_ARROW.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.ENDER_ARROW.get());
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.discard();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        for(int i = 0; i < 32; ++i) {
            this.level().addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.level().isClientSide && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverplayer = (ServerPlayer)entity;
                if (serverplayer.connection.isAcceptingMessages() && serverplayer.level() == this.level() && !serverplayer.isSleeping()) {
                    net.minecraftforge.event.entity.EntityTeleportEvent.EnderPearl event = net.minecraftforge.event.ForgeEventFactory.onEnderPearlLand(serverplayer, this.getX(), this.getY(), this.getZ(), null, 5.0F, pResult); //null pearl entity may cause problems? idk
                    if (!event.isCanceled()) { // Don't indent to lower patch size
                        if (this.random.nextFloat() < 0.05F && this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                            Endermite endermite = EntityType.ENDERMITE.create(this.level());
                            if (endermite != null) {
                                endermite.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                                this.level().addFreshEntity(endermite);
                            }
                        }

                        if (entity.isPassenger()) {
                            serverplayer.dismountTo(this.getX(), this.getY(), this.getZ());
                        } else {
                            entity.teleportTo(this.getX(), this.getY(), this.getZ());
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.resetFallDistance();
                        entity.hurt(this.damageSources().fall(), event.getAttackDamage());
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.resetFallDistance();
            }

            this.discard();
        }

    }

}
