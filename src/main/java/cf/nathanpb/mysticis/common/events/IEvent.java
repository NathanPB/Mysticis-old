package cf.nathanpb.mysticis.common.events;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public interface IEvent {
    default void post(EventBus bus){
        bus.post(getInstance());
    }

    Event getInstance();
}
