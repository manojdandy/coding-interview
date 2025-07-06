package llds.paymentsystem.factory;

import llds.paymentsystem.enums.InstrumentType;
import llds.paymentsystem.service.BankInstrumentServiceImpl;
import llds.paymentsystem.service.CreditInstrumentServiceImpl;
import llds.paymentsystem.service.InstrumentService;

public class InstrumentFactory {
    public InstrumentService getInstrument(InstrumentType type) {
        if(InstrumentType.BANK.equals(type)) {
            return new BankInstrumentServiceImpl();
        } else if (InstrumentType.CARD.equals(type)) {
            return new CreditInstrumentServiceImpl();
        }
        throw new RuntimeException("No Instrument Found :: " + type);
    }
}
