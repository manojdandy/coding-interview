package llds.design_patterns.chain_of_responsibility;

public abstract class LogProcessor {
    static int DEBUG = 1;
    static int INFO = 2;
     static int ERROR = 3;
     LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }


    public void log(int logLevel,String msg) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel,msg);
        }
    }
}
