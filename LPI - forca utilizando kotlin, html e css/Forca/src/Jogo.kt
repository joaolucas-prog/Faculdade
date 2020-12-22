import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import kotlin.browser.*
import kotlin.random.Random


val imagensInicial = document.getElementById("imagensInicial") as HTMLDivElement
val paginaInicial = document.getElementById("paginaInicial") as HTMLDivElement
val titulo = document.getElementById("titulo") as HTMLDivElement
val botoes = document.getElementById("botoes") as HTMLDivElement
val letras = document.getElementById("letras") as HTMLDivElement
//val imagemForca = document.getElementById("imagensFORCA") as HTMLDivElement
val gerarDicas = mutableListOf<Int>()
val gerarNomes = mutableListOf<Int>()
val listaIndex = mutableListOf<Int>()
val animal = listOf(" l e a o", " t i g r e", " o n ç a")
val objeto = listOf(" f a c a", " b o l a", " d a d o")
val fruta = listOf(" b a n a n a", " l a r a n j a", " a b a c a t e")
var chances = 0
var descoberta = ""
var listaNomes = mutableListOf<String>()
var Erros = 6- chances
val imagemForca = document.getElementById("imagensFORCA") as HTMLDivElement

fun clicouJogar(){
    gerarDicas.clear()
    gerarNomes.clear()
    gerarDicas.add(Random.nextInt(1,4))
    gerarNomes.add(Random.nextInt(0,3))
    sortearDicasAndNomes()
    listaNomes.add(tracos(sortearDicasAndNomes().length/2))

    paginaInicial.style.display="none"
    botoes.style.display="none"
    letras.style.display="block"
    imagensInicial.style.display="block"
    titulo.style.display="block"
   // imagemForca.style.display = "block"
}

fun clicouVoltar(){
    paginaInicial.style.display="block"
    botoes.style.display="block"
    letras.style.display="none"
    imagensInicial.style.display="none"
    titulo.style.display="none"
    imagemForca.style.display = "none"
    init()
}

fun init() {
    chances = 0
    descoberta = ""
    Erros = 6- chances
}

fun tracos(tamanho: Int): String=
        if(tamanho == 1)
            " _"
        else
            " _"+tracos(tamanho-1)

fun index(palavraV: String, letra: String, indice: Int = 0): MutableList<Int> =
        if (!palavraV.contains(letra[0])) {
            listaIndex.add(-1)
            listaIndex
        } else if (indice > palavraV.length)
            listaIndex
        else {
            if (palavraV[indice] == letra[0]) {
                listaIndex.add(indice)
                index(palavraV, letra, indice + 1)
            } else
                index(palavraV, letra, indice + 1)
        }


fun mostrarLetras(aDescobrir: String, letra: String, listaIndex: MutableList<Int>): String=
        if (listaIndex.isEmpty() || listaIndex.contains(-1))
            aDescobrir
        else {
            descoberta = aDescobrir
            descoberta = descoberta.substring(0, listaIndex.first()) + letra + descoberta.substring(listaIndex.first()+1)
            listaIndex.removeAt(0)
            mostrarLetras(descoberta, letra, listaIndex)
        }


@JsName("clicouLetra")
fun clicouLetra(palavra: String, letra: String, aDescobrir: MutableList<String> = listaNomes): Unit {
    val indice = index(palavra, letra)
    imagemForca.style.display = "block"
    if (chances == 6) {
        titulo.innerHTML = """YOU LOSE! A palavra era: $palavra" <br/>
             """.trimIndent()//   <button onclick = "Forca.clicouVoltar()">Voltar</button>" """
        //chances = 0

    } else if (indice[0] == -1) {
        val palavraLast = aDescobrir.last()
        titulo.innerHTML = """
            $palavraLast
            <p>
            Não possui a letra : $letra ! <br/>
            Você possui $Erros chances
        """.trimIndent()
        println("Não possui essa letra!")
        println(palavra)
        listaIndex.clear()
        chances = chances +1
        Erros = 6-chances

        if(chances == 0 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca1.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 1 ){
                imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca2.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 2 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca3.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 3 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca4.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 4 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca5.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 5 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca6.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }
        if(chances == 6 ){
            imagemForca.innerHTML = """<center>
            <img src="imagens/IMGforca7.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">
        </center>
                """.trimIndent()
        }

    } else {
        var descoberta = mostrarLetras(aDescobrir.last(), letra, indice)
        aDescobrir.add(descoberta)
        titulo.innerHTML = descoberta
        if (palavra.equals(descoberta)) {
            chances = 0
            titulo.innerHTML = """
                $descoberta
                <p>
                YOU WIN!
            """.trimIndent()
//            botoes.innerHTML ="""
//                <center>
//                <button onclick = "Forca.clicouJogar()">Proxima</button>
//                </center>
//            """.trimIndent()
        } else {
            print("Informe outra letra: ")
        }
        listaIndex.clear()
    }
    //chances = chances + 1
  //  window.document.getElementById("$letra").style.background = "red"
}

fun sortearDicasAndNomes(): String=

        if (gerarDicas.last() == 1){

            titulo.innerHTML = tracos(animal.get(gerarNomes.last()).length/2)

            imagensInicial.innerHTML = """
           <center>
           <h1>
           Animal
           </h1>
           </center>
        """.trimIndent()
            println(animal.get(gerarNomes.last()))
            animal.get(gerarNomes.last())
        }
        else if(gerarDicas.last() == 2){

            titulo.innerHTML = tracos(objeto.get(gerarNomes.last()).length/2)

            imagensInicial.innerHTML = """
           <center>
           <h1>
           Objeto
           </h1>
           </center>
        """.trimIndent()
            println(objeto.get(gerarNomes.last()))
            objeto.get(gerarNomes.last())

        }
        else if(gerarDicas.last() == 3){

            titulo.innerHTML = tracos(fruta.get(gerarNomes.last()).length/2)

            imagensInicial.innerHTML = """
           <center>
           <h1>
           Fruta
           </h1>
           </center>
        """.trimIndent()
            println(fruta.get(gerarNomes.last()))
            fruta.get(gerarNomes.last())
        }
        else
            ""



fun main(args: Array<String>) {
    /*val jogar = document.getElementById("jogar") as HTMLButtonElement

    jogar.onclick = {
        clicouJogar()
    }*/

}
