package com.patrigan.elementary.util;

import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public interface CodecDataManager<T> {

    Map<ResourceLocation, T> getData();
}
