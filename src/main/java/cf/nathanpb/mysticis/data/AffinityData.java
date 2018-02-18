package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.events.AffinityUpdateEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Optional;
import java.util.Random;

@Mod.EventBusSubscriber
public class AffinityData extends ManaData{


    public AffinityData(){}
    public AffinityData(NBTTagCompound compound){
        super(compound);
    }

    @Override
    protected void initIfBlank() {
        super.initIfBlank();
        AIR = 50;
        FIRE = 50;
        WATER = 50;
        ICE = 50;
        NATURE = 50;
        MAGIC = 50;
        DARK = 50;
    }

    @Override
    public void store(EntityLivingBase living) {
        if(AIR < 0) AIR = 0;
        if(FIRE < 0) FIRE = 0;
        if(WATER < 0) WATER = 0;
        if(ICE < 0) ICE = 0;
        if(NATURE < 0) NATURE = 0;
        if(MAGIC < 0) MAGIC = 0;
        if(DARK < 0) DARK = 0;

        if(AIR > 100) AIR = 100;
        if(FIRE > 100) FIRE = 100;
        if(WATER > 100) WATER = 100;
        if(ICE > 100) ICE = 100;
        if(NATURE > 100) NATURE = 100;
        if(MAGIC > 100) MAGIC = 100;
        if(DARK > 100) DARK = 100;

        living.getEntityData().setTag("mysticis:affinity", this.toTag());
        new AffinityUpdateEvent(this, living).post(MinecraftForge.EVENT_BUS);
    }

    public static AffinityData from(EntityLivingBase living){
        return new AffinityData(Optional.of(living.getEntityData().getCompoundTag("mysticis:affinity")).orElse(new NBTTagCompound()));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e){
        AffinityData af = from(e.player);
        ManaData mana = ManaData.from(e.player);
        LevelData level = LevelData.from(e.player);

        ManaData md = new ManaData();
        int random = new Random().nextInt(1000);

        if(af.AIR < 50){
            if(random <= -(af.AIR-50) * 10){
                md.AIR--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.AIR+1){
                md.AIR++;
            }
        }

        if(af.FIRE < 50){
            if(random <= -(af.FIRE-50) * 10){
                md.FIRE--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.FIRE+1){
                md.FIRE++;
            }
        }

        if(af.WATER < 50){
            if(random <= -(af.WATER-50) * 10){
                md.WATER--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.WATER+1){
                md.WATER++;
            }
        }

        if(af.ICE < 50){
            if(random <= -(af.ICE-50) * 10){
                md.ICE--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.ICE+1){
                md.ICE++;
            }
        }

        if(af.NATURE < 50){
            if(random <= -(af.NATURE-50) * 10){
                md.NATURE--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.NATURE+1){
                md.NATURE++;
            }
        }

        if(af.MAGIC < 50){
            if(random <= -(af.MAGIC-50) * 10){
                md.MAGIC--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.MAGIC+1){
                md.MAGIC++;
            }
        }

        if(af.DARK < 50){
            if(random <= -(af.DARK-50) * 10){
                md.DARK--;
            }
        } else {
            if(random <= ((float) level.level/50) * af.DARK+1){
                md.DARK++;
            }
        }

        mana.sum(md);
        mana.store(e.player);
    }
}
