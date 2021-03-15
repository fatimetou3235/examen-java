package service;

import java.util.Scanner;

public class MainService {
    private final Scanner scanner;

    public MainService() {
        this.scanner = new Scanner(System.in);
    }

    public void bienvenumessage(){
        System.out.println("bienvenue dans le platform de gestion de stock\n");
    }

    public static void MenuePrincipale(){
        System.out.println("-------------------------------------------------------------------\n");
        System.out.println("A. Categorie");
        System.out.println("B. Produit");
        System.out.println("C. Fournisseur");
        System.out.println("D. Commande");
        System.out.println("E. Approvisionnement");
        System.out.println("F. Vente");
        System.out.println("G. Quiter");

    }
    public String lireChoix(){
        return scanner.nextLine();
    }
}
