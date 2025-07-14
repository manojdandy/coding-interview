package llds.rate_limiter.request;

public abstract class Request {
    String serviceName;
    long timestamp;
    int count;

}
