package cf.nathanpb.mysticis.client.hud;

import cf.nathanpb.mysticis.common.data.MysticisConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class HudConfigEditor extends Hud{

    private Hud workingOn = null;

    public HudConfigEditor(){
        for(Hud h : Hud.getAllHuds()){
            h.setRenderBorders(true);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        if(workingOn != null){
            workingOn.moveCenter(mouseX, mouseY);
        }

        ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
        drawCenteredString(
                Minecraft.getMinecraft().fontRenderer,
                I18n.format("gui.hudmodify.centered_text"),
                res.getScaledWidth()/2,
                (res.getScaledHeight()/2)-50,
                Integer.parseInt("FF0000", 16)
        );
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        Hud h = Hud.getHud(mouseX, mouseY);
        if(h != null){
            workingOn = h;
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        if(workingOn != null) {
            workingOn.moveCenter(mouseX, mouseY);
            workingOn = null;
        }
    }

    @Override
    public void onGuiClosed() {
        hide();
        for(Hud h : Hud.getAllHuds()){
            h.setRenderBorders(false);
        }

        MysticisConfig.MANA_HUD_X.set(Hud.MANA.getX());
        MysticisConfig.MANA_HUD_Y.set(Hud.MANA.getY());

        MysticisConfig.AFFINITY_HUD_X.set(Hud.AFFINITY.getX());
        MysticisConfig.AFFINITY_HUD_Y.set(Hud.AFFINITY.getY());

        MysticisConfig.LEVEL_HUD_X.set(Hud.LEVEL.getX());
        MysticisConfig.LEVEL_HUD_Y.set(Hud.LEVEL.getY());
        MysticisConfig._save();
    }


}
