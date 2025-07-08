package llds.splitwise.service;

import llds.splitwise.models.Expense;
import llds.splitwise.models.Group;
import llds.splitwise.models.PaymentGraph;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupService {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        q.add(10);q.add(2);q.add(20);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
//    private final ExpenseService expenseService;
//    private final Map<String, Group> groups;
//
//    public GroupService(ExpenseService expenseService) {
//        this.expenseService = expenseService;
//    }
//    public PaymentGraph getGroupPaymentGraph(final String groupId, final String userId) {
//        List<Expense> groupExpenses = expenseService.getGroupExpenses(groupId);
//        Expense resultExpense = sumExpenses(groupExpenses);
//        return  expenseService.getPaymentGraph(resultExpense);
//    }
//
//    public Expense getBalances(final  String groupId) {
//
//    }
}
