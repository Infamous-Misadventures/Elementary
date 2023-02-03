package com.patrigan.elementary.registry;

import com.patrigan.elementary.platform.ElementaryConstants;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AttributeInit {

    public static final List<Supplier<Attribute>> ALL_ATTRIBUTES = new ArrayList<>();

    //Fire
    public static final Supplier<Attribute> FIRE_POWER = registerPower("fire");
    public static final Supplier<Attribute> FIRE_RESISTANCE = registerResistance("fire");

    public static void init() {
    }

    private static Supplier<Attribute> registerPower(String type) {
        Supplier<Attribute> attributeSupplier = () -> new RangedAttribute(
                "attribute.name.generic.elementary.power." + type,
                1.0D,
                0.0D,
                1024.0D)
                .setSyncable(true);
        ALL_ATTRIBUTES.add(attributeSupplier);
        return register(type + "_power",
                attributeSupplier);
    }

    private static Supplier<Attribute> registerResistance(String type) {
        Supplier<Attribute> attributeSupplier = () -> new RangedAttribute(
                "attribute.name.generic.elementary.resistance." + type,
                1.0D,
                0.0D,
                2.0D)
                .setSyncable(true);
        ALL_ATTRIBUTES.add(attributeSupplier);
        return register(type + "resistance",
                attributeSupplier);
    }

    private static Supplier<Attribute> register(String id, Supplier<Attribute> attributeSup) {
        return ElementaryConstants.PLATFORM.registerAttribute(id, attributeSup);
    }

}
