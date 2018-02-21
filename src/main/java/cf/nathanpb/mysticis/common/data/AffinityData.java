package cf.nathanpb.mysticis.common.data;

import cf.nathanpb.mysticis.common.events.AffinityUpdateEvent;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Optional;
import java.util.Random;

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

    @Mod.EventBusSubscriber
    public static class Factory {
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
            AffinityData af = from(e.player);
            ManaData mana = ManaData.from(e.player);
            LevelData level = LevelData.from(e.player);

            int random = new Random().nextInt(1000);

            if (af.AIR < 50) {
                if (random <= -(af.AIR - 50) * 10) {
                    mana.AIR--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.AIR + 1) {
                    mana.AIR++;
                }
            }

            if (af.FIRE < 50) {
                if (random <= -(af.FIRE - 50) * 10) {
                    mana.FIRE--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.FIRE + 1) {
                    mana.FIRE++;
                }
            }

            if (af.WATER < 50) {
                if (random <= -(af.WATER - 50) * 10) {
                    mana.WATER--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.WATER + 1) {
                    mana.WATER++;
                }
            }

            if (af.ICE < 50) {
                if (random <= -(af.ICE - 50) * 10) {
                    mana.ICE--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.ICE + 1) {
                    mana.ICE++;
                }
            }

            if (af.NATURE < 50) {
                if (random <= -(af.NATURE - 50) * 10) {
                    mana.NATURE--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.NATURE + 1) {
                    mana.NATURE++;
                }
            }

            if (af.MAGIC < 50) {
                if (random <= -(af.MAGIC - 50) * 10) {
                    mana.MAGIC--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.MAGIC + 1) {
                    mana.MAGIC++;
                }
            }

            if (af.DARK < 50) {
                if (random <= -(af.DARK - 50) * 10) {
                    mana.DARK--;
                }
            } else {
                if (random <= ((float) level.level / 50) * af.DARK + 1) {
                    mana.DARK++;
                }
            }

            if (random <= level.level) {
                BlockPos pos = e.player.getPosition();
                Biome b = e.player.world.getBiome(e.player.getPosition());

                if (e.player.isElytraFlying() || pos.getY() > 128) {
                    af.AIR++;
                }

                if (EnchantmentProtection.getFireTimeForEntity(e.player, 0) > 0) {
                    af.FIRE++;
                }

                if (e.player.world.getBlockState(pos).equals(Blocks.WATER)) {
                    af.WATER++;
                }

                if (b.getEnableSnow()) {
                    af.ICE++;
                }

                if (b.getBiomeName().contains("JUNGLE") || b.getBiomeName().contains("FOREST")) {
                    af.NATURE++;
                }

                af.store(e.player);
            }

            mana.store(e.player);
        }

        @SubscribeEvent
        public static void onEntityKilled(LivingDamageEvent e) {
            if (e.getSource().getTrueSource() instanceof EntityPlayerMP) {
                EntityPlayerMP p = ((EntityPlayerMP) e.getSource().getTrueSource());
                if (new Random().nextInt(100) <= LevelData.from(p).level) {
                    AffinityData a = AffinityData.from(p);
                    a.DARK++;
                    a.store(p);
                }
            }
        }
    }
}
