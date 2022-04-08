package kotlin_oop.list

fun main() {
    val livro1 = Livro(
        titulo = "Grande Sertão Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )

    val livro3 = Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    )

    // Estrutura de dados: listas
    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    livros.add(Livro(titulo = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946))

    livros.imprimirComMarcadores()

//    livros.remove(livro1)
//    livros.imprimirComMarcadores()

    // Ordenação
    val livrosOrdenadosPorAno = livros.sortedBy { it.anoPublicacao }

    livrosOrdenadosPorAno.imprimirComMarcadores()

    // Filtrando listas
    val titulos = livros
        .filter { it.autor.startsWith("João") }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }

    println()
    println(titulos)

    // Lidando com nulos
    val livrosComNulos = mutableListOf(livro1, livro2, null, livro3, null, null)
    livrosComNulos.imprimirComMarcadores()

    println()

    // Lidando com atributos nulos
    livros
        .groupBy { it.editora ?: "Editora desconhecida" }
        .forEach { (editora: String?, livros: List<Livro>) ->
            println("$editora: ${livros.joinToString { it.titulo }}")
        }

    // Lidando com mutabilidade
    val prateleira = Prateleira(genero = "Literatura", livros = livros)

    val livrosPorAutor = prateleira.organizarPorAutor()
    val livrosPorAno = prateleira.organizarPorAnoPublicacao()

    livrosPorAutor.imprimirComMarcadores()
    livrosPorAno.imprimirComMarcadores()
}

fun List<Livro?>.imprimirComMarcadores() {
    println()
    val textoFormatado = this
        .filterNotNull()
        .joinToString(separator = "\n") {
            " - ${it.titulo} de ${it.autor} (${it.anoPublicacao})"
        }
    println("### Lista de Livros ###\n$textoFormatado")
}