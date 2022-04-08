package kotlin_oop.banco

import kotlin_oop.cliente.Cliente

abstract class Conta(
    val titular: Cliente,
    val numero: Int) {

    var saldo = 0.0
        private set

    companion object Contador {
        var totalContas: Int = 0
            private set
    }

    init {
        totalContas++
        println("Total contas: $totalContas")
    }

    fun depositar(valor: Double) {
        this.saldo += valor
    }

    open fun sacar(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        }
    }

    fun transferir(valor: Double, contaDestino: Conta): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            contaDestino.depositar(valor)
            return true
        }
        return false
    }

}