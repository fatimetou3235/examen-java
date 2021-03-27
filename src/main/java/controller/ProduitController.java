package controller;

import service.ProduitService;
import service.console.ConsoleProduitService;

public class ProduitController {
    ProduitService produitService = new ConsoleProduitService();
    public void process(){
        int choix;
        do{

            produitService.menue();
            choix = produitService.lireChoix();
            switch (choix){
                case 1:
                    produitService.ajout();
                    break;
                case 2:
                    produitService.liste();
                    break;

            }
        }while (choix != 3);
    }
}
