package com.patrigan.elementary.network;

import com.patrigan.elementary.network.message.DamageTypeSyncPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.minecraft.resources.ResourceLocation;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;

public class NetworkHandler {
    public static final SimpleChannel INSTANCE = new SimpleChannel(new ResourceLocation(MODID, "network"));

    protected static int PACKET_COUNTER = 0;

    public NetworkHandler() {
    }

    public static void init() {
        // Server to Client
        INSTANCE.registerS2CPacket(DamageTypeSyncPacket.class, incrementAndGetPacketCounter(), DamageTypeSyncPacket::decode);
    }

    public static int incrementAndGetPacketCounter() {
        return PACKET_COUNTER++;
    }
}
