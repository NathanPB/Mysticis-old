package cf.nathanpb.mysticis.common.utils;

import net.minecraft.client.gui.Gui;

public class RenderUtils {
    /**draws a rounded bordered box
     * @param centerToMousePosX
     * @param centerToMousePosY
     * @param height
     * @param boxLenght
     * @param innerColor
     * @param outerColor
     * @author kevin (Sir_titi)*/
    public static void drawRoundedBox(int centerToMousePosX,int centerToMousePosY,int height,int boxLenght,int innerColor,int outerColor){
        drawRoundedFilledBox(centerToMousePosX, centerToMousePosY, height, boxLenght, innerColor);
        drawRoundedHollowBox(centerToMousePosX, centerToMousePosY, height, boxLenght, outerColor);
    }

    /**draws a hollow (border)
     * @param centerToMousePosX
     * @param centerToMousePosY
     * @param height
     * @param boxLenght
     * @param color
     * @author kevin (Sir_titi)*/
    public static void drawRoundedHollowBox(int centerToMousePosX,int centerToMousePosY,int height,int boxLenght,int color){
        drawVerticalLine(centerToMousePosX-5, centerToMousePosY-1-4, centerToMousePosY-height+3, color);//left
        drawHorizontalLine(centerToMousePosX, centerToMousePosX+boxLenght-1, centerToMousePosY-height, color);//upper line
        drawVerticalLine(centerToMousePosX+4+boxLenght, centerToMousePosY-1-4, centerToMousePosY-height+3, color);//right
        drawHorizontalLine(centerToMousePosX, centerToMousePosX+boxLenght-1, centerToMousePosY-2, color);//lower line
        for (int i=0;i<4;i++){
            Gui.drawRect(centerToMousePosX-i, centerToMousePosY-2-i, centerToMousePosX-1-i, centerToMousePosY-1-i, color);//lower left
            Gui.drawRect(centerToMousePosX+i+boxLenght, centerToMousePosY-2-i, centerToMousePosX+1+i+boxLenght, centerToMousePosY-1-i, color);//lower right
            Gui.drawRect(centerToMousePosX-i, centerToMousePosY-height+i, centerToMousePosX-1-i, centerToMousePosY+1-height+i, color);//upper left
            Gui.drawRect(centerToMousePosX+i+boxLenght, centerToMousePosY-height+i, centerToMousePosX+1+boxLenght+i, centerToMousePosY+1-height+i, color);//upper right
        }
    }

    /**draws a full rounded box
     * @param centerToMousePosX
     * @param centerToMousePosY
     * @param height
     * @param boxLenght
     * @param color
     * @author kevin (Sir_titi)*/
    public static void drawRoundedFilledBox(int centerToMousePosX,int centerToMousePosY,int height,int boxLenght,int color){
        Gui.drawRect(centerToMousePosX, centerToMousePosY-2, centerToMousePosX+boxLenght, centerToMousePosY-height+1, color);
        for (int i=0;i<4;i++){
            Gui.drawRect(centerToMousePosX-i, centerToMousePosY-2-i, centerToMousePosX-1-i, centerToMousePosY-height+1+i, color);
            Gui.drawRect(centerToMousePosX+boxLenght+i, centerToMousePosY-2-i, centerToMousePosX+boxLenght+1+i, centerToMousePosY-height+1+i,color);
        }
    }

    /**draws a squared box (+border) with default height of 14 pixels<br>
     * use {@linkplain RenderUtils#drawSquaredBox(int , int, int, int, int, int)} for custom height
     * @param CenterToMousePosX
     * @param CenterToMousePosY
     * @param BoxLenght
     * @param InnerColor
     * @param OuterColor
     * @author kevin (Sir_titi)*/
    public static void drawSquaredBox(int CenterToMousePosX,int CenterToMousePosY,int BoxLenght,int InnerColor,int OuterColor){
        drawSquaredBox(CenterToMousePosX, CenterToMousePosY, 14, BoxLenght, InnerColor, OuterColor);
    }

    /**draws a squared box with border
     * @param CenterToMousePosX
     * @param CenterToMousePosY
     * @param height
     * @param BoxLenght
     * @param InnerColor
     * @param OuterColor
     * @author kevin (Sir_titi)*/
    public static void drawSquaredBox(int CenterToMousePosX,int CenterToMousePosY,int height,int BoxLenght,int InnerColor,int OuterColor){
        Gui.drawRect(CenterToMousePosX, CenterToMousePosY-2, CenterToMousePosX+BoxLenght+1, CenterToMousePosY-height+1, InnerColor);
        drawHorizontalLine(CenterToMousePosX-1, CenterToMousePosX+BoxLenght+1, CenterToMousePosY-height, OuterColor);
        drawHorizontalLine(CenterToMousePosX, CenterToMousePosX+BoxLenght, CenterToMousePosY-2, OuterColor);
        drawVerticalLine(CenterToMousePosX-1, CenterToMousePosY-height, CenterToMousePosY-1, OuterColor);
        drawVerticalLine(CenterToMousePosX+BoxLenght+1, CenterToMousePosY-height, CenterToMousePosY-1, OuterColor);
    }

    public static void drawHorizontalLine(int startX, int endX, int y, int color)
    {
        if (endX < startX)
        {
            int i = startX;
            startX = endX;
            endX = i;
        }

        Gui.drawRect(startX, y, endX + 1, y + 1, color);
    }

    /**
     * Draw a 1 pixel wide vertical line. Args : x, y1, y2, color
     */
    public static void drawVerticalLine(int x, int startY, int endY, int color)
    {
        if (endY < startY)
        {
            int i = startY;
            startY = endY;
            endY = i;
        }

        Gui.drawRect(x, startY + 1, x + 1, endY, color);
    }
}
