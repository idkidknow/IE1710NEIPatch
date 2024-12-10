package com.idkidknow.ie1710neipatch.mixin;

import blusunrize.immersiveengineering.client.nei.NEIArcFurnaceHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = NEIArcFurnaceHandler.class, remap = false)
public abstract class NEIArcFurnaceHandlerPatch {
    @ModifyArg(
            method = "createSubHandler",
            at = @At(value = "INVOKE",
                    target = "Lblusunrize/immersiveengineering/client/nei/NEIArcFurnaceHandler$ProxyClassLoader;<init>(Ljava/lang/ClassLoader;[B)V"),
            index = 0
    )
    private static ClassLoader replaceClassLoader(ClassLoader loader) {
        System.out.println(loader.getClass().getName() + "? " + NEIArcFurnaceHandler.class.getClassLoader().getClass().getName() + "!");
        return NEIArcFurnaceHandler.class.getClassLoader();
    }
}
