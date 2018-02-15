package cf.nathanpb.mysticis.hud.elements;

import cf.nathanpb.mysticis.utils.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class HudElement{

    public static final ManaHudElement MANA = new ManaHudElement();
    boolean renderborders = false;

    private Integer color = Integer.parseInt("FF0000", 16);

    protected Gui gui;


    int X = 0;
    int Y = 0;

    int width = 1;
    int height = 1;


    public void render(){
        if(gui != null) {
            if (renderborders) {

                //code from sir_titi
                RenderUtils.drawRoundedHollowBox(getX(), getY(), getHeight(), getWidth(), color);

                /*
                drawHorizontalLine(getX(), getX() + width, getY(), color);
                drawHorizontalLine(getX(), getX() + width, getY() + height, color);

                drawVerticalLine(getY(), getY() + height, getX(), color);
                drawVerticalLine(getY(), getY() + height, getX() + width, color);
                */
            }
        }
    }

    public boolean clicked(int x, int y){
        return ((x >= X && x <= X+width) && (y >= Y && y <= Y+height));
    }

    public void renderBorders(boolean flag){
        this.renderborders = flag;
    }

    public HudElement setGui(Gui gui) {
        this.gui = gui;
        return this;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setPostion(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void moveCenter(int x, int y){
        setPostion(x-(width/2), y-(height/2));
    }

    public int getCenterX(){
        return X+(width/2);
    }

    public int getCenterY(){
        return Y+(height/2);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
