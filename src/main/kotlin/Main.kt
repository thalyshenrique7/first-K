package com.snopdev

import com.snopdev.com.snopdev.model.User

fun main() {

    val user = User (
        name = "John K",
        email = "john@gmail.com",
        codeAccount = "1",
        balance = 1000.0
    )

    println("Data: $user")
    println()

    user.realizeNewDeposit(0.0)
    user.realizeNewDeposit(100.0)
    println()

    user.realizeNewTransfer(1200.0)
    user.realizeNewTransfer(50.0)
    println()

    user.realizeNewWithdraw(1200.0)
    user.realizeNewWithdraw(150.0)
    println()
}