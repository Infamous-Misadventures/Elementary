package com.patrigan.elementary.platform;

import com.patrigan.elementary.registry.AttributeInit;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ElementaryForge implements ElementaryPlatform {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.Keys.ATTRIBUTES, ElementaryConstants.MODID);

    @Override
    public void setupElementary() {
        setupRegistries();
        AttributeInit.init();
    }

    @Override
    public String getPlatformName() { return "Forge"; }

    @Override
    public boolean isModLoaded(String modId) { return ModList.get().isLoaded(modId); }

    @Override
    public boolean isDevelopmentEnvironment() { return !FMLLoader.isProduction(); }

    @Override
    public void setupRegistries() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ATTRIBUTES.register(modEventBus);
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public Supplier<Attribute> registerAttribute(String id, Supplier<Attribute> supplier) {
        ATTRIBUTES.register(id, supplier);
        return supplier;
    }
}
