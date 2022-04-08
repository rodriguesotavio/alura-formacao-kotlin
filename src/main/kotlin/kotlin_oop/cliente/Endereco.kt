package kotlin_oop.cliente

class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
) {

    override fun toString(): String {
        return """Endereco(
    logradouro='$logradouro', 
    numero=$numero, 
    bairro='$bairro', 
    cidade='$cidade', 
    estado='$estado', 
    cep='$cep', 
    complemento='$complemento'
)""".trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (logradouro != other.logradouro) return false

        return true
    }

    override fun hashCode(): Int {
        return logradouro.hashCode()
    }

}