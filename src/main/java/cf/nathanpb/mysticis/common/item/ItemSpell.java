package cf.nathanpb.mysticis.common.item;

import cf.nathanpb.mysticis.common.spell.Spell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSpell extends ItemBase {

    public ItemSpell(){
        super("spell");
        setCreativeTab(ModItems.CREATIVE_TAB);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            Spell s = Spell.from(player.inventory.getCurrentItem(), player);
            if(s != null){
                s.trigger();
            }
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
