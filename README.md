# Bank Account Simulation (Java)

## 📌 Overview

This is my solution for **Task 5: Bank Account Simulation** given in the Java Developer Internship.
It is a **console-based banking system** that simulates real-world account operations like deposit, withdraw, and viewing transaction history.

---

## ✅ What I Have Done

* Created an **Account class** with fields (Account Holder, Balance, Transaction History).
* Implemented **deposit()** and **withdraw()** methods.
* Used **ArrayList** to maintain transaction history dynamically.
* Added **SavingsAccount** (with interest feature) and **CurrentAccount** (with overdraft limit) by using **Inheritance**.
* Demonstrated **method overriding** in `withdraw()` for CurrentAccount.
* Developed a **menu-driven system** for Deposit, Withdraw, Balance Check, Transaction History, Exit.
* Added **input validation** for invalid amounts, insufficient balance, and overdraft limit.
* Displayed **clear error messages** for invalid transactions.
* Wrote a **README.md** to explain project structure and usage.

---

## 🚀 How to Run

1. Clone or download this repository.
2. Open the project in **VS Code / IntelliJ / Terminal**.
3. Compile the Java file:

   ```bash
   javac BankAccountSimulation.java
   ```
4. Run the program:

   ```bash
   java BankAccountSimulation
   ```
5. Follow the **menu options** to interact with the banking system.

---

## 📚 Example Run

```
Choose Account Type:
1. Savings Account
2. Current Account
Enter choice: 1
Enter Account Holder Name: Rahul
Enter Initial Balance: 1000

===== Bank Menu =====
1. Deposit
2. Withdraw
3. Check Balance
4. Transaction History
5. Apply Interest
6. Exit

Choose option: 1
Enter amount to deposit: 500
✅ Deposit successful!

Choose option: 5
✅ Interest applied! New Balance: 1575.0
```

---

## 🛠 Concepts Used

* **Classes & Objects**
* **Inheritance** (SavingsAccount & CurrentAccount extend Account)
* **Method Overriding** (`withdraw()` in CurrentAccount)
* **Encapsulation** (private/protected fields)
* **ArrayList** for transaction history
* **Menu-driven program with exception handling & input validation**
