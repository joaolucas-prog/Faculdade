#include <stdio.h>
#include <stdlib.h>
#include<conio.h>
#include<windows.h>
#include"menu.h"
int xbarra=14,ybarra=27 ,xbola=25,ybola =26,direcaox=1,direcaoy=(-1),vidas=5,yborda=28,borda = 219,score=0;
unsigned char barra=178,muv,tab[28][50];
void hidecursor()//função que tira o cursor da tela
{
    HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO info;
    info.dwSize = 100;
    info.bVisible = FALSE;
    SetConsoleCursorInfo(consoleHandle, &info);
}
void gotoxy(int x, int y){//função para o funcionamento do gotoxy
     SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),(COORD){x-1,y-1});
}
void _borda(){//printa  a borda e os blocos
 char bordas=219 ,coluna,linha,lado=28;

    for(linha=0;linha<lado;linha++){//aqui dizemos quantas vezes faremos cada linha
    for(coluna=0;coluna<51;coluna++){//aqui imprimimos asteriscos lado a lado equivalentes ao tamanho do lado
            //que multiplicados pelo numero de vezes definido no primeiro for
            //faz com que obtenhamos um quadrilatero
        if(linha==0 || linha==lado-1 || coluna==0 || coluna==lado+22){
                //linha==0 imprime a barra de cima
                //linha==lado+1 imprime a barra de baixo
                //coluna==0 imprime a barra da esquerda
                //coluna==lado+1 imprime a barra da direita
                tab[coluna][linha]=bordas;
                printf("%c",tab[coluna][linha]);
                system("color 71");//deixa a cor do fundo branco e letras azul

            }

        else if(linha>=1 && linha<=4 && coluna>=1 && coluna<=50)
            {
                tab[coluna][linha] = 177;

                printf("%c",tab[coluna][linha]);
            }

        else{
                //em todo o resto ? imprimido espa?o vazio
                tab[coluna][linha] = 0;
                printf("%c",tab[coluna][linha]);

            }
        }
        printf("\n");
    }
}
void jogo(){
    hidecursor();
    system("mode con:cols=120 lines=39");//da um tamanho a cmd
    _borda();
    while (vidas){//coloquei assim , pois caso a vida=0 o jogo fecha

    gotoxy(xbarra,ybarra);printf ("%c%c%c%c",barra,barra,barra,barra);//printa a barra
    gotoxy(60,10);printf(" Vidas:%d",vidas);//printa a vida
    gotoxy(60,12);printf(" Score:%d",score);//printa o score

    if (kbhit())//trabalha getch junto com sleep
        {
        muv = getch(); //recebe a tecla
        }
        _sleep(60);
    if(muv == 75 && xbarra>2){//movimento da barra para esquerda
        xbarra=xbarra-3;
        muv=0;
        gotoxy(xbarra+4,ybarra);
        printf("   ");
             }
    else if(muv == 77&& xbarra<43){//movimento da barra para direita
        xbarra=xbarra+3;
        muv=0;
        gotoxy(xbarra-3,ybarra);
        printf("   ");
              }
    gotoxy(xbola,ybola);printf(" ");//tira o rastro do print da bola


    if ( xbola==2)//movimentação da bola para direita em x
        direcaox=1;
    else if(xbola==50)//movimentação da bola para esquerda em x
        direcaox=(-1);
    else if(ybola==2)//movimentação da bola para baixo em y
        direcaoy=1;
    else if(ybola>=27)//movimentação da bola para cima em y
        direcaoy=(-1);
        gotoxy(3,28);printf("%c",219);

    xbola+=direcaox;//para dar movimento em x
    ybola+=direcaoy;//para dar movimento em y
    gotoxy(xbola,ybola);printf("O");//printa a bola

    if ((xbarra!=xbola && xbarra+1!=xbola && xbarra+2!=xbola && xbarra+3!=xbola && xbarra+4!=xbola)&&ybarra==ybola)//caso a bola seja diferente da barra perde 1 vida
        vidas--;
           else if ((xbarra==xbola || xbarra+1==xbola )&&ybarra==ybola)//movimentação da bola caso toque nos 3 primeiros print da barra
 {
        direcaox=(-1);
        direcaoy=(-1);
 }

    else if (( xbarra+2==xbola || xbarra+3==xbola )&&ybarra==ybola  && direcaox==(-1) )//movimentação da bola caso toque nos ultimos print da barra
 {
        direcaox=(1);
        direcaoy=(-1);
 }
   if(tab[xbola][ybola-1]==177 && direcaoy==(-1) &&  direcaox==1){//interação da bola com a barra caso a bola venha por baixo e x pela direita
        tab[xbola][ybola-1]=0;
        gotoxy(xbola+1,ybola);printf(" ");
        direcaoy=(1);
        direcaox= (-1);
        score=score+10;

        }
    else if(tab[xbola][ybola-1]==177 && direcaoy==(-1) &&direcaox==(-1) ){//interação da bola com a barra caso a bola venha por baixo e x pela esquerda
        tab[xbola][ybola-1]=0;
        gotoxy(xbola+1,ybola);printf(" ");
        direcaoy=(1);
        direcaox=1;
        score=score+10;

    }


    else if(tab[xbola][ybola-1]==177 && direcaoy==1 ){//interação da bola com a barra caso a bola venha por cima
        tab[xbola][ybola-1]=0;
        gotoxy(xbola+1,ybola);printf(" ");
        direcaoy=(-1);
        score=score+10;

    }
     if (score==960)//caso chegue na pontuação max ou seja sem blocos, o jogo acaba
     vidas=0;


     }
      //coloca a função ranking aqui

      return 0;
}
