package llds.splitwise.service;

import llds.splitwise.models.Amount;
import llds.splitwise.models.BalanceMap;
import llds.splitwise.models.Expense;
import llds.splitwise.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {

    @Test
    void addExpense() {
        final ExpenseService expenseService = new ExpenseService();
        String groupId = "Villa";

        BalanceMap expenses = new BalanceMap();
        expenses.getBalance().put("A",new Amount(10.0,"INR"));
        expenses.getBalance().put("B",new Amount(20.0,"INR"));
        expenses.getBalance().put("C",new Amount(-30.0,"INR"));
        Expense expense = new Expense(expenses,"Dinner",groupId);
        expenseService.addExpense(expense);
        //second expense
        BalanceMap secondExpense = new BalanceMap();
        secondExpense.getBalance().put("A",new Amount(-50.0,"INR"));
        secondExpense.getBalance().put("B",new Amount(10.0,"INR"));
        secondExpense.getBalance().put("C",new Amount(40.0,"INR"));
        Expense secExpense = new Expense(secondExpense,"Outing",groupId);
        expenseService.addExpense(secExpense);
        System.out.println(expenseService.getGroupExpenses());
        BalanceMap sumOfExpenses = expenseService.sumExpenses(expenseService.getGroupExpenses().get(groupId));
        expenseService.getPaymentGraph(sumOfExpenses);
    }

    @Test
    void getGroupExpenses() {
    }
}