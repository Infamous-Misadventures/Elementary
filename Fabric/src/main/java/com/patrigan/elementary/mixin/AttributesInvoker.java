package com.patrigan.elementary.mixin;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Attributes.class)
public interface AttributesInvoker {

    @Invoker
    static Attribute invokeRegister(String id, Attribute attribute) {
        throw new AssertionError();
    }
}
