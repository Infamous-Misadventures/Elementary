package com.patrigan.elementary.attributes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.stream.Collectors;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;
import static com.patrigan.elementary.registry.AttributeInit.FIRE_POWER;
import static com.patrigan.elementary.registry.AttributeInit.FIRE_RESISTANCE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class AttributeEvents {

    @SubscribeEvent
    public static void onEntityAttributeModificationEvent(EntityAttributeModificationEvent event) {
        addAttributeToAll(event, FIRE_POWER.get());
        addAttributeToAll(event, FIRE_RESISTANCE.get());
    }

    private static void addAttributeToAll(EntityAttributeModificationEvent event, Attribute attribute) {
        List<EntityType<? extends LivingEntity>> entitiesWithoutAttribute = event.getTypes().stream().filter(entityType -> !event.has(entityType, attribute)).collect(Collectors.toList());
        entitiesWithoutAttribute.forEach(entityType -> event.add(entityType, attribute, attribute.getDefaultValue()));
    }
}
