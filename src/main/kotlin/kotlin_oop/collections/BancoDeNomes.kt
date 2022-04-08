package kotlin_oop.collections

class BancoDeNomes {

    private val dados: MutableList<String> = mutableListOf<String>()
    val nomes: Collection<String> get() = dados.toList()

    fun salvar(nome: String) {
        dados.add(nome)
    }

}