package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.events.ManaUpdateEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;

import java.util.Optional;
import java.util.stream.Stream;

public class ManaData extends NBTTagCompound{

    public ManaData(NBTTagCompound compound){
        Stream.of(Type.values())
                .filter(t -> compound.hasKey(t.name()))
                .forEach(t -> set(compound.getInteger(t.name()), t));
    }

    public int get(Type... types){
        if(types.length == 0) types = Type.values();
        int value = 0;
        for(Type t : types){
            if(hasKey(t.name())) {
                value += getInteger(t.name());
            }
        }
        return value;
    }

    public ManaData set(int value, Type... types){
        if(types.length == 0) types = Type.values();
        Stream.of(types).forEach(t -> setInteger(t.name(), value));
        return this;
    }

    public ManaData sum(ManaData data){
        Stream.of(Type.values()).forEach(t -> set(data.get(t)+get(t), t));
        return this;
    }

    public ManaData decrease(ManaData data){
        sum(data.reverse());
        return this;
    }

    public ManaData reverse(){
        Stream.of(Type.values()).forEach(t -> set( -get(t), t));
        return this;
    }

    public static ManaData from(EntityLivingBase living){
        return new ManaData(Optional.of(living.getEntityData().getCompoundTag("mysticis:mana")).orElse(new NBTTagCompound()));
    }

    public void store(EntityLivingBase living){
        living.getEntityData().setTag("mysticis:mana", this);
        new ManaUpdateEvent(this, living).post(MinecraftForge.EVENT_BUS);
    }

    public String format() {
        String s = "[";
        for(Type t : Type.values()){
            s+=t.name()+": "+get(t)+", ";
        }
        s = s.substring(0, s.length()-2);
        return s+"]";
    }

    public enum Type{
        AIR, FIRE, WATER, ICE, NATURE, MAGIC, DARK;
    }
}