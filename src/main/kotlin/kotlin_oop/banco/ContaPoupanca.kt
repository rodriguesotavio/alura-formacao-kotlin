package kotlin_oop.banco

import kotlin_oop.cliente.Cliente

class ContaPoupanca(
    titular: Cliente,
    numero: Int
): Conta(titular, numero) {

}