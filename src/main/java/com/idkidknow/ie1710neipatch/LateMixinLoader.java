package com.idkidknow.ie1710neipatch;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import java.util.*;

@LateMixin
public class LateMixinLoader implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.ie1710neipatch.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> set) {
        if (set.contains("ImmersiveEngineering")) return Collections.singletonList("NEIArcFurnaceHandlerPatch");
        return Collections.emptyList();
    }
}
