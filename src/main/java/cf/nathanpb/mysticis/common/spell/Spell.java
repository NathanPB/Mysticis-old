package cf.nathanpb.mysticis.common.spell;

import cf.nathanpb.mysticis.common.data.AffinityData;
import cf.nathanpb.mysticis.common.data.ManaData;
import cf.nathanpb.mysticis.common.spell.casting.SpellCastingBase;
import cf.nathanpb.mysticis.common.spell.elements.SpellElementBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spell {
    private SpellCastingBase casting;
    private List<SpellElementBase> elements;

    private ManaData mana = new ManaData();
    private AffinityData affinity = new AffinityData();
    private EntityLivingBase entity;


    public Spell(EntityLivingBase entity, SpellCastingBase casting, SpellElementBase... elements){
        this.casting = casting;
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.entity = entity;

        this.elements.stream()
                .filter(e -> !this.elements.stream().anyMatch(e2 -> e.type() == e2.type().getAgainst()))
                .collect(Collectors.toList());

        if(casting != null){
            mana = casting.getManaUse();
            affinity = casting.getAffinityGiven();
        }
        for(SpellElementBase e : elements){
            mana.sum(e.getManaUse());
            affinity.sum(e.getAffinityGiven());
        }
    }

    public void trigger(){
        if(casting != null){
            ManaData post = ManaData.from(entity).decrease(mana);
            if(!post.hasNegatives()) {
                post.store(entity);
                AffinityData.from(entity).sum(affinity).store(entity);
                casting.cast();
            }

        }
    }

    public static Spell from(ItemStack item, EntityLivingBase entity){
        try {
            if (item.getTagCompound() == null) {
                item.setTagCompound(new NBTTagCompound());
            }
            NBTTagCompound nbt = item.getTagCompound().getCompoundTag("mysticis:spell");

            if (nbt.hasKey("casting") && nbt.hasKey("elements")) {
                SpellCastingBase casting = SpellCastingBase.fromId(nbt.getInteger("casting")).newInstance();
                List<SpellElementBase> elements = new ArrayList<>();
                for(int i : nbt.getIntArray("elements")){
                    elements.add(SpellElementBase.fromId(i).newInstance());
                }
                return new Spell(entity, casting, elements.toArray(new SpellElementBase[elements.size()]));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
