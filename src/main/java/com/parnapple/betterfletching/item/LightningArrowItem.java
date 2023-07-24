package com.parnapple.betterfletching.item;

import com.parnapple.betterfletching.entities.ExplosiveArrow;
import com.parnapple.betterfletching.entities.LightningArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningArrowItem extends ArrowItem {
    public LightningArrowItem(Properties pProperties) {
        super(pProperties);
    }

    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new LightningArrow(pLevel, pShooter);
    }
}
