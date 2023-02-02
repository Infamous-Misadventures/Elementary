package com.patrigan.elementary.registry;

import com.patrigan.elementary.platform.ElementaryConstants;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.function.Supplier;

public class AttributeInit {
    public static void init() {}

    //Fire
    public static final Supplier<Attribute> FIRE_POWER = registerPower("fire");
    public static final Supplier<Attribute> FIRE_RESISTANCE = registerResistance("fire");

    private static Supplier<Attribute> registerPower(String type) {
        return register(type + "_power",
                () -> new RangedAttribute(
                    "attribute.name.generic.elementary."+type+"_power",
                    0.0D,
                    0.0D,
                    1024.0D)
                    .setSyncable(true));
    }

    private static Supplier<Attribute> registerResistance(String type) {
        return register(type+"resistance",
                () -> new RangedAttribute(
                        "attribute.name.generic.elementary."+type+"_resistance",
                        0.0D,
                        0.0D,
                        1.0D)
                        .setSyncable(true));
    }

    private static Supplier<Attribute> register(String id, Supplier<Attribute> attributeSup) {
        return ElementaryConstants.PLATFORM.registerAttribute(id, attributeSup);
    }

}
