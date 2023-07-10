package com.parnapple.betterfletching.events;

import com.parnapple.betterfletching.BetterFletching;
import com.parnapple.betterfletching.client.ExplosiveArrowRenderer;
import com.parnapple.betterfletching.entities.ExplosiveArrow;
import com.parnapple.betterfletching.entities.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterFletching.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
    }

}
