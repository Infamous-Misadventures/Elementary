package com.patrigan.elementary.platform;

import com.patrigan.elementary.mixin.AttributesInvoker;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.ai.attributes.Attribute;

import java.util.function.Supplier;

public class ElementaryFabric implements ElementaryPlatform {

    @Override
    public void setupElementary() {

    }

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) { return FabricLoader.getInstance().isModLoaded(modId); }

    @Override
    public boolean isDevelopmentEnvironment() { return FabricLoader.getInstance().isDevelopmentEnvironment(); }

    @Override
    public void setupRegistries() {

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public Supplier<Attribute> registerAttribute(String id, Supplier<Attribute> supplier) {
        Attribute attribute = AttributesInvoker.invokeRegister(ElementaryConstants.MODID + ":" + id, supplier.get());

        return () -> attribute;
    }
}
