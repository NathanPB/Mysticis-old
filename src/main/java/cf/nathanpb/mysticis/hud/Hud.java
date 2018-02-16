package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.proxy.CommonProxy;
import cf.nathanpb.mysticis.utils.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class Hud extends GuiScreen{
    /*
        EXISTING HUDS
     */
    public static HudMana MANA = new HudMana();

    private static Hud[] huds = new Hud[]{
            MANA
    };


    int X = 0;
    int Y = 0;

    int width = 0;
    int height = 0;

    private boolean renderBorders = false;
    private boolean show = true;

    private Integer color = Integer.parseInt("FF0000", 16);

    Hud(){
        show();
    }

    public void render() {
        if(renderBorders){
            RenderUtils.drawRoundedHollowBox(getX(), getY(), getHeight(), getWidth(), color);
        }
    }

    public boolean isBetween(int x, int y){
        return ((x >= X && x <= X+width) && (y >= Y && y <= Y+height));
    }

    public int getCenterX(){
        return X+(width/2);
    }

    public int getCenterY(){
        return Y+(height/2);
    }

    public void moveCenter(int x, int y){
        setPosition(x-(width/2), y-(height/2));
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setPosition(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post e){
        if(e.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            render();
        }
    }

    public Hud show(){
        this.show = true;
        MinecraftForge.EVENT_BUS.register(this);
        return this;
    }

    public Hud hide(){
        this.show = false;
        MinecraftForge.EVENT_BUS.unregister(this);
        return this;
    }

    public boolean isShowing() {
        return show;
    }

    public static Hud getHud(int x, int y){
        for(Hud h : huds){
            if(h.isBetween(x, y)) {
                if(h.isShowing()) return h;
            }
        }
        return null;
    }

    public static Hud[] getAllHuds(){
        return huds;
    }

    public void setRenderBorders(boolean renderBorders) {
        this.renderBorders = renderBorders;
    }

    @Override
    public void onResize(Minecraft mcIn, int w, int h) {
        super.onResize(mcIn, w, h);
        setPosition(w, h);
    }
}
