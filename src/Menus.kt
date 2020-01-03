//menu de categorias
fun menuCategoria():Int{

    //pega array com as categorias
    val arrayCategoria = leFicheiroCategorias("categorias.txt")

    //monta string com esse array
    val menuCategoria = obtemMenuCategorias(arrayCategoria)

    //monta um array com todas as opções que podem ser digitadas
    val opticaoCategoria: Array<String> = Array(arrayCategoria.size, { i -> ((i+65).toChar()).toString()})

    do{
        println(menuCategoria)//mostrar o menu de categorias

        val categoria = readLine()?.toUpperCase()?: "0"//leitura da categoria

        when (categoria) {//atribui categoria correta de acordo com a opcao escolhida

            in opticaoCategoria -> {//verifica se é uma opção valida

                for (i in 0..arrayCategoria.size-1){//pegando um elemento do array de cada vez para comparar

                    if (categoria==opticaoCategoria[i]){//comparando com o digitado pelo utilizador

                        return i//retorna mesmo indice mas do array com as categorias
                    }
                }
            }

            "0" -> return 0 //'0' sair sem escolher categoria

            else -> println("Opcao invalida, tente novamente")//Se for qualquer outra coisa soltar mensagem de erro
        }
    }while (categoria!="0")
    return 0
}

//menu principal do programa
fun menuPrincipal():Int{
    do{
        println(obtemMenu()) //mostra o menu principal

        val option = readLine()?.toIntOrNull()?: -1//leitura da opção

        if (option !in 0..5){//se o número for inválido

            println("Opcao invalida, tente novamente")//motra mensagem de erro

        }else return option //se o numero for valido retornar ele mesmo

        //enquanto o numero não for valido mostrar menu novamente e pedir nova digitacao
    }while (option !in 0..5)
    return 0
}