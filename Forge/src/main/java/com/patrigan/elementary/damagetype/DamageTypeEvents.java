package com.patrigan.elementary.damagetype;

import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DamageTypeEvents {

    public static void onLivingAttackEvent(LivingAttackEvent event) {
        DamageTypeHandlers.applyDamageTypeModifiers(event.getSource(), event.getEntity(), event.getAmount());
    }

    public static void onLivingHurtEvent(LivingHurtEvent event) {
        DamageTypeHandlers.applyFocus(event.getSource(), event.getAmount());
        DamageTypeHandlers.applyResistance(event.getEntity(), event.getSource(), event.getAmount());
    }
}
