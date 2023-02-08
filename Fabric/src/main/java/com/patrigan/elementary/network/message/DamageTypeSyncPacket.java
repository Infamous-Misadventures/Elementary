package com.patrigan.elementary.network.message;

import com.mojang.serialization.Codec;
import com.patrigan.elementary.registry.damagetype.DamageTypeRegistry;
import com.patrigan.elementary.damagetype.DamageType;
import me.pepperbell.simplenetworking.S2CPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class DamageTypeSyncPacket implements S2CPacket {
    private static final Codec<Map<ResourceLocation, DamageType>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, DamageType.CODEC);

    public final Map<ResourceLocation, DamageType> data;

    public DamageTypeSyncPacket(Map<ResourceLocation, DamageType> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static DamageTypeSyncPacket decode(FriendlyByteBuf buffer) {
        return new DamageTypeSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    @Override
    public void handle(Minecraft minecraft, ClientPacketListener clientPacketListener, PacketSender packetSender, SimpleChannel simpleChannel) {
        DamageTypeRegistry.setData(this.data);
    }
}
