package kotlin_oop.funcionario

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double
) {

    open val porcentagemBonificacao: Double = 0.03

    val bonificacao: Double get() = salario * porcentagemBonificacao

}