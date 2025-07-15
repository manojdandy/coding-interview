package llds.design_patterns.chain_of_responsibility;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel,String msg) {
        if(INFO == logLevel) {
            System.out.println("INFO : " + msg);
        }else {
            super.log(logLevel,msg);
        }
    }
}
