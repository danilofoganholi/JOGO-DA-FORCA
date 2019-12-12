fun validaEnter(){
    do {
        val enter = readLine()?:" "//pega o valor digitado

        if (enter!= ""){//se não for apenas um enter

            println("Digito invalido, prima enter para voltar ao menu")}// mensagem de erro

    }while (enter!= "")//verifica se digitou apenas "enter"
}