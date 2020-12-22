if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Forca'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Forca'.");
}
var Forca = function (_, Kotlin) {
  'use strict';
  var throwCCE = Kotlin.throwCCE;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var Random = Kotlin.kotlin.random.Random;
  var contains = Kotlin.kotlin.text.contains_sgbm27$;
  var first = Kotlin.kotlin.collections.first_2p1efm$;
  var trimIndent = Kotlin.kotlin.text.trimIndent_pdl1vz$;
  var last = Kotlin.kotlin.collections.last_2p1efm$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var equals = Kotlin.equals;
  var print = Kotlin.kotlin.io.print_s8jyv4$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var imagensInicial;
  var paginaInicial;
  var titulo;
  var botoes;
  var letras;
  var gerarDicas;
  var gerarNomes;
  var listaIndex;
  var animal;
  var objeto;
  var fruta;
  var chances;
  var descoberta;
  var listaNomes;
  var Erros;
  var imagemForca;
  function clicouJogar() {
    gerarDicas.clear();
    gerarNomes.clear();
    gerarDicas.add_11rb$(Random.Default.nextInt_vux9f0$(1, 4));
    gerarNomes.add_11rb$(Random.Default.nextInt_vux9f0$(0, 3));
    sortearDicasAndNomes();
    listaNomes.add_11rb$(tracos(sortearDicasAndNomes().length / 2 | 0));
    paginaInicial.style.display = 'none';
    botoes.style.display = 'none';
    letras.style.display = 'block';
    imagensInicial.style.display = 'block';
    titulo.style.display = 'block';
  }
  function clicouVoltar() {
    paginaInicial.style.display = 'block';
    botoes.style.display = 'block';
    letras.style.display = 'none';
    imagensInicial.style.display = 'none';
    titulo.style.display = 'none';
    imagemForca.style.display = 'none';
    init();
  }
  function init() {
    chances = 0;
    descoberta = '';
    Erros = 6 - chances | 0;
  }
  function tracos(tamanho) {
    return tamanho === 1 ? ' _' : ' _' + tracos(tamanho - 1 | 0);
  }
  function index(palavraV, letra, indice) {
    if (indice === void 0)
      indice = 0;
    if (!contains(palavraV, letra.charCodeAt(0))) {
      listaIndex.add_11rb$(-1);
      return listaIndex;
    }
     else if (indice > palavraV.length)
      return listaIndex;
    else {
      if (palavraV.charCodeAt(indice) === letra.charCodeAt(0)) {
        listaIndex.add_11rb$(indice);
        return index(palavraV, letra, indice + 1 | 0);
      }
       else
        return index(palavraV, letra, indice + 1 | 0);
    }
  }
  function mostrarLetras(aDescobrir, letra, listaIndex) {
    if (listaIndex.isEmpty() || listaIndex.contains_11rb$(-1))
      return aDescobrir;
    else {
      descoberta = aDescobrir;
      var $receiver = descoberta;
      var endIndex = first(listaIndex);
      var tmp$ = $receiver.substring(0, endIndex) + letra;
      var $receiver_0 = descoberta;
      var startIndex = first(listaIndex) + 1 | 0;
      descoberta = tmp$ + $receiver_0.substring(startIndex);
      listaIndex.removeAt_za3lpa$(0);
      return mostrarLetras(descoberta, letra, listaIndex);
    }
  }
  function clicouLetra(palavra, letra, aDescobrir) {
    if (aDescobrir === void 0)
      aDescobrir = listaNomes;
    var indice = index(palavra, letra);
    imagemForca.style.display = 'block';
    if (chances === 6) {
      titulo.innerHTML = trimIndent('YOU LOSE! A palavra era: ' + palavra + '"' + ' <br/>' + '\n' + '             ');
    }
     else if (indice.get_za3lpa$(0) === -1) {
      var palavraLast = last(aDescobrir);
      titulo.innerHTML = trimIndent('\n' + '            ' + palavraLast + '\n' + '            <p>' + '\n' + '            N\xE3o possui a letra : ' + letra + ' ! <br/>' + '\n' + '            Voc\xEA possui ' + Erros + ' chances' + '\n' + '        ');
      println('N\xE3o possui essa letra!');
      println(palavra);
      listaIndex.clear();
      chances = chances + 1 | 0;
      Erros = 6 - chances | 0;
      if (chances === 0) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca1.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 1) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca2.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 2) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca3.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 3) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca4.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 4) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca5.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 5) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca6.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
      if (chances === 6) {
        imagemForca.innerHTML = trimIndent('<center>\n            <img src="imagens/IMGforca7.jpg" alt = "IMGForca.png" style="width:210px;height:188px;">\n        <\/center>\n                ');
      }
    }
     else {
      var descoberta = mostrarLetras(last(aDescobrir), letra, indice);
      aDescobrir.add_11rb$(descoberta);
      titulo.innerHTML = descoberta;
      if (equals(palavra, descoberta)) {
        chances = 0;
        titulo.innerHTML = trimIndent('\n' + '                ' + descoberta + '\n' + '                <p>' + '\n' + '                YOU WIN!' + '\n' + '            ');
      }
       else {
        print('Informe outra letra: ');
      }
      listaIndex.clear();
    }
  }
  function sortearDicasAndNomes() {
    if (last(gerarDicas) === 1) {
      titulo.innerHTML = tracos(animal.get_za3lpa$(last(gerarNomes)).length / 2 | 0);
      imagensInicial.innerHTML = trimIndent('\n           <center>\n           <h1>\n           Animal\n           <\/h1>\n           <\/center>\n        ');
      println(animal.get_za3lpa$(last(gerarNomes)));
      return animal.get_za3lpa$(last(gerarNomes));
    }
     else if (last(gerarDicas) === 2) {
      titulo.innerHTML = tracos(objeto.get_za3lpa$(last(gerarNomes)).length / 2 | 0);
      imagensInicial.innerHTML = trimIndent('\n           <center>\n           <h1>\n           Objeto\n           <\/h1>\n           <\/center>\n        ');
      println(objeto.get_za3lpa$(last(gerarNomes)));
      return objeto.get_za3lpa$(last(gerarNomes));
    }
     else if (last(gerarDicas) === 3) {
      titulo.innerHTML = tracos(fruta.get_za3lpa$(last(gerarNomes)).length / 2 | 0);
      imagensInicial.innerHTML = trimIndent('\n           <center>\n           <h1>\n           Fruta\n           <\/h1>\n           <\/center>\n        ');
      println(fruta.get_za3lpa$(last(gerarNomes)));
      return fruta.get_za3lpa$(last(gerarNomes));
    }
     else
      return '';
  }
  function main(args) {
  }
  Object.defineProperty(_, 'imagensInicial', {
    get: function () {
      return imagensInicial;
    }
  });
  Object.defineProperty(_, 'paginaInicial', {
    get: function () {
      return paginaInicial;
    }
  });
  Object.defineProperty(_, 'titulo', {
    get: function () {
      return titulo;
    }
  });
  Object.defineProperty(_, 'botoes', {
    get: function () {
      return botoes;
    }
  });
  Object.defineProperty(_, 'letras', {
    get: function () {
      return letras;
    }
  });
  Object.defineProperty(_, 'gerarDicas', {
    get: function () {
      return gerarDicas;
    }
  });
  Object.defineProperty(_, 'gerarNomes', {
    get: function () {
      return gerarNomes;
    }
  });
  Object.defineProperty(_, 'listaIndex', {
    get: function () {
      return listaIndex;
    }
  });
  Object.defineProperty(_, 'animal', {
    get: function () {
      return animal;
    }
  });
  Object.defineProperty(_, 'objeto', {
    get: function () {
      return objeto;
    }
  });
  Object.defineProperty(_, 'fruta', {
    get: function () {
      return fruta;
    }
  });
  Object.defineProperty(_, 'chances', {
    get: function () {
      return chances;
    },
    set: function (value) {
      chances = value;
    }
  });
  Object.defineProperty(_, 'descoberta', {
    get: function () {
      return descoberta;
    },
    set: function (value) {
      descoberta = value;
    }
  });
  Object.defineProperty(_, 'listaNomes', {
    get: function () {
      return listaNomes;
    },
    set: function (value) {
      listaNomes = value;
    }
  });
  Object.defineProperty(_, 'Erros', {
    get: function () {
      return Erros;
    },
    set: function (value) {
      Erros = value;
    }
  });
  Object.defineProperty(_, 'imagemForca', {
    get: function () {
      return imagemForca;
    }
  });
  _.clicouJogar = clicouJogar;
  _.clicouVoltar = clicouVoltar;
  _.init = init;
  _.tracos_za3lpa$ = tracos;
  _.index_rjan26$ = index;
  _.mostrarLetras_n9ipja$ = mostrarLetras;
  _.clicouLetra = clicouLetra;
  _.sortearDicasAndNomes = sortearDicasAndNomes;
  _.main_kand9s$ = main;
  var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4;
  imagensInicial = Kotlin.isType(tmp$ = document.getElementById('imagensInicial'), HTMLDivElement) ? tmp$ : throwCCE();
  paginaInicial = Kotlin.isType(tmp$_0 = document.getElementById('paginaInicial'), HTMLDivElement) ? tmp$_0 : throwCCE();
  titulo = Kotlin.isType(tmp$_1 = document.getElementById('titulo'), HTMLDivElement) ? tmp$_1 : throwCCE();
  botoes = Kotlin.isType(tmp$_2 = document.getElementById('botoes'), HTMLDivElement) ? tmp$_2 : throwCCE();
  letras = Kotlin.isType(tmp$_3 = document.getElementById('letras'), HTMLDivElement) ? tmp$_3 : throwCCE();
  gerarDicas = ArrayList_init();
  gerarNomes = ArrayList_init();
  listaIndex = ArrayList_init();
  animal = listOf([' l e a o', ' t i g r e', ' o n \xE7 a']);
  objeto = listOf([' f a c a', ' b o l a', ' d a d o']);
  fruta = listOf([' b a n a n a', ' l a r a n j a', ' a b a c a t e']);
  chances = 0;
  descoberta = '';
  listaNomes = ArrayList_init();
  Erros = 6 - chances | 0;
  imagemForca = Kotlin.isType(tmp$_4 = document.getElementById('imagensFORCA'), HTMLDivElement) ? tmp$_4 : throwCCE();
  main([]);
  Kotlin.defineModule('Forca', _);
  return _;
}(typeof Forca === 'undefined' ? {} : Forca, kotlin);
