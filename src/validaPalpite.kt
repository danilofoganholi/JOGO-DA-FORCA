fun validaPalpite(palpite:String): Boolean{
    return if (palpite.length==1){ // verifica se o palpite tem apenas uma letra
        when (palpite){
            in "a".."z",in "A".."Z"-> true // se estiver de 'a' a 'z' retorna true
            else -> false //caso seja caracteres especiais ou numeros retorna false
        }
    }else false //caso tenha mais de uma letra retorna false
}