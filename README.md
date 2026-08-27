## Banking Core Engine (Java)

A modular, Object-Oriented Core Banking Engine built with Java. The system simulates fundamental banking operations, including account management, transaction logging, funds transfers, and domain-specific business rule validation.

---

## Key Features
- **Account Management:** Supports multiple account types (`SavingsAccount`, `CheckingAccount`) with specialized behavior.
- **Overdraft Protection:** `CheckingAccount` allows negative balance up to a defined credit limit.
- **Interest Calculation:** `SavingsAccount` supports automated interest accrual.
- **Transaction Auditing:** Thread-safe and immutable transaction logs for tracking account history.
- **Error Handling:** Custom Checked and Runtime exceptions for robust domain validation.

---

## OOP & Architectural Concepts Demonstrated

* **Abstraction:** Defined contract via `AccountOperations` interface and base class `Account`.
* **Encapsulation:** Class fields are private/protected; immutable collections protect transaction logs from external tampering.
* **Inheritance & Polymorphism:** Polymorphic behavior on withdraw logic across derived account implementations.
* **Collections Framework:** Managed account storage and retrieval using `HashMap` and `ArrayList`.
* **Exception Handling:** Domain-specific exceptions (`InsufficientFundsException`, `AccountNotFoundException`).

---

Project Structure

```text
src/
└── com/bank/
    ├── Main.java                        # Application entry point & demo
    ├── exception/
    │   ├── AccountNotFoundException.java   # Runtime exception
    │   └── InsufficientFundsException.java # Checked exception
    ├── model/
    │   ├── Account.java                 # Abstract base class
    │   ├── CheckingAccount.java         # Overdraft implementation
    │   ├── SavingsAccount.java          # Interest implementation
    │   └── Transaction.java             # Value object / audit record
    └── service/
        ├── AccountOperations.java       # Interface
        └── BankService.java             # Business logic & transfers
```
## Getting Started

### Prerequisites

* Java JDK 17 or higher
* Git

### How to Run
    1. Clone the repository: 
        git clone [https://github.com/](https://github.com/)gitKyrinas/banking-core-engine.git
    2. Navigate to the project directory:
        cd banking-core-engine
    3. Compile all source files:
        javac -d bin src/com/bank/**/*.java src/com/bank/*.java
    4. Run the application:
        java -cp bin com.bank.Main


### Author
* LinkedIn: https://www.linkedin.com/in/charisios-kyrinas-450229277/
* Email: charkyrinas@gmail.com
