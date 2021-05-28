package tfar.fixselecteditemtext.mixin;

import net.minecraft.client.gui.IngameGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import tfar.fixselecteditemtext.FixSelectedItemText;

@Mixin(IngameGui.class)
public class IngameGuiMixin {
	@Shadow protected int scaledHeight;

	@ModifyVariable(method = "renderItemName",
					at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerController;shouldDrawHUD()Z")
					,ordinal = 2)
	private int fixOffset(int old) {
		return FixSelectedItemText.fix(old,scaledHeight);
	}
}
