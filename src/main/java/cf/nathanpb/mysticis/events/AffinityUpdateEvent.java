package cf.nathanpb.mysticis.events;

import cf.nathanpb.mysticis.data.AffinityData;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class AffinityUpdateEvent extends EntityEvent implements IEvent{
    private AffinityData affinity;

    public AffinityUpdateEvent(AffinityData affinity, EntityLivingBase entity){
        super(entity);
        this.affinity = affinity;
    }

    @Override
    public Event getInstance() {
        return this;
    }

    public AffinityData getAffinity() {
        return affinity;
    }
}
