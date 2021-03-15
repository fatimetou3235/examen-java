package controller;

import service.CommandeService;
import service.console.ConsoleCommandeService;

public class CommandeController {

    CommandeService commandeService = new ConsoleCommandeService();
    public void process(){
        int choix;
        do{

            commandeService.menue();
            choix = commandeService.lireChoix();
            switch (choix){
                case 1:
                    commandeService.ajout();
                    break;
                case 2:
                    commandeService.Update();
                    break;
                case 3:
                    commandeService.liste();
                    break;
                case 4:
                    commandeService.getByid();
                    break;
            }
        }while (choix != 5);
    }
}
