package cf.nathanpb.mysticis.common.events;

import cf.nathanpb.mysticis.common.data.ManaData;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ManaUpdateEvent extends EntityEvent implements IEvent{

    private ManaData mana;

    public ManaUpdateEvent(ManaData data, EntityLivingBase living){
        super(living);
        this.mana = data;
    }

    @Override
    public Event getInstance() {
        return this;
    }

    public ManaData getMana() {
        return mana;
    }
}
