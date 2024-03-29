package cf.nathanpb.mysticis.common.item;

import cf.nathanpb.mysticis.common.data.AffinityData;
import cf.nathanpb.mysticis.common.data.ManaData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMysticis extends ItemBase{

    public ItemMysticis(){
        super("mysticis");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            AffinityData toSum = new AffinityData();
            toSum.FIRE = 1;
            toSum.WATER = -1;

            ManaData m = AffinityData.from(player).sum(toSum);
            m.store(player);
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
