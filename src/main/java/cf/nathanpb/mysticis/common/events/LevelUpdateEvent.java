package cf.nathanpb.mysticis.common.events;

import cf.nathanpb.mysticis.common.data.LevelData;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class LevelUpdateEvent extends EntityEvent implements IEvent{

    private LevelData level;

    public LevelUpdateEvent(LevelData level, EntityLivingBase e){
        super(e);
        this.level = level;
    }

    public LevelData getLevel() {
        return level;
    }

    @Override
    public Event getInstance() {
        return this;
    }
}
