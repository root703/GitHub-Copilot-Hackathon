class PersonalFinanceTracker {
  constructor() {
    this.transactions = [];
  }

  addTransaction(description, amount) {
    const transaction = { description, amount };
    this.transactions.push(transaction);
  }

  getIncome() {
    let income = 0;
    for (const transaction of this.transactions) {
      if (transaction.amount > 0) {
        income += transaction.amount;
      }
    }
    return income;
  }

  getExpenses() {
    let expenses = 0;
    for (const transaction of this.transactions) {
      if (transaction.amount < 0) {
        expenses += transaction.amount;
      }
    }
    return expenses;
  }

  getAccountBalance() {
    let balance = 0;
    for (const transaction of this.transactions) {
      balance += transaction.amount;
    }
    return balance;
  }

  getTransactionHistory() {
    console.log("Transaction History:");
    for (const transaction of this.transactions) {
      console.log(
        `${transaction.description}: ${transaction.amount.toFixed(2)}`
      );
    }
  }
}

// Example usage
const financeTracker = new PersonalFinanceTracker();

financeTracker.addTransaction("Salary", 3000);
financeTracker.addTransaction("Rent", -1000);
financeTracker.addTransaction("Groceries", -200);
financeTracker.addTransaction("Bonus", 500);

financeTracker.getTransactionHistory();

console.log("Income:", financeTracker.getIncome().toFixed(2));
console.log("Expenses:", financeTracker.getExpenses().toFixed(2));
console.log("Account Balance:", financeTracker.getAccountBalance().toFixed(2));
