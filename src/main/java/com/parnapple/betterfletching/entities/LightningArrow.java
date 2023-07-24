package com.parnapple.betterfletching.entities;

import com.parnapple.betterfletching.item.ModItems;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class LightningArrow extends AbstractArrow {
    public LightningArrow(EntityType<? extends LightningArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LightningArrow(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.LIGHTNING_ARROW.get(), pShooter, pLevel);
    }

    public LightningArrow(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypes.LIGHTNING_ARROW.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.LIGHTNING_ARROW.get());
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        Level level = this.level();
        Vec3 pos = pResult.getLocation();

        if(level instanceof ServerLevel) {
            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
            if (lightningbolt != null) {
                lightningbolt.moveTo(Vec3.atBottomCenterOf(new Vec3i((int)pos.x, (int)pos.y, (int)pos.z)));
                lightningbolt.setCause(this.getOwner() instanceof ServerPlayer ? (ServerPlayer)this.getOwner() : null);
                this.level().addFreshEntity(lightningbolt);
            }
        }
        this.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 5.0F, 1.0F);

    }

}
