package com.snopdev.com.snopdev.model

class User(
    private var name: String,
    private var email: String,
    private var codeAccount: String,
    private var balance: Double) {

    companion object {
        const val ZERO: Double = 0.0
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getCodeAccount(): String {
        return codeAccount
    }

    fun setCodeAccount(codeAccount: String) {
        this.codeAccount = codeAccount
    }

    fun getBalance(): Double {
        return balance
    }

    fun setBalance(balance: Double) {
        this.balance = balance
    }

    fun realizeNewDeposit(value: Double) {

        if (!this.validateValue(value)) {
            val newBalance: Double = value + getBalance()
            setBalance(newBalance)

            println("Deposit made successfully, new balance: ${getBalance()}.")
        }
    }

    fun realizeNewTransfer(value: Double) {

        if (this.validateValueToDepositOrTransfer(value)) {
            println("Balance insufficient or value is less than zero to realize transfer.")
            println("Balance available: ${getBalance()}")
        } else {
            this.discountValue(value)

            println("Transfer made successfully, new balance: ${getBalance()}.")
        }
    }

    fun realizeNewWithdraw(value: Double) {

        if (this.validateValueToDepositOrTransfer(value)) {
            println("Balance insufficient or value is less than zero to realize withdraw.")
            println("Balance available: ${getBalance()}")
        } else {
            this.discountValue(value)

            println("Withdraw made successfully, new balance: ${getBalance()}.")
        }
    }

    fun validateValue(value: Double): Boolean {

        if (value == ZERO || value < ZERO) {
            println("Value: $value must be bigger than $ZERO")
            return true;
        }

        return false;
    }

    fun validateValueToDepositOrTransfer(value: Double): Boolean {
        return value > getBalance()
    }

    fun discountValue(value: Double) {

        val newBalance: Double = getBalance() - value
        setBalance(newBalance)
    }

    override fun toString(): String {
        return "User(name='$name', email='$email', codeAccount='$codeAccount', balance=$balance)"
    }

}