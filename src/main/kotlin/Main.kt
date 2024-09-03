package com.snopdev

import com.snopdev.model.User

fun main() {

    val user = User (
        name = "John K",
        email = "john@gmail.com",
        codeAccount = "1",
        balance = 1000.0,
    )

    val newUser = User (
        name = "Trevor",
        email = "trevor@gmail.com",
        codeAccount = "2",
        balance = 500.0,
    )

    println("Data user: $user")
    println("Data newUser: $newUser")
    println()

    user.realizeNewDeposit(0.0)
    user.realizeNewDeposit(100.0)
    println()

    user.realizeNewTransfer(0.0, newUser)
    user.realizeNewTransfer(1200.0, newUser)
    user.realizeNewTransfer(50.0, newUser)
    println()

    user.realizeNewWithdraw(0.0)
    user.realizeNewWithdraw(1200.0)
    user.realizeNewWithdraw(150.0)
    println()

    println("Data: $newUser")
    println()

    user.getTransactions().forEach {
        println("Transaction: ${it.getTransactionType()}, Amount: ${it.getAmount()}, Status: ${it.getStatus()}, Code Account: ${it.getToAccount()}")
    }
}