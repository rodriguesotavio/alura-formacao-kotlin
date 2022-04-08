package kotlin_basico

fun main() {
    println("Bem-vindo ao ByteBank")

    // Variáveis

    // kotlin_basico.estruturaCondicional(saldo)
    // kotlin_basico.estruturasRepeticao()
    // kotlin_basico.copiasEReferencias()
    contasBancarias()
}

fun contasBancarias() {
    val conta = Conta(titular = "João", numero = 5689)
    val conta2 = Conta(numero = 7525, titular = "Maria")

    println("Titular: ${conta.titular.uppercase()}");
    println("Número da conta: ${conta.numero}")
    println("Saldo da conta: ${conta.saldo}")

    conta.depositar(100.0)
    conta.depositar(25.0)
    conta.sacar(5.0)
    conta.transferir(5.0, conta2)

    println(conta.saldo)
    println(conta2.saldo)
}

fun estruturaCondicional(saldo: Double) {
    if (saldo > 0.0) {
        println("Tem saldo na conta!")
    } else if (saldo == 0.0) {
        println("Não tem saldo na conta")
    } else {
        println("kotlin_basico.Conta com saldo negativo")
    }

    when {
        saldo > 0.0 -> println("Tem saldo na conta!")
        saldo == 0.0 -> println("Não tem saldo na conta")
        else -> println("kotlin_basico.Conta com saldo negativo")
    }
}

fun estruturasRepeticao() {
    for (i in 1..3) {
        println(i)
    }

    println()

    for (i in 10 downTo 1 step 2) {
        if (i == 4)
            break
        println(i)
    }

    println()

    var i = 0
    while (i < 5) {
        println(i)
        i++
    }
}

fun copiasEReferencias() {

    // Cópia

    val x = 10
    var y = x // estamos mandando uma cópia de X e não a referência
    y++

    println(x)
    println(y)

    // Referência

    /*
    val contaJoao = kotlin_basico.Conta("João", 1234)
    var contaMaria = contaJoao
    contaMaria.setTitular("Maria")

    println(contaJoao.getTitular())
    println(contaMaria.getTitular())

    println(contaJoao)
    println(contaMaria)
    */
}