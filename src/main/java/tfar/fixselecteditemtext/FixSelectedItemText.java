package tfar.fixselecteditemtext;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FixSelectedItemText.MODID)
public class FixSelectedItemText {
	// Directly reference a log4j logger.

	public static final String MODID = "fixselecteditemtext";

	private static final Logger LOGGER = LogManager.getLogger();

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
