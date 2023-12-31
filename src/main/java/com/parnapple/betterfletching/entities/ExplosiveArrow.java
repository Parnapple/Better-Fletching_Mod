package com.parnapple.betterfletching.entities;

import com.parnapple.betterfletching.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ExplosiveArrow extends AbstractArrow {
    public ExplosiveArrow(EntityType<? extends ExplosiveArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ExplosiveArrow(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.EXPLOSIVE_ARROW.get(), pShooter, pLevel);
    }

    public ExplosiveArrow(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypes.EXPLOSIVE_ARROW.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.EXPLOSIVE_ARROW.get());
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.discard();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        Level level = this.level();
        Vec3 pos = pResult.getLocation();

        float f = (float)this.getDeltaMovement().length();
        int i = Mth.ceil(Mth.clamp((double)f * this.getBaseDamage(), 0.0D, (double)Integer.MAX_VALUE));
        if (this.isCritArrow()) {
            long j = (long)this.random.nextInt(i / 2 + 2);
            i = (int)Math.min(j + (long)i, 2147483647L);
        }

        level.explode(this.getOwner(), pos.x, pos.y, pos.z, i/2.5f, Level.ExplosionInteraction.MOB);
    }

}
