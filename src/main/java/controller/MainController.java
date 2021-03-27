package controller;


import service.MainService;

import java.util.Scanner;

public class MainController {

    CategorieController categorieController;
    ProduitController produitController;
   public MainController() {

       categorieController = new CategorieController();
       produitController = new ProduitController();
    }
    private final Scanner scanner = new Scanner(System.in);

    public void process(){
        MainService mainService = new MainService();
        String choix = "";
        do{
            mainService.message();
            mainService.MenuePrincipale();
            choix = mainService.lireChoix();
            System.out.println(choix);
            if(choix.contains("A") || choix.contains("a") ) categorieController.process();
            if(choix.contains("B") || choix.contains("b")) produitController.process();
        }while(!choix.contains("C") && !choix.contains("c"));
    }
}
