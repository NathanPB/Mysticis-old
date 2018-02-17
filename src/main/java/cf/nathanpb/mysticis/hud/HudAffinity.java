package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.data.AffinityData;
import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.MysticisConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class HudAffinity extends Hud {
    private AffinityData affinity = new AffinityData(new NBTTagCompound());

    private String
            air = affinity.AIR+"",
            fire = affinity.FIRE+"",
            water = affinity.WATER+"",
            ice = affinity.ICE+"",
            nature = affinity.NATURE+"",
            magic = affinity.MAGIC+"",
            dark = affinity.DARK+"";

    public HudAffinity(){
        setPosition(MysticisConfig.AFFINITY_HUD_X.getInt(), MysticisConfig.AFFINITY_HUD_Y.getInt());
        setSize(30, 60);
    }



    public void render(){
        super.render();
        if(MysticisConfig.SHOW_AFFINITY_HUD.getBoolean()) {
            int height = getY();
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, air, getX(), height, ManaData.colorAir);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, fire, getX(), height+=10, ManaData.colorFire);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, water, getX(), height+=10, ManaData.colorWater);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, ice, getX(), height+=10, ManaData.colorIce);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, nature, getX(), height+=10, ManaData.colorNature);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, magic, getX(), height+=10, ManaData.colorMagic);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, dark, getX(), height+10, ManaData.colorDark);
        }
    }

    public void update(AffinityData affinity){
        air = affinity.AIR+"";
        fire = affinity.FIRE+"";
        water = affinity.WATER+"";
        ice = affinity.ICE+"";
        nature = affinity.NATURE+"";
        magic = affinity.MAGIC+"";
        dark = affinity.DARK+"";
    }
}
