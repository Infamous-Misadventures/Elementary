package com.patrigan.elementary.registry.damagetype;

import com.patrigan.elementary.damagetype.DamageType;
import com.patrigan.elementary.util.CodecJsonDataManager;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;

public class DamageTypeRegistry {
    public static final ResourceLocation DAMAGE_TYPE_RESOURCELOCATION = new ResourceLocation(MODID, "damage_type");

    public static final CodecJsonDataManager<DamageType> REGISTRY = new CodecJsonDataManager<>(DAMAGE_TYPE_RESOURCELOCATION, "damage_type", DamageType.CODEC);



    public static DamageType getDamageType(ResourceLocation resourceLocation) {
        return REGISTRY.getData().getOrDefault(resourceLocation, DamageType.DEFAULT);
    }

    public static boolean damageTypeExists(ResourceLocation resourceLocation) {
        return REGISTRY.getData().containsKey(resourceLocation);
    }

    public static void setData(Map<ResourceLocation, DamageType> data) {
        REGISTRY.setData(data);
    }
}