package com.parnapple.betterfletching.client.renderers;

import com.parnapple.betterfletching.BetterFletching;
import com.parnapple.betterfletching.entities.LightningArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LightningArrowRenderer extends ArrowRenderer<LightningArrow> {
    public static final ResourceLocation LIGHTNING_ARROW_LOCATION = new ResourceLocation(BetterFletching.MODID, "textures/entity/lightning_arrow.png");

    public LightningArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(LightningArrow pEntity) {
        return LIGHTNING_ARROW_LOCATION;
    }
}
