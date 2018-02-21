package cf.nathanpb.mysticis.common.data;

import cf.nathanpb.mysticis.common.events.LevelUpdateEvent;
import cf.nathanpb.mysticis.utils.LevelUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;

public class LevelData {
    public long exp = 1L;
    public long expToLevelUp = 1L;
    public int level = 1;

    public LevelData(long exp){
        this.exp = exp;
        update();
    }


    public long toLevelUp(){
        return expToLevelUp;
    }

    public void update(){
        level = LevelUtils.expToLevel(exp);
        expToLevelUp = LevelUtils.expToLevel(level+1);
    }

    public static LevelData from(EntityLivingBase e){
        return new LevelData(e.getEntityData().getLong("mysticis:leveling"));
    }

    public void store(EntityLivingBase e){
        e.getEntityData().setLong("mysticis:leveling", exp);
        new LevelUpdateEvent(this, e).post(MinecraftForge.EVENT_BUS);
    }


}
