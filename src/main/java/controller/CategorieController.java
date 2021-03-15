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
                    CategorieService.Update();
                 break;
                case 3:
                    //scanner.nextLine();
                    CategorieService.liste();
                 break;
                case 4:
                    //scanner.nextLine();
                    CategorieService.getByid();
                 break;
            }
        }while (choix != 5);
    }
}
