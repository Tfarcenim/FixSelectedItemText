package tfar.fixselecteditemtext;

import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FixSelectedItemText.MODID)
public class FixSelectedItemText {
	// Directly reference a log4j logger.

	public static final String MODID = "fixselecteditemtext";

	public FixSelectedItemText() {
	}

	public static int fix(int old, int scaledHeight) {
		int leftHeight = ForgeIngameGui.left_height;
		int rightHeight = ForgeIngameGui.right_height;
		int offsetHeight = Math.max(leftHeight,rightHeight);
		if (offsetHeight > 59) {
			return scaledHeight - offsetHeight;
		}
		return old;
	}
}
