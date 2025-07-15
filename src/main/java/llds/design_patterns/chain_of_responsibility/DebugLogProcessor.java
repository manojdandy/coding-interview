package llds.design_patterns.chain_of_responsibility;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel,String msg) {
        if(DEBUG == logLevel) {
            System.out.println("DEBUG : " + msg);
        }else {
            super.log(logLevel,msg);
        }
    }
}
