package com.patrigan.elementary.registry.damagetype.modifier;

import com.patrigan.elementary.damagetype.DamageTypeModifier;
import com.patrigan.elementary.damagetype.DamageTypeModifierList;
import com.patrigan.elementary.util.CodecJsonDataManager;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;

public class EnchantmentModifierRegistry {
    public static final ResourceLocation RESOURCELOCATION = new ResourceLocation(MODID, "damage_type_modifier_enchantment");

    public static final CodecJsonDataManager<DamageTypeModifierList> REGISTRY = new CodecJsonDataManager<>(RESOURCELOCATION, "damage_type_modifier/enchantment", DamageTypeModifierList.CODEC);


    public static List<DamageTypeModifier> getDamageTypeModifiers(ResourceLocation resourceLocation) {
        return REGISTRY.getData().getOrDefault(resourceLocation, DamageTypeModifierList.DEFAULT).getDamageTypeModifiers();
    }

    public static boolean damageTypeModifierListExists(ResourceLocation resourceLocation) {
        return REGISTRY.getData().containsKey(resourceLocation);
    }

    public static void setData(Map<ResourceLocation, DamageTypeModifierList> data) {
        REGISTRY.setData(data);
    }
}