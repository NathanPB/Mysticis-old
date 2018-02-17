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
        living.getEntityData().setTag("mysticis:affinity", this.toTag());
        new AffinityUpdateEvent(this, living).post(MinecraftForge.EVENT_BUS);
    }

    public static AffinityData from(EntityLivingBase living){
        return new AffinityData(Optional.of(living.getEntityData().getCompoundTag("mysticis:affinity")).orElse(new NBTTagCompound()));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e){
        AffinityData af = from(e.player);
        ManaData mana = from(e.player);

        //decrease/increase mana according to affinity
        //todo chance by level when its done
        ManaData md = new ManaData();
            md.AIR = af.AIR - 50;
            md.FIRE = af.FIRE - 50;
            md.WATER = af.WATER - 50;
            md.ICE = af.ICE - 50;
            md.NATURE = af.NATURE - 50;
            md.MAGIC = af.MAGIC - 50;
            md.DARK = af.DARK - 50;
        mana.sum(md);
        mana.store(e.player);
    }
}
