package llds.splitwise.service;

import llds.splitwise.models.*;

import java.util.*;

public class ExpenseService {
    private Map<String,List<Expense>> groupExpenses;


    public ExpenseService() {
        this.groupExpenses = new HashMap<>();
    }
    public void addExpense(Expense expense) {
        String groupID = expense.getGroupId();
        if(groupID != null) {
            groupExpenses.put(groupID,groupExpenses.getOrDefault(groupID,new ArrayList<>()));
            groupExpenses.get(groupID).add(expense);
        }
    }

    public Map<String, List<Expense>> getGroupExpenses() {
        return groupExpenses;
    }


   public PaymentGraph getPaymentGraph(BalanceMap balanceMap) {
        Comparator<Map.Entry<String,Amount>> comparator =
                Comparator.comparingDouble(balance -> balance.getValue().getAmount());
       PriorityQueue<Map.Entry<String,Amount>> positiveExpenses =
               new PriorityQueue<>(comparator.reversed());
       PriorityQueue<Map.Entry<String,Amount>> negativeExpenses = new PriorityQueue<>(comparator);
       for(Map.Entry<String,Amount> expense : balanceMap.getBalance().entrySet()) {
           if(expense.getValue().getAmount() > 0) {
               positiveExpenses.add(expense);
           }else  {
               negativeExpenses.add(expense);
           }
       }
       Map<String,BalanceMap> graph = new HashMap<String,BalanceMap>();

       while (!positiveExpenses.isEmpty()) {
           Map.Entry<String,Amount> largestPositive = positiveExpenses.poll();
           Map.Entry<String,Amount> largestNegative = negativeExpenses.poll();
           Double largestPositiveAmount = largestPositive.getValue().getAmount();
           Double largestNegativeAmount = -largestNegative.getValue().getAmount();
           graph.putIfAbsent(largestPositive.getKey(),new BalanceMap());
           graph.get(largestPositive.getKey()).getBalance().put(largestNegative.getKey(),
                   new Amount(Math.min(largestNegativeAmount,largestPositiveAmount),"INR"));
           double remaning = largestPositiveAmount - largestNegativeAmount;
           Amount remainingAmount = new Amount(remaning,"INR");
           if(remaning > 0) {
               positiveExpenses.add(new AbstractMap.SimpleEntry<>(largestPositive.getKey(),remainingAmount));
           }else if(remaning < 0) {
               negativeExpenses.add(new AbstractMap.SimpleEntry<>(largestNegative.getKey(),remainingAmount));
           }

       }
        return new PaymentGraph(graph);
   }
   BalanceMap sumExpenses(List<Expense> expenses) {
        Map<String,Amount> resultBalance = new HashMap<>();
        for(Expense expense : expenses) {
            for(Map.Entry<String,Amount> entry: expense.getUserBalances().getBalance().entrySet()) {
                String usr = entry.getKey();
                Amount amount = entry.getValue();
                resultBalance.put(usr,resultBalance.getOrDefault(usr,new Amount(0.0,"INR")).add(amount.getAmount()));
            }
        }
        return new BalanceMap(resultBalance);
   }
}
