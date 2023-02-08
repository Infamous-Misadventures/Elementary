package com.patrigan.elementary.registry;

import com.patrigan.elementary.platform.ElementaryConstants;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AttributeInit {

    public static final List<Supplier<Attribute>> ALL_ATTRIBUTES = new ArrayList<>();

    // Physical
    public static final List<Supplier<Attribute>> SLASHING = registerElement("slashing");
    public static final List<Supplier<Attribute>> PIERCING = registerElement("piercing");
    public static final List<Supplier<Attribute>> BLUDGEONING = registerElement("bludgeoning");

    // Elemental
    public static final List<Supplier<Attribute>> FIRE = registerElement("fire");
    public static final List<Supplier<Attribute>> ICE = registerElement("ice");
    public static final List<Supplier<Attribute>> LIGHTNING = registerElement("lightning");
    public static final List<Supplier<Attribute>> POISON = registerElement("poison");

    public static void init() {
    }

    private static List<Supplier<Attribute>> registerElement(String element) {
        return List.of(
                registerFocus(element),
                registerResistance(element)
        );
    }

    private static Supplier<Attribute> registerFocus(String type) {
        Supplier<Attribute> attributeSupplier = register(type + "_focus",
                () -> new RangedAttribute(
                        "attribute.name.generic.elementary.focus." + type,
                        1000.0D,
                        0.0D,
                        1024.0D)
                        .setSyncable(true));
        ALL_ATTRIBUTES.add(attributeSupplier);
        return attributeSupplier;
    }

    private static Supplier<Attribute> registerResistance(String type) {
        Supplier<Attribute> attributeSupplier = register(type + "_resistance",
                () -> new RangedAttribute(
                        "attribute.name.generic.elementary.resistance." + type,
                        0.0D,
                        0.0D,
                        2.0D)
                        .setSyncable(true));
        ALL_ATTRIBUTES.add(attributeSupplier);
        return attributeSupplier;
    }

    private static Supplier<Attribute> register(String id, Supplier<Attribute> attributeSup) {
        return ElementaryConstants.PLATFORM.registerAttribute(id, attributeSup);
    }

}
