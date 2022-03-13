package me.declipsonator.particleblocker.mixins;

import me.declipsonator.particleblocker.utils.ParticleButtonOption;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin {
    @Shadow
    private ButtonListWidget list;

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/ButtonListWidget;addAll([Lnet/minecraft/client/option/Option;)V"))
    private void addButton(CallbackInfo ci) {
        boolean sodiumPresent = FabricLoader.getInstance().isModLoaded("sodium");
        if(!sodiumPresent) list.addSingleOptionEntry(new ParticleButtonOption());
    }
}