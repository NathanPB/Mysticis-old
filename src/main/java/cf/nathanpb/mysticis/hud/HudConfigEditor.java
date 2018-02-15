package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.hud.elements.HudElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

import java.io.IOException;


@Mod.EventBusSubscriber
public class HudConfigEditor extends GuiScreen{
    private boolean rendering = false;

    public HudConfigEditor(){
        setRendering(true);
        HudElement.MANA.renderBorders(true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void render(){
        ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
        drawCenteredString(
                Minecraft.getMinecraft().fontRenderer,
                "Drag the gui elements to move them",
                res.getScaledWidth()/2,
                res.getScaledHeight()/2,
                Integer.parseInt("FF0000", 16)
        );
    }

    public void setRendering(boolean rendering) {
        this.rendering = rendering;
    }


    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        if(HudElement.MANA.clicked(mouseX, mouseY)){
            HudElement.MANA.moveCenter(mouseX, mouseY);
        }

        System.out.println("===========================");
        System.out.println("Click: "+mouseX+" - "+mouseY +" - "+HudElement.MANA.clicked(mouseX, mouseY));
        System.out.println("Start: "+HudElement.MANA.getX()+" - "+HudElement.MANA.getY());
        System.out.println("End: "+HudElement.MANA.getX()+HudElement.MANA.getWidth()+" - "+HudElement.MANA.getY()+HudElement.MANA.getHeight());
        System.out.println("Size: "+HudElement.MANA.getWidth()+" - "+HudElement.MANA.getHeight());
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post e){
        if(e.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE && rendering){
            render();
        }
    }

    @Override
    public void onGuiClosed() {
        //Mouse.setGrabbed(true);
        setRendering(false);
        HudElement.MANA.renderBorders(false);
    }
}
