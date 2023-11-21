# Bank Account System

This project is a simple Java-based bank account system that demonstrates various design patterns including Strategy, Singleton, Decorator, Adapter, Observer, and Factory.

## Table of Contents

- [Project Overview](#project-overview)
- [Design Patterns Used](#design-patterns-used)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [UML Class Diagram](#uml-class-diagram)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The bank account system showcases different types of accounts (SavingsAccount and CurrentAccount) and their functionalities such as depositing, withdrawing, and calculating interest. It employs various design patterns to manage different aspects of the accounts.

## Design Patterns Used

- Strategy Pattern: Used for implementing different account types (SavingsAccountType and CurrentAccountType) with varying interest calculation strategies.
- Singleton Pattern: Ensures only one instance of the Bank class exists throughout the application.
- Decorator Pattern: Allows additional functionalities to be added to accounts dynamically.
- Adapter Pattern: Adapts the legacy account operations to fit the Account interface.
- Observer Pattern: Notifies observers about changes in account balances.
- Factory Pattern: Creates instances of different account types using respective factories.

## Project Structure

The project is organized into several Java files:
- Bank.java: Implements the Singleton pattern for the bank entity.
- Account.java: Defines the Account interface.
- SavingsAccount.java and CurrentAccount.java: Implement different account functionalities.
- LegacyAccount.java and LegacyAccountAdapter.java: Demonstrate the Adapter pattern.
- AccountObserver.java: Implements the Observer pattern.
- AccountFactory.java, SavingsAccountFactory.java, and CurrentAccountFactory.java: Showcases the Factory pattern.
- Main.java: Contains the main method to run the application.

## How to Run

To run the project:
1. Ensure you have Java installed on your system.
2. Compile all the Java files using javac *.java.
3. Run the application using java Main.java.

## UML Class Diagram

The UML Class Diagram for the project can be found in the repository. It visually represents the relationships between classes, methods, and their attributes. 

## Challenges faced

We faced challenges concerning the implementation of all 6 patterns in one project, since it was the first we did something like that.

## Future Improvements

The project can be further enhanced by adding database for users bank accounts and a system of loans. For a complete and production-ready system, error handling, security measures would need to be incorporated.
