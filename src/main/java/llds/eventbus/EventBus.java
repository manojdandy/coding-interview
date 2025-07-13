package llds.eventbus;

import java.util.HashMap;
import java.util.Map;

public class EventBus {
    private final Map<String,Event> eventMap;

    public EventBus() {
        this.eventMap = new HashMap<>();
    }
}
