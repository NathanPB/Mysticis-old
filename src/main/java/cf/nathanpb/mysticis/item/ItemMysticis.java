package cf.nathanpb.mysticis.item;

import cf.nathanpb.mysticis.data.AffinityData;
import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.hud.HudConfigEditor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

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
            System.out.println("a: "+m);
            m.store(player);
            System.out.println("b: "+AffinityData.from(player));
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
