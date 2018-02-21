package cf.nathanpb.mysticis.client;

import cf.nathanpb.mysticis.client.hud.HudConfigEditor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class KeyBinding extends net.minecraft.client.settings.KeyBinding{
    private static final Minecraft mc = Minecraft.getMinecraft();

    public static final KeyBinding[] keybinds = new KeyBinding[]{
            new KeyBinding("hudmodify", Keyboard.KEY_EQUALS, () -> mc.displayGuiScreen(new HudConfigEditor()))

    };

    private Runnable action;

    private KeyBinding(String name, int key, Runnable action){
        super(name, key, "key.categories.Mysticis");
        ClientRegistry.registerKeyBinding(this);
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }

    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent e){
        for(KeyBinding k : keybinds){
            if(k.isPressed()){
                k.action.run();
            }
        }
    }
}
