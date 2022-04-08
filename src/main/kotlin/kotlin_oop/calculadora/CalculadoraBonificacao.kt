package kotlin_oop.calculadora

import kotlin_oop.funcionario.Funcionario

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registrar(funcionario: Funcionario) {
        this.total += funcionario.bonificacao
    }

}