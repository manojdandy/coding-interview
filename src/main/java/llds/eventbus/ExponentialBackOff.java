package llds.eventbus;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.function.Function;

public class ExponentialBackOff<P,R> extends RetryAlgorithm<P,R> {
    private final Timer timer;

    @Inject
    public ExponentialBackOff() {
        this.timer = new Timer();
    }

    @Override
    public void retry(Function<P,R> task, P parameter) {
        try {
            task.apply(parameter);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Singleton
class Timer {
    public long getTime() {
        return System.nanoTime();
    }
}