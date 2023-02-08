package com.patrigan.elementary.platform;

import com.patrigan.elementary.damagetype.DamageTypeEvents;
import com.patrigan.elementary.datapack.DatapackReloadListener;
import com.patrigan.elementary.network.NetworkHandler;
import com.patrigan.elementary.network.message.DamageTypeSyncPacket;
import com.patrigan.elementary.registry.AttributeInit;
import com.patrigan.elementary.registry.damagetype.DamageTypeRegistry;
import com.patrigan.elementary.datapack.CodecDataManagerSync;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ElementaryForge implements ElementaryPlatform {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.Keys.ATTRIBUTES, ElementaryConstants.MODID);

    @Override
    public void setupElementary() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        setupRegistries();
        setupEvents();
        setupDatapackFormats();
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

    private void setupDatapackFormats() {
        CodecDataManagerSync.subscribeAsSyncable(NetworkHandler.INSTANCE, DamageTypeSyncPacket::new, DamageTypeRegistry.REGISTRY);
    }

    @Override
    public void setupEvents() {
        MinecraftForge.EVENT_BUS.addListener(DatapackReloadListener::onAddReloadListeners);
        MinecraftForge.EVENT_BUS.addListener(DamageTypeEvents::onLivingAttackEvent);
        MinecraftForge.EVENT_BUS.addListener(DamageTypeEvents::onLivingHurtEvent);
    }

    @Override
    public Supplier<Attribute> registerAttribute(String id, Supplier<Attribute> supplier) {
        ATTRIBUTES.register(id, supplier);
        return supplier;
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::init);
    }
}
