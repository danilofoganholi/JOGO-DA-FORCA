fun main () {
    labirinto()
    var categoria:String = ""

    //enquanto a variavel option for diferente de (0,1,2) exibir erro e pedir novamente a digitação
    var option:Short = menu()

    if (option == 1.toShort()){
        while (categoria!="Frutas" && categoria!="Cidades" && categoria!="NomesProprio"){
            categoria = categoria()
        }
    }else if (option==2.toShort()){
        println("Tem que escolher primeiro a categoria, tente novamente")
    }else{
        println("FIM")
    }
    //pegando uma palavra aleatório para o jogo
    var keyword = geraPalavra(categoria)

    //mostra menu principal
    option = menu()

    //declarando variavel do nome
    var nome: String = ""

    //se opção 2 solicita o nome
    if (option==2.toShort()){
        // declarando variavel da validação
        var validaNome: Boolean = false
        while (validaNome==false){
            println("Introduza o nome do jogador(a):")
            nome = readLine()!!
            validaNome = validaNome(nome)
            if (validaNome == false){
                println("Nome invalido, tente novamente")
            }
        }
    }
}