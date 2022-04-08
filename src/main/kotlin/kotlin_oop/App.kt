package kotlin_oop

import kotlin_oop.autenticacao.Autenticavel
import kotlin_oop.autenticacao.SistemaInterno
import kotlin_oop.banco.ContaCorrente
import kotlin_oop.banco.ContaPoupanca
import kotlin_oop.calculadora.CalculadoraBonificacao
import kotlin_oop.cliente.Cliente
import kotlin_oop.cliente.Endereco
import kotlin_oop.exception.MyException
import kotlin_oop.funcionario.Desenvolvedor
import kotlin_oop.funcionario.Gerente
import java.lang.String as StringJava

fun main() {
    val stringJava = StringJava("String do Java!")
    // funcionarios()
    // bancos()
    // conhecendoAny()
    // exceptions()
    // nullSafety()
}

fun nullSafety() {
    // Null Safety
    // Nullable and Non-Null Types
    // The Billion Dollar Mistake

    var endereco: Endereco? = null

    try {
        // Not-Null assertion operator: !!
        println(endereco!!.logradouro)
    } catch (e: NullPointerException) {
        println("Endereço não é válido")
    }

    // Safe Calls

    println(endereco?.logradouro?.length) // null

    val endereco2 = Endereco(logradouro = "Rua Professor Domingos")

    var logradouro = ""
    endereco2?.let { ender: Endereco ->
        logradouro = ender.logradouro
    }
    println(logradouro)

    // Elvis Operator

    val nomeRua: String = endereco?.logradouro ?: "Nome inválido"
    println(nomeRua)

    // Safe Cast
    println(safeCast(valor = "Teste"))
    println(safeCast(valor = 123))
}

fun safeCast(valor: Any) : Int? {
    val numero: Int? = valor as? Int
    return numero
}

fun exceptions() {
    try {
        val endereco = Any()
        endereco as Endereco
    } catch (e: ClassCastException) {
        println(e)
    }

    try {
        val endereco = Endereco(
            logradouro = "Rua Professor Domingos",
            numero = 120
        )
        deveLancarException(endereco)
    } catch (e: Exception) {
        println(e)
    }

    // Try is an expression
    val entrada: String = "123.0"
    val valor: Double? = try { entrada.toDouble() } catch (e: NumberFormatException) { null }
    println(valor)

    // If is an expression
    val valorComTaxa: Double = if (valor != null) {
        valor + 0.1
    } else {
        0.0
    }
    println(valorComTaxa)

    // Custom exceptions
    try {
        deveLancarCustomException();
    } catch (e: MyException) {
        println(e)
    } catch (e: Exception) {
        println("Capturando um tipo mais genérico de exception...")
    }
}

fun deveLancarCustomException() {
    throw MyException(message = "Deu erro!");
}

fun deveLancarException(endereco: Endereco) {
    if (endereco.numero == 120) {
        throw Exception("Endereço inválido")
    }
}

fun conhecendoAny() {
    println(Unit) // Unit não devolve nada, mas também é considero um objeto
    println(Any()) // Em runtime é convertido para java.lang.Object
    println()
    println("")
    println(1)
    println(1.0)
    println(true)
    println(null)

    val endereco: Any = Endereco(logradouro = "Rua Professor Domingos", numero = 120)
    println(endereco)

    val enderecoCast: Endereco = endereco as Endereco
    enderecoCast.numero = 30
    println(enderecoCast)

    smartCast(endereco)
    instanceOf(endereco)

    // Equals, hashcode ("RG" do objeto, identificar o objeto), toString
    val endereco1 = Endereco()
    val endereco2 = Endereco()

    println("${endereco1.javaClass}@${Integer.toHexString(endereco1.hashCode())}")
}

fun smartCast(endereco: Any) {
    endereco as Endereco
    println(endereco.logradouro)
}

fun instanceOf(endereco: Any) {
    if (endereco is Endereco) {
        println(endereco)
    }
}

fun bancos() {
    val endereco = Endereco(
        logradouro = "Rua Professor Domingos",
        numero = 120
    )

    val poupanca = ContaPoupanca(
        titular = Cliente(nome = "Otávio", cpf = "", endereco = endereco),
        numero = 45687
    )
    println("Endereço: ${poupanca.titular.endereco.logradouro} ${poupanca.titular.endereco.numero}")

    val corrente = ContaCorrente(
        titular = Cliente(nome = "João", cpf = ""),
        numero = 26589
    )

    poupanca.depositar(150.0)
    corrente.depositar(150.0)

    poupanca.sacar(100.0)
    corrente.sacar(100.0)

    println("Saldo poupança: ${poupanca.saldo}")
    println("Saldo corrente: ${corrente.saldo}")

    // Objetos anônimos / Object expressions
    val contaBancaria = object : Autenticavel {
        val nome: String = "Otávio"
        val cpf: String = "000.000.000-00"

        fun myFunc() = println("Nome: $nome, CPF: $cpf")

        override fun autenticar(senha: String): Boolean {
            println("Autenticando...")
            return true
        }
    }

    contaBancaria.myFunc()

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entrar(contaBancaria, "123456")
}

fun funcionarios() {
    val funcionario = Desenvolvedor(
        nome = "Otávio",
        cpf = "000.000.000-00",
        salario = 10000.0
    )
    val gerente = Gerente(
        nome = "João",
        cpf = "000.000.000-00",
        salario = 12000.0,
        plr = 3000.0
    )

    println("${funcionario.nome} ${funcionario.cpf} ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao}")

    println("${gerente.nome} ${gerente.cpf} ${gerente.salario}")
    println("Bonificação: ${gerente.bonificacao}")

    val calculadora = CalculadoraBonificacao()
    calculadora.registrar(funcionario)
    calculadora.registrar(gerente)
    println("Total bonificação: ${calculadora.total}")

    val sistemaInterno = SistemaInterno()

    val cliente = Cliente(nome = "José", "000.000.000-00")

    println("Autenticação Funcionário: ${sistemaInterno.entrar(usuario = gerente, senha = "123456")}")
    println("Autenticação Cliente: ${sistemaInterno.entrar(usuario = cliente, senha = "654321")}")
}