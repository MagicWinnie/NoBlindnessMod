package net.magicwinnie.noblindness;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoBlindnessMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("magicwinnie_no_blindness");
    public static boolean flag = true;

    @Override
    public void onInitialize() {
        LOGGER.info("No Blindness Mod is initialized!");
    }
}
