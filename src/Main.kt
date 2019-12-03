fun main () {
    var option: Int = 5

    //enquanto option não for zero rodar o programa

    while(option!=0){

        var categoria:String = ""
        var nome:String = ""

        option = menu()//pega e valida a primeira opcao do primeiro menu

        if(option==1){//se opção "Escolher categoria" ir para menu de categorias

            categoria=categoria()//mostra o menu de categorias, valida a entrada de dados e retorna (Frutas ou Cidades ou Nomes)

        }else if(option==2) {//opcao "Iniciar jogo"

            if(categoria!=""){//se categoria ja foi escolhida iniciar jogo

                nome = pegaNome()//pega e valida nome



            }else{//caso categoria não tenha sido escolhida ainda

                println("Tem que escolher primeiro a categoria, tente novamente")//mensagem de erro

            }
        }else{

        }
    }








