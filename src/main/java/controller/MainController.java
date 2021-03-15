package controller;


import service.MainService;

import java.util.Scanner;

public class MainController {
    ApprovisionnementController approvisionnementController;
    CategorieController categorieController;
    CommandeController commandeController;
    FournisseurController fournisseurController;
    ProduitController produitController;
    VenteController venteController;
   public MainController() {
       approvisionnementController = new ApprovisionnementController();
       categorieController = new CategorieController();
       commandeController = new CommandeController();
       fournisseurController = new FournisseurController();
       produitController = new ProduitController();
       venteController = new VenteController();
    }
    private final Scanner scanner = new Scanner(System.in);

    public void process(){
        MainService mainService = new MainService();
        String choix = "";
        do{
            mainService.bienvenumessage();
            mainService.MenuePrincipale();
            choix = mainService.lireChoix();
            System.out.println(choix);
            if(choix.contains("A") || choix.contains("a") ) categorieController.process();
            if(choix.contains("B") || choix.contains("b")) produitController.process();
            if(choix.contains("C") || choix.contains("c")) fournisseurController.process();
            if(choix.contains("D") || choix.contains("d")) commandeController.process();
            if(choix.contains("E") || choix.contains("e")) approvisionnementController.process();
            if(choix.contains("F") || choix.contains("f")) venteController.process();
            //System.out.println(mainService.lireChoix());
        }while(!choix.contains("G") && !choix.contains("g"));
    }
}
