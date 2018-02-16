package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.proxy.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class MysticisConfig extends Configuration{


    public static Property
        SHOW_MANA_HUD,
        MANA_HUD_X,
        MANA_HUD_Y,

        SHOW_AFFINITY_HUD,
        AFFINITY_HUD_X,
        AFFINITY_HUD_Y;

    public MysticisConfig(){
        super(new File("configs/"+ Mysticis.ID+".cfg"));
        load();
        addCustomCategoryComment("mana", "Things about Mana system and its HUD");
        addCustomCategoryComment("affinity", "Things about Affinity system and its HUD");

        SHOW_MANA_HUD = get("mana", "show_hud", true, "Set to false to hide Mana HUD");
        MANA_HUD_X = get("mana", "hud_x", 20, "X axis to Mana HUD");
        MANA_HUD_Y = get("mana", "hud_y", 20, "Y axis to Mana HUD");

        SHOW_AFFINITY_HUD = get("affinity", "show_hud", true, "Set to false to hide Affinity HUD");
        AFFINITY_HUD_X = get("affinity", "hud_x", 20, "X axis to Affinity HUD");
        AFFINITY_HUD_Y = get("affinity", "hud_y", 90, "Y axis to Affinity HUD");
        save();
    }

    public static void _save(){
        if(CommonProxy.configuration.hasChanged())
            CommonProxy.configuration.save();
    }
}
