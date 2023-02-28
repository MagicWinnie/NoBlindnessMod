package net.magicwinnie.noblindness;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NoBlindnessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding binding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.magicwinnie-no-blindness-mod.turn-on-off", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.category.no-blindness-mod"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (binding.wasPressed()) {
                if (NoBlindnessMod.flag) {
                    // previously turned on
                    client.player.sendMessage(Text.literal("[NoBlindnessMod] No blindness is turned off!"), false);
                    NoBlindnessMod.flag = false;
                } else {
                    // previously turned off
                    client.player.sendMessage(Text.literal("[NoBlindnessMod] No blindness is turned on!"), false);
                    NoBlindnessMod.flag = true;
                }
            }
        });
    }
}
