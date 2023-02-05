package com.patrigan.elementary.network;

import com.patrigan.elementary.network.message.DamageTypeSyncPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;

public class NetworkHandler {
    public static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(
                    new ResourceLocation(MODID, "network"))
            .clientAcceptedVersions("1"::equals)
            .serverAcceptedVersions("1"::equals)
            .networkProtocolVersion(() -> "1")
            .simpleChannel();

    protected static int PACKET_COUNTER = 0;

    public NetworkHandler() {
    }

    public static void init() {
        INSTANCE.messageBuilder(DamageTypeSyncPacket.class, incrementAndGetPacketCounter())
                .encoder(DamageTypeSyncPacket::encode).decoder(DamageTypeSyncPacket::decode)
                .consumerMainThread(DamageTypeSyncPacket::onPacketReceived)
                .add();
    }

    public static int incrementAndGetPacketCounter() {
        return PACKET_COUNTER++;
    }
}
