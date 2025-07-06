package llds.paymentsystem.service;

import llds.paymentsystem.dto.InstrumentDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InstrumentService {
    Map<Integer, List<InstrumentDTO>> instruments = new HashMap<>();
    public void add(InstrumentDTO dto);
    public void remove(InstrumentDTO dto);
}
