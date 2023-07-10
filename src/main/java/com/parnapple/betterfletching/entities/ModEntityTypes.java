package com.parnapple.betterfletching.entities;

import com.parnapple.betterfletching.BetterFletching;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BetterFletching.MODID);

    public static final RegistryObject<EntityType<ExplosiveArrow>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow",
            () -> EntityType.Builder.<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4).
                    updateInterval(20)
                    .build(new ResourceLocation(BetterFletching.MODID, "explosive_arrow").toString())
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}