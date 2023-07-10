package com.parnapple.betterfletching.item;

import com.parnapple.betterfletching.entities.ExplosiveArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplosiveArrowItem extends ArrowItem {
    public ExplosiveArrowItem(Properties pProperties) {
        super(pProperties);
    }

    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ExplosiveArrow(pLevel, pShooter);
    }
}
