package controller;

import service.FournisseurService;
import service.console.ConsoleFournisseurService;

public class FournisseurController {
    FournisseurService fournisseurService = new ConsoleFournisseurService();
    public void process(){
        int choix;
        do{

            fournisseurService.menue();
            choix = fournisseurService.lireChoix();
            switch (choix){
                case 1:
                    fournisseurService.ajout();
                    break;
                case 2:
                    fournisseurService.Update();
                    break;
                case 3:
                    fournisseurService.liste();
                    break;
                case 4:
                    fournisseurService.getByid();
                    break;
            }
        }while (choix != 5);
    }
}
