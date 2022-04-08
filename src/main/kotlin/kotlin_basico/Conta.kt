package kotlin_basico

class Conta(
    val titular: String,
    val numero: Int) {

    var saldo = 0.0
        private set

    fun depositar(valor: Double) {
        this.saldo += valor
    }

    fun sacar(valor: Double) {
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