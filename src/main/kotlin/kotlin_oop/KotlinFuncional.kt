package kotlin_oop

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
//    calcularIdades()
//    calcularSalarios()
//    ranges()
//    operacoesAgregadoras()
    arrayObjetos()
}

fun arrayObjetos() {
    val salarios = bigDecimalArrayOf("1500.55", "2000.00", "5000.00", "10000.00")
    println(salarios.contentToString())
    val aumento = "1.1".toBigDecimal()
    val salariosComAumento: Array<BigDecimal> = salarios
        .map { salario -> calcularAumentoRelativo(salario, aumento) }
        .toTypedArray()

    println(salariosComAumento.contentToString())

    // Reduce: gasto inicial
    val gastoInicial: BigDecimal = salariosComAumento.somatoria()
    println("Gasto Inicial: $gastoInicial")

    // Fold: gasto total
    val meses = 6.toBigDecimal()
    val gastoTotal = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses.setScale(2, RoundingMode.UP))
    }
    println("Gasto total: $gastoTotal")

    // Compondo operações
    val mediaTresMaioresSalarios = salarios
        .sorted()
        .takeLast(3)
        .toTypedArray()
        .media()
    println("Média maiores salários: $mediaTresMaioresSalarios")

    val mediaTresMenoresSalarios = salarios
        .sorted()
        .take(3)
        .toTypedArray()
        .media()
    println("Média menores salários: $mediaTresMenoresSalarios")
}

fun calcularAumentoRelativo(salario: BigDecimal, aumento: BigDecimal): BigDecimal {
    if (salario < "5000.00".toBigDecimal()) {
        return salario + "500.00".toBigDecimal()
    }
    return (salario * aumento).setScale(2, RoundingMode.UP)
}

fun operacoesAgregadoras() {
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
    val maiorIdade = idades.maxOrNull()
    println("Maior idade: $maiorIdade")

    val menorIdade = idades.minOrNull()
    println("Menor idade: $menorIdade")

    val mediaIdades = idades.average()
    println("Média idades: $mediaIdades")

    val todosMaiores = idades.all { it >= 18 }
    println("Todos maiores? $todosMaiores")

    val existeMaior = idades.any { it >= 18 }
    println("Algum aluno é maior de idade? $existeMaior")

    val maioresIdade = idades.filter { it >= 18 }
    println("Maiores de idade: $maioresIdade")

    val busca = idades.find { it >= 18 }
    println("Busca: $busca")
}

fun ranges() {
    val sequencia: IntRange = 1.rangeTo(10)
    for (s in sequencia) {
        print("$s ")
    }

    println()

    val pares: IntProgression = 2.until(100) step 2 //2..100 step 2
    for (s in pares) {
        print("$s ")
    }

    println()

    // Valores reversos
    val paresReverso = 100 downTo 0 step 2
    paresReverso.forEach { print("$it ") }

    println()

    val intervalo = 1500.0..5000.0
    val meuSalario = 14000.0
    if (meuSalario in intervalo) {
        println("Está dentro do intervalo")
    } else {
        println("Não está dentro do intervalo")
    }

    val alfabeto = 'a'..'z'
    val letra = 'b'
    println(letra in alfabeto)
}

fun calcularSalarios() {
    val salarios: DoubleArray = doubleArrayOf(1500.5, 2300.0, 5000.0, 8000.0, 10000.0)
    val aumento = 1.1

//    var index = 0
//    for (salario in salarios) {
//        salarios[index] = salario * aumento
//        index++
//    }
//    println(salarios.contentToString())

//    for (index in salarios.indices) {
//        salarios[index] = salarios[index] * aumento
//    }
//    println(salarios.contentToString())

    salarios.forEachIndexed { i, salario ->
        salarios[i] = salario * aumento
    }
    println(salarios.contentToString())
}

fun calcularIdades() {
    val idade1 = 25
    val idade2 = 19
    val idade3 = 33

    val maiorIdade = if (idade1 > idade2 && idade1 > idade3) {
        idade1
    } else if (idade2 > idade3) {
        idade2
    } else {
        idade3
    }

    println(maiorIdade)

    // Arrays

//    val idades = IntArray(4)
//    idades[0] = 25
//    idades[1] = 19
//    idades[2] = 33
//    idades[3] = 55

    // IntArrayOf
    val idades = intArrayOf(25, 19, 33, 55, 60, 40, 23, 12)

    var idadeMaior = 0
    for (idade in idades) {
        if (idade > idadeMaior)
            idadeMaior = idade
    }
    println(idadeMaior)

    var idadeMenor = Int.MAX_VALUE
    idades.forEach { idade ->
        if (idade < idadeMenor)
            idadeMenor = idade
    }
    println(idadeMenor)
}

