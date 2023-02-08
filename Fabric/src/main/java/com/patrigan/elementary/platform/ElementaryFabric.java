package com.patrigan.elementary.platform;

import com.patrigan.elementary.damagetype.DamageTypeModifierList;
import com.patrigan.elementary.datapack.CodecDataManagerSync;
import com.patrigan.elementary.mixin.AttributesInvoker;
import com.patrigan.elementary.network.NetworkHandler;
import com.patrigan.elementary.network.message.DamageTypeSyncPacket;
import com.patrigan.elementary.registry.damagetype.DamageTypeRegistry;
import com.patrigan.elementary.registry.damagetype.modifier.EnchantmentModifierRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.ai.attributes.Attribute;

import java.util.function.Supplier;

public class ElementaryFabric implements ElementaryPlatform {

    @Override
    public void setupElementary() {
        setupEvents();
        setupDatapackFormats();
        NetworkHandler.init();
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

    private void setupDatapackFormats() {
        CodecDataManagerSync.subscribeAsSyncable(NetworkHandler.INSTANCE, DamageTypeSyncPacket::new, DamageTypeRegistry.REGISTRY);
//        CodecDataManagerSync.subscribeAsSyncable(NetworkHandler.INSTANCE, DamageTypeModifierListSyncPacket::new, EnchantmentModifierRegistry.REGISTRY);
    }

    @Override
    public Supplier<Attribute> registerAttribute(String id, Supplier<Attribute> supplier) {
        Attribute attribute = AttributesInvoker.invokeRegister(ElementaryConstants.MODID + ":" + id, supplier.get());

        return () -> attribute;
    }
}
