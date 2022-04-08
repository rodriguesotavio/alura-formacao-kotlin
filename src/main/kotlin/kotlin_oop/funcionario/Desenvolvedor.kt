package kotlin_oop.funcionario

class Desenvolvedor(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(nome, cpf, salario) {

    override val porcentagemBonificacao: Double
        get() = 0.04

}