package com.patrigan.elementary.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.patrigan.elementary.registry.AttributeInit.ALL_ATTRIBUTES;

@Mixin(value = LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "createLivingAttributes", at = @At("RETURN"))
    private static void elementary$addModdedAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        ALL_ATTRIBUTES.forEach((attributeSupplier) ->
                cir.getReturnValue().add(attributeSupplier.get())
        );
    }
}
