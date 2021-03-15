package controller;

import domain.Approvisionnement;
import service.ApprovisionnementService;
import service.console.ConsoleApprovisionnementService;

public class ApprovisionnementController {

        ApprovisionnementService approvisionnementService = new ConsoleApprovisionnementService();
        public void process(){
            int choix;
            do{

                approvisionnementService.menue();
                choix = approvisionnementService.lireChoix();
                switch (choix){
                    case 1:
                        approvisionnementService.ajout();
                        break;
                    case 2:
                        approvisionnementService.Update();
                        break;
                    case 3:
                        approvisionnementService.liste();
                        break;
                    case 4:
                        approvisionnementService.getByid();
                        break;
                }
            }while (choix != 5);
        }

}
