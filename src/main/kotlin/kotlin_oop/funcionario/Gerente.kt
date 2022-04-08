package kotlin_oop.funcionario

import kotlin_oop.autenticacao.Autenticavel

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val plr: Double
) : Funcionario(nome, cpf, salario), Autenticavel {

    override val porcentagemBonificacao: Double = 0.05

    override fun autenticar(senha: String): Boolean {
        return senha == "123456"
    }

}