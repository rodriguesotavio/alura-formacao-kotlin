package kotlin_functional

import kotlin_oop.banco.ContaPoupanca
import kotlin_oop.cliente.Cliente
import kotlin_oop.cliente.Endereco

fun main() {
    // Conhecendo a programação funcional
    // Imutabilidade
    // Funções puras: quando executamos o código com base em seus parâmetros,
    // ele sempre deve retornar o mesmo valor. Não depende de nada externo.

    // Explorar técnicas que são comuns do paradigma funcional
    // O Kotlin é uma grande escolha para quem quer explorar o paradigma funcional

//    println(soma(1, 5))

//    functionTypes()
//    lambda()
//    higherOrderFunctions()
//    scopeFunctions()

    HOFWithReceivers()

}

fun HOFWithReceivers() {

    with(Endereco()) {
        logradouro = "Rua Professor Domingos"
        numero = 120
        bairro = "Independência"
        cidade = "Cachoeiro de Itapemirim"
        toString()
    }.let { enderecoCompleto: String -> println(enderecoCompleto) }

    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("Taxa Mensal: $taxaMensal")

    val contaPoupanca = Cliente(nome = "Otávio", cpf = "08355300602")
        .let { clienteNovo: Cliente ->
            ContaPoupanca(clienteNovo, 1233)
        }

    contaPoupanca
        .run {
            depositar(1000.0)
            saldo * taxaMensal
        }.let(::println)

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }
    println(rendimentoAnual)

    val somarComReceiver = fun(a: Int, b: Int, resultado: Int.() -> Unit) {
        val total = a + b
        total.resultado()
    }
    somarComReceiver(1, 3) {
        println(this)
    }
}

fun scopeFunctions() {

    // let, run, with, apply and also

    val endereco = Endereco(logradouro = "Rua Professor Domingos", numero = 120)

    endereco
        .run { "$logradouro, $numero".uppercase() }
        .also (::println)

    // "Com este objeto, faça"
    with(endereco) {
        println(endereco)
    }

    run {
        println("Olá")
    }

    // Retorna a computação do objeto
    "Teste"
        .run { uppercase() }
        .also(::println)

    Endereco()
        .also { println("Criando endereço...") } // Pode ser removido do código sem efeito colateral
        // "Aplique as seguintes atribuições ao objeto"
        .apply {
            logradouro = "Rua Professor Domingos"
            numero = 120
        }
        .also (::println)
}

fun higherOrderFunctions() {
    val testeFuncao: () -> Unit = {
    }
    val testeRecebeString = fun(valor: String) {
        println(valor.uppercase())
    }
    "Teste".let(testeRecebeString)

    println()

    Endereco(logradouro = "Rua Professor Domingos", numero = 120)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".uppercase()
        }
        .let (::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento"))
        .filter { p -> p.complemento.isNotEmpty() }
        .let(::println)

    val somar = fun(a: Int, b: Int, resultado: (Int) -> Unit) {
        resultado(a + b)
    }

    somar(5083, 12305) {
        println(it)
    }

    somar(123, 343, ::println)
}

private fun lambda() {
    val minhaFuncaoLambda = { a: Int, b: Int ->
        a + b
    }
    println(minhaFuncaoLambda(15, 10))

    val minhaFuncaoAnonima = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(15, 23))

    // Returns and jumps
    // Return at label
    val calcularBonificacao:(salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50.0
        }
        salario + 100.0
    }
    println(calcularBonificacao(1100.0))

    val calcularBonificacaoAnonima: (salario: Double) -> Double = fun(salario: Double): Double {
        if (salario > 1000.0) {
            return salario + 50.0
        }
        return salario + 100.0
    }
    println(calcularBonificacaoAnonima(900.0))
}

private fun functionTypes() {
    val minhaFuncao: (a: Int, b: Int) -> Int = ::soma
    println(minhaFuncao(1, 5))

    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()
    println(minhaFuncaoClasse(1, 50))
}

fun soma(a: Int, b: Int): Int = a + b

fun teste() {
    println("Executa teste")
}

class Soma: (Int, Int) -> Int {
    override fun invoke(p1: Int, p2: Int): Int = p1 + p2

}