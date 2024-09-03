package com.snopdev.model

import com.snopdev.enums.TransactionStatus
import com.snopdev.enums.TransactionType
import java.time.LocalDateTime
import java.util.*

class Transaction(
    private var transactionId: String = UUID.randomUUID().toString(),
    private var amount: Double,
    private var transactionType: TransactionType,
    private var createdAt: LocalDateTime = LocalDateTime.now(),
    private var fromAccount: String? = null,
    private var toAccount: String? = null,
    private var description: String? = null,
    private var status: TransactionStatus,
) {
    fun getTransactionId(): String = transactionId
    fun getAmount(): Double = amount
    fun getTransactionType(): TransactionType = transactionType
    fun getCreatedAt(): LocalDateTime = createdAt
    fun getFromAccount(): String? = fromAccount
    fun getToAccount(): String? = toAccount
    fun getDescription(): String? = description
    fun getStatus(): TransactionStatus = status

    fun setTransactionId(transactionId: String) {
        this.transactionId = transactionId
    }

    fun setAmount(amount: Double) {
        this.amount = amount
    }

    fun setTransactionType(transactionType: TransactionType) {
        this.transactionType = transactionType
    }

    fun setCreatedAt(createdAt: LocalDateTime) {
        this.createdAt = createdAt
    }

    fun setFromAccount(fromAccount: String?) {
        this.fromAccount = fromAccount
    }

    fun setToAccount(toAccount: String?) {
        this.toAccount = toAccount
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun setStatus(status: TransactionStatus) {
        this.status = status
    }
}