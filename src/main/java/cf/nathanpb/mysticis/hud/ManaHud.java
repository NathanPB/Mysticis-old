package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.MysticisConfig;
import cf.nathanpb.mysticis.hud.elements.HudElement;
import cf.nathanpb.mysticis.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ManaHud extends Gui {

    private void render(){
        if(ClientProxy.configuration.showManaHud()) {
            HudElement.MANA.setGui(this).render();
        }
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post e){
        if(e.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            render();
        }
    }
}
