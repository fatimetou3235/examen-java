package controller;

import service.CategorieService;
import service.console.ConsoleCategorieService;

import java.util.Scanner;

public class CategorieController {
    CategorieService CategorieService = new ConsoleCategorieService();
    private final Scanner scanner =  new Scanner(System.in);
    public void process(){
        int choix;
        do{

            CategorieService.menue();
            choix = CategorieService.lireChoix();
            switch (choix){
                case 1:
                    //scanner.nextLine();
                    CategorieService.ajout();
                 break;
                case 2:
                    //scanner.nextLine();
                    CategorieService.liste();
                 break;

            }
        }while (choix != 3);
    }
}
