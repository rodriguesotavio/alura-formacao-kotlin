package kotlin_oop.autenticacao

class SistemaInterno {

    fun entrar(usuario: Autenticavel, senha: String) : Boolean {
        return usuario.autenticar(senha)
    }

}