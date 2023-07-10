package com.parnapple.betterfletching.client;

import com.parnapple.betterfletching.BetterFletching;
import com.parnapple.betterfletching.entities.ExplosiveArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ExplosiveArrowRenderer extends ArrowRenderer<ExplosiveArrow> {
    public static final ResourceLocation EXPLOSIVE_ARROW_LOCATION = new ResourceLocation(BetterFletching.MODID, "textures/entity/explosive_arrow.png");

    public ExplosiveArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplosiveArrow pEntity) {
        return EXPLOSIVE_ARROW_LOCATION;
    }
}
