//monstra o menu principal do jogo
fun obtemMenu(): String {
    //função que mostra o menu
    return "\n*** JOGO DA FORCA ***\n" +
            "\n1 - Escolher categoria" +
            "\n2 - Iniciar jogo" +
            "\n3 - Visualizar estatisticas"+
            "\n4 - Ler estatisticas"+
            "\n5 - Gravar estatisticas"+
            "\n0 - Sair\n"
}

//monstra o menu de categorias do jogo
fun obtemMenuCategorias(arrayCategoria:Array<String>):String{

    var stringMenuCategoria = "\n>>> Escolha a categoria\n\n"//inicio padrão do menu categoria

    for (i in 0..arrayCategoria.size-1){//percorre os indices do array

        val ascii = (65 + i).toChar()//pega as letras pela tabela ascii

        stringMenuCategoria += "$ascii - ${arrayCategoria[i]}\n"//monta a string com as opcoes
    }

    stringMenuCategoria += "0 - Sair sem escolher categoria\n" //concatena ultima linha

    return stringMenuCategoria//retorna a string do menu de categorias de acordo com o array passado
}

//monstra o menu do jogo da forca, com categoria, numero de erros e com a forma da palavra
fun mostraJogo(categoria:Int, numErros:Int, estruturaPalavra:String){

    //pega a palavra da categoria
    val stringCategoria = leFicheiroCategorias("categorias.txt")[categoria]

    //mostra o andamento do jogo
    println("Categoria: $stringCategoria | Erros: $numErros\n" +
            "Palavra: $estruturaPalavra\n" +
            "Introduza uma letra:")
}