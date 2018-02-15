package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.Mysticis;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.*;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class MysticisConfig extends Configuration{

    public MysticisConfig(){
        super(new File("configs/"+ Mysticis.ID+".cfg"));
        load();
        addCustomCategoryComment("mana", "Things about Mana system");
        save();
        new Timer("Mysticis Config Saver").schedule(new TimerTask() {
            @Override
            public void run() {
                save();
            }
        }, 0, 5000);
    }

    public boolean showManaHud(){
        return get("mana", "show_hud", true).getBoolean();
    }

    public int getManaHudX(){
        return get("mana", "hud_x", 30).getInt();
    }

    public int getManaHudY(){
        return get("mana", "hud_y", 30).getInt();
    }
}
