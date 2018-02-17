package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.events.ManaUpdateEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class ManaData{

    public int
        AIR = 0,
        FIRE = 0,
        WATER = 0,
        ICE = 0,
        NATURE = 0,
        MAGIC = 0,
        DARK = 0;



    public ManaData(){}
    public ManaData(NBTTagCompound compound){
        init(compound);
    }

    protected void init(NBTTagCompound c){
        AIR = c.getInteger("AIR");
        FIRE = c.getInteger("FIRE");
        WATER = c.getInteger("WATER");
        ICE = c.getInteger("ICE");
        NATURE = c.getInteger("NATURE");
        MAGIC = c.getInteger("MAGIC");
        DARK = c.getInteger("DARK");
    }

    public ManaData sum(ManaData data){
        AIR += data.AIR;
        FIRE += data.FIRE;
        WATER += data.WATER;
        ICE += data.ICE;
        NATURE += data.NATURE;
        MAGIC += data.MAGIC;
        DARK += data.DARK;
        return this;
    }

    public ManaData decrease(ManaData data){
        sum(data.reverse());
        return this;
    }

    public ManaData reverse(){
        AIR = -AIR;
        FIRE = -FIRE;
        WATER = -WATER;
        ICE = -ICE;
        NATURE = -NATURE;
        MAGIC = -MAGIC;
        DARK = -DARK;
        return this;
    }

    public static ManaData from(EntityLivingBase living){
        return new ManaData(Optional.of(living.getEntityData().getCompoundTag("mysticis:mana")).orElse(new NBTTagCompound()));
    }

    public void store(EntityLivingBase living){
        if(AIR < 0) AIR = 0;
        if(FIRE < 0) FIRE = 0;
        if(WATER < 0) WATER = 0;
        if(ICE < 0) ICE = 0;
        if(NATURE < 0) NATURE = 0;
        if(MAGIC < 0) MAGIC = 0;
        if(DARK < 0) DARK = 0;
        living.getEntityData().setTag("mysticis:mana", this.toTag());
        new ManaUpdateEvent(this, living).post(MinecraftForge.EVENT_BUS);
    }

    public NBTTagCompound toTag(){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("AIR", AIR);
        nbt.setInteger("FIRE", FIRE);
        nbt.setInteger("WATER", WATER);
        nbt.setInteger("ICE", ICE);
        nbt.setInteger("NATURE", NATURE);
        nbt.setInteger("MAGIC", MAGIC);
        nbt.setInteger("DARK", DARK);
        return nbt;
    }

    public static int
            colorAir = Integer.parseInt("FFFF55", 16),
            colorFire = Integer.parseInt("AA0000", 16),
            colorWater = Integer.parseInt("0000AA", 16),
            colorIce = Integer.parseInt("00AAAA", 16),
            colorNature = Integer.parseInt("00AA00", 16),
            colorMagic = Integer.parseInt("AA00AA", 16),
            colorDark = Integer.parseInt("460860", 16);

}