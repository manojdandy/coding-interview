package llds.eventbus;

import java.util.function.Function;

public abstract class RetryAlgorithm<P,R>  {
    private int maxAttempts;
    public abstract void retry(Function<P,R> task,P parameter);
}
