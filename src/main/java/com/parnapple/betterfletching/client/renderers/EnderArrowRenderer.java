package com.parnapple.betterfletching.client.renderers;

import com.parnapple.betterfletching.BetterFletching;
import com.parnapple.betterfletching.entities.EnderArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnderArrowRenderer extends ArrowRenderer<EnderArrow> {
    public static final ResourceLocation ENDER_ARROW_LOCATION = new ResourceLocation(BetterFletching.MODID, "textures/entity/ender_arrow.png");

    public EnderArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(EnderArrow pEntity) {
        return ENDER_ARROW_LOCATION;
    }
}
