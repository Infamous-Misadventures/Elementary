package com.patrigan.elementary.network.message;

import com.mojang.serialization.Codec;
import com.patrigan.elementary.registry.DamageTypeRegistry;
import com.patrigan.elementary.type.DamageType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DamageTypeSyncPacket {
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

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
        DamageTypeRegistry.setData(this.data);
    }
}
