package controller;

import service.VenteService;
import service.console.ConsoleVenteService;

public class VenteController {
    VenteService venteService = new ConsoleVenteService();
    public void process(){
        int choix;
        do{

            venteService.menue();
            choix = venteService.lireChoix();
            switch (choix){
                case 1:
                    venteService.ajout();
                    break;
                case 2:
                    venteService.Update();
                    break;
                case 3:
                    venteService.liste();
                    break;
                case 4:
                    venteService.getByid();
                    break;
            }
        }while (choix != 5);
    }
}
