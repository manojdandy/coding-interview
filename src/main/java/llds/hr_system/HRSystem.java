package llds.hr_system;

import java.util.List;

public class HRSystem {
    private final MessageQueue queue;

    public HRSystem(MessageQueue queue) {
        this.queue = queue;
    }
    public void emitUserIds(List<Integer> userIds) {
        for(int id:userIds) {
            queue.send(id);
        }
    }
}
