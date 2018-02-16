package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.events.AffinityUpdateEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;

import java.util.Optional;

public class AffinityData extends ManaData{
    public AffinityData(NBTTagCompound compound){
        super(compound);
        set(50, Type.values());
    }

    @Override
    public ManaData set(int value, Type... types) {
        if(value > 0 && value < 100) {
            return super.set(value, types);
        } else {
            return this;
        }
    }

    @Override
    public void store(EntityLivingBase living) {
        living.getEntityData().setTag("mysticis:affinity", this);
       new AffinityUpdateEvent(this, living).post(MinecraftForge.EVENT_BUS);
    }


    public static AffinityData from(EntityLivingBase living){
        return new AffinityData(Optional.of(living.getEntityData().getCompoundTag("mysticis:affinity")).orElse(new NBTTagCompound()));
    }
}
