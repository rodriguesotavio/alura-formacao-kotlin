package kotlin_oop.banco

import kotlin_oop.cliente.Cliente

class ContaCorrente(
    titular: Cliente,
    numero: Int
): Conta(titular, numero) {

    override fun sacar(valor: Double) {
        val valorComTaxa = valor + 0.1
        super.sacar(valorComTaxa)
    }

}