package com.snopdev.model

import com.snopdev.enums.TransactionStatus
import com.snopdev.enums.TransactionType

class User(
    private var name: String,
    private var email: String,
    private var codeAccount: String,
    private var balance: Double,
) {

    private val transactions = mutableListOf<Transaction>()

    companion object {
        const val ZERO: Double = 0.0
    }

    fun getName(): String = name
    fun getEmail(): String = email
    fun getCodeAccount(): String = codeAccount
    fun getBalance(): Double = balance
    fun getTransactions(): List<Transaction> = transactions

    fun setName(name: String) {
        this.name = name
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setCodeAccount(codeAccount: String) {
        this.codeAccount = codeAccount
    }

    fun setBalance(balance: Double) {
        this.balance = balance
    }

    fun setTransactions(transactions: List<Transaction>) {
        this.transactions.addAll(transactions)
    }

    fun realizeNewDeposit(value: Double) {

        if (!this.validateValue(value)) {
            this.addValue(value)

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.DEPOSIT,
                status = TransactionStatus.SUCCESS,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Deposit made successfully, new balance: ${getBalance()}.")
        } else {

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.DEPOSIT,
                status = TransactionStatus.FAIL,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Value: $value must be bigger than $ZERO")
        }
    }

    fun realizeNewTransfer(value: Double, user: User) {

        if (this.validateValue(value) || this.validateValueToDepositOrTransfer(value)) {

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.TRANSFER,
                status = TransactionStatus.FAIL,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Balance insufficient or value is less than zero to realize transfer.")
            println("Balance available: ${getBalance()}")
        } else {
            this.discountValue(value)
            user.addValue(value)

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.TRANSFER,
                status = TransactionStatus.SUCCESS,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Transfer made successfully, new balance: ${getBalance()}.")
        }
    }

    fun realizeNewWithdraw(value: Double) {

        if (this.validateValue(value) || this.validateValueToDepositOrTransfer(value)) {

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.WITHDRAW,
                status = TransactionStatus.FAIL,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Balance insufficient or value is less than zero to realize withdraw.")
            println("Balance available: ${getBalance()}")
        } else {
            this.discountValue(value)

            val transaction = Transaction(
                amount = value,
                transactionType = TransactionType.WITHDRAW,
                status = TransactionStatus.SUCCESS,
                toAccount = codeAccount
            )

            transactions.add(transaction)

            println("Withdraw made successfully, new balance: ${getBalance()}.")
        }
    }

    private fun validateValue(value: Double): Boolean {
        return value <= ZERO
    }

    private fun validateValueToDepositOrTransfer(value: Double): Boolean {
        return value > getBalance()
    }

    private fun discountValue(value: Double) {

        val newBalance: Double = getBalance() - value
        setBalance(newBalance)
    }

    private fun addValue(value: Double) {

        val newBalance: Double = getBalance() + value
        setBalance(newBalance)
    }

    override fun toString(): String {
        return "User(name='$name', email='$email', codeAccount='$codeAccount', balance=$balance)"
    }

}