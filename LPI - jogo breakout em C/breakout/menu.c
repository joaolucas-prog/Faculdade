#include <stdio.h>
#include <stdlib.h>
#define ENTER   13
void menu()
{
    int op=0;
    char esco,teste;
 do{
    printf(" _______                               __ \n");
    printf("|   _    \\                            |  | \n");
    printf("|  | \\   /                            |  |  ___\n");
    printf("|  |_/  /                             |  | /  /                       _ \n");
    printf("|      /    _______  _____   ______   |  |/  /   ______    _    _   _|_|_ \n");
    printf("|   _  \\   |      / |  ___| |  __  |  |     /   |      |  | |  | | |_   _|  \n");
    printf("|  | \\  \\  | |>  /  | |___  | |__| |  |    (    |  ||  |  | |  | |   | |   \n");
    printf("|  |_/   \\ |    /   |  ___| |  __  |  |     \\   |  ||  |  | |  | |   | |    \n");
    printf("|        / |    \\   | |___  | |  | |  |  |\\ \ \\  |  ||  |  | |__| |   | |__ \n");
    printf("|_______/  |_|\\ _\\  |_____| |_|  |_|  |__| \\__\\ |______|  |______|   |____|\n");
    printf("\n\n");



   if (op==0){

    printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
    printf("\xba    >INICIAR JOGO                       \xba\n");
    printf("\xba     ranking                            \xba\n");
    printf("\xba     instrucoes                         \xba\n");
    printf("\xba     sair                               \xba\n");
    printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");
   }

  if (op==1){
    printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
    printf("\xba     iniciar jogo                       \xba\n");
    printf("\xba    >RANKING                            \xba\n");
    printf("\xba     instrucoes                         \xba\n");
    printf("\xba     sair                               \xba\n");
    printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");

  }
  if(op==2){
    printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
    printf("\xba     iniciar jogo                       \xba\n");
    printf("\xba     ranking                            \xba\n");
    printf("\xba    >INSTRUCOES                         \xba\n");
    printf("\xba     sair                               \xba\n");
    printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");


  }

  if(op==3){
    printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
    printf("\xba     iniciar jogo                       \xba\n");
    printf("\xba     ranking                            \xba\n");
    printf("\xba     instrucoes                         \xba\n");
    printf("\xba    >SAIR                               \xba\n");
    printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");


  }

    esco=getch();


    switch(esco)
    {
    case 72:
         op--;
        break;
    case 80:
         op++;
        break;
    case ENTER:
        if(op==0){
            system("cls");
            jogo();
            //jogo
        }
      else if(op==1){
            system("cls");
      //ranking
        }
    else if(op==2){

        system("cls");

        printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcD\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
        printf("\xBA VOCE DEVE USAR AS SETAS (%c %c) PARA CONTROLAR A BARRINHA\xba\n",174,175);system("cls");
        printf("\xc9\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcD\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xbb\n");
        printf("\xBA VOCE DEVE USAR AS SETAS (%c %c) PARA CONTROLAR A BARRINHA\xba\n",174,175);
        printf("\xba SEU OBJETIVO EH DESTRUIR TODOS OS BLOCOS               \xba\n");
        printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");



        printf("\xba SEU OBJETIVO EH DESTRUIR TODOS OS BLOCOS APERTE ESC    \xba\n");
        printf("\xc8\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xcd\xBc\n");

        printf("\n\n");
        teste=getch();
        system("cls");
        if (teste==27)
            system("cls");
        menu();

        }
    else if(op==3){
        exit(0);
    }

        }

    system("cls");
      if(op>3)
            op=0;

      if(op<0)
            op=3;

    }while(esco!=ENTER);
    }
