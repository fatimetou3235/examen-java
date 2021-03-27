package service;

import java.util.Scanner;

public class MainService {
    private final Scanner scanner;

    public MainService() {
        this.scanner = new Scanner(System.in);
    }

    public void message(){
        System.out.println(" platform de gestion APPRO\n");
    }

    public static void MenuePrincipale(){
        System.out.println("-------------------------------------------------------------------\n");
        System.out.println("A. Categorie");
        System.out.println("B. Produit");
        System.out.println("C. Quiter");

    }
    public String lireChoix(){
        return scanner.nextLine();
    }
}
