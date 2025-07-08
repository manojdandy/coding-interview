package llds.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class PaymentGraph {
    private  final Map<String, BalanceMap> graph;

    public PaymentGraph() {
        graph = new HashMap<String,BalanceMap>();
    }

    public PaymentGraph(Map<String, BalanceMap> graph) {
        this.graph = graph;
    }
}
