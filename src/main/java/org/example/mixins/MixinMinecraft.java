package org.example.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.example.ExamplePlugin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author john@rusherhack.org 2/14/2025
 */
@Mixin(value = Minecraft.class, priority = Integer.MAX_VALUE)
public class MixinMinecraft {
	
	@Inject(method = "<clinit>", at = @At("HEAD"))
	private static void onClassInit(CallbackInfo ci) {
		ExamplePlugin.minecraftInitTime = System.currentTimeMillis();
	}
	
	@Inject(method = "<init>", at = @At("RETURN"))
	private void onPostInit(GameConfig gameConfig, CallbackInfo ci) {
		ExamplePlugin.INSTANCE.getLogger().info("minecraft loaded in " + (System.currentTimeMillis() - ExamplePlugin.minecraftInitTime) + "ms");
	}
	
}