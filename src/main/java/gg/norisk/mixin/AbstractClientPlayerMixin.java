package gg.norisk.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerMixin {
    @Unique
    private static final Identifier NORISK_SKIN = new Identifier("examplemod","norisk_skin.png");

    @Inject(method = "getSkinTexture", at = @At("RETURN"), cancellable = true)
    private void replaceSkin(CallbackInfoReturnable<Identifier> cir) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            cir.setReturnValue(NORISK_SKIN);
        }
    }
}
