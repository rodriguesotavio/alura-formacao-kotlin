package kotlin_oop.cliente

import kotlin_oop.autenticacao.Autenticavel

class Cliente(
    val nome: String,
    val cpf: String,
    var endereco: Endereco = Endereco()
) : Autenticavel {

    override fun autenticar(senha: String): Boolean {
        return false
    }

}