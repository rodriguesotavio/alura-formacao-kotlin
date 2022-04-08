package kotlin_oop.collections

fun main() {
//    introducao()
//    testarCopia()
//    testarSet()
//    testarMap()
//    testarComportamentosMap()

    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0),
    )

    println(pedidos)

    val pedidosMapeados: Map<Int, Pedido> = pedidos
        .associateBy { pedido -> pedido.numero }

    println(pedidosMapeados)

    val pedidosFreteGratis = pedidos.associateWith { pedido -> pedido.valor > 50 }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(numero = 2, valor = 60.0)])

    val mapa: Map<Boolean, List<Pedido>> = pedidos
        .groupBy { pedido -> pedido.valor > 50.0 }

    println(mapa)
    println()
    println(mapa[true])
    println(mapa[false])

    val nomes = listOf("Alex", "Fran", "Gui", "Ana", "Paulo", "Maria", "Mario")

    val agenda = nomes.groupBy { nome -> nome.first() }
    println(agenda)
    println(agenda['A'])
}

fun testarComportamentosMap() {
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        1 to 20.0,
        2 to 34.0,
        3 to 150.0,
        4 to 150.0
    )
//    val valorPedido = pedidos.getValue(5)
//    println(valorPedido)

    println(pedidos.getOrElse(5) { 0.0 })
    println(pedidos.getOrDefault(5, -1.0))

    println(pedidos.keys)
    println(pedidos.values)

    for (numerosDePedido in pedidos.keys) {
        println("Pedido: $numerosDePedido")
    }

    for (valor in pedidos.values) {
        println("Valor: $valor")
    }

    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 30.0
    }
    println(pedidosFiltrados)

    println()

    val pedidosAcima = pedidos.filterValues { valor -> valor > 30.0 }
    println(pedidosAcima)

    val pedidosPares = pedidos.filterKeys { numero -> numero % 2 == 0 }
    println(pedidosPares)

    // Plus and minus
    val outrosPedidos: MutableMap<Int, Double> = (pedidos + mapOf(5 to 90.0, 6 to 15.0)) as MutableMap<Int, Double>
    println(outrosPedidos)
    println(outrosPedidos - 6)
    println(outrosPedidos - listOf(4, 5, 6))

//    outrosPedidos.putAll(setOf<Pair<Int, Double>>(7 to 95.0, 8 to 25.0))
    outrosPedidos += setOf<Pair<Int, Double>>(7 to 95.0, 8 to 25.0)
    println(outrosPedidos)

    outrosPedidos.keys.remove(1)
    println(outrosPedidos)

    outrosPedidos.values.remove(150.0)
    println(outrosPedidos)

    outrosPedidos -= 8
    println(outrosPedidos)
}

fun testarMap() {
//    val pedidos = mapOf(Pair(1, 20.0), Pair(2, 34.0))

    // Infix: perda de performance
    val pedidos = mutableMapOf(
        1 to 20.0,
        2 to 34.0,
        3 to 50.0
    )

    println(pedidos)

    println(pedidos[2]) // 34.0

    val pedido: Double? = pedidos[3]
    pedido?.let { println("Pedido: $it") }

    for (p: Map.Entry<Int, Double> in pedidos) {
        println()
        println("Número: ${p.key}")
        println("Valor: ${p.value}")
    }

    pedidos[4] = 70.00
    println(pedidos)

    pedidos.put(5, 154.0)
    println(pedidos)

    pedidos[1] = 100.0
    println(pedidos)

    pedidos.putIfAbsent(1, 150.0)
    println(pedidos)

    pedidos.remove(5)
    println(pedidos)

    pedidos.remove(2, 34.0)
    println(pedidos)
}

fun testarSet() {
    val assistiramCursoAndroid: MutableSet<String> = mutableSetOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: MutableSet<String> = mutableSetOf("Alex", "Paulo", "Maria")

    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana")

    println(assistiramAmbos)

    println()

    // Comportamentos do set
    // Infix
    println(assistiramCursoAndroid union assistiramCursoKotlin)

    println(assistiramCursoAndroid subtract assistiramCursoKotlin)

    println(assistiramCursoAndroid intersect assistiramCursoKotlin)

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)
    println(assistiramList.toSet())
}

fun testarCopia() {
    val banco = BancoDeNomes()
    banco.salvar(nome = "Otávio")

    val nomesSalvos: Collection<String> = banco.nomes

    println(banco.nomes)
}

fun introducao() {
    val nomes: List<String> = listOf("Alex", "Fran", "Gui", "Maria", "Ana")
    println(nomes)

    for (nome in nomes.iterator()) {
        println(nome)
    }

    println(nomes.contains("Alex"))
}