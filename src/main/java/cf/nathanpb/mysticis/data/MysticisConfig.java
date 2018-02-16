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
        MANA_HUD_Y;

    public MysticisConfig(){
        super(new File("configs/"+ Mysticis.ID+".cfg"));
        load();
        addCustomCategoryComment("mana", "Things about Mana system");

        SHOW_MANA_HUD = get("mana", "show_hud", true, "Set to true if you want to hide mana hud (can be changed ingame)");
        MANA_HUD_X = get("mana", "hud_x", 20, "X axis to mana hud");
        MANA_HUD_Y = get("mana", "hud_y", 20, "Y axis to mana hud");
        save();
    }

    public static void _save(){
        if(CommonProxy.configuration.hasChanged())
            CommonProxy.configuration.save();
    }
}
