package llds.design_patterns.chain_of_responsibility;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel,String msg) {
        if(ERROR == logLevel) {
            System.out.println("ERROR : " + msg);
        }else {
            super.log(logLevel,msg);
        }
    }
}
