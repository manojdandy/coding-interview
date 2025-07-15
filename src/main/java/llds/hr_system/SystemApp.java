package llds.hr_system;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SystemApp {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        HRSystem hrSystem = new HRSystem(queue);
        WorkerService service = new WorkerService(queue,new HRAPI(),new SecurityAPI());
        new Thread(() -> {
            service.start();
        }).start();

       // new Thread(service::start).start();
        hrSystem.emitUserIds(Arrays.asList(1, 2, 3, 5, 3, 5, 5, 6, 7, 10, 12));
    }
}
