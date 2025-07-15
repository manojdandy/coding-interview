package llds.design_patterns.chain_of_responsibility;

public class TestLogProcessor {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR,"this is test msf");

    }
}
