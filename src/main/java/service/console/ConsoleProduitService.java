package service.console;

import Repository.jdbc.JdbcProduitRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Produit;
import service.ProduitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleProduitService implements ProduitService {
    private DataSource bd;
    JdbcProduitRepository jdbcProduitRepository;
    ConsoleCategorieService consoleCategorieService;
    private final Scanner scanner;
    public ConsoleProduitService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcProduitRepository = new JdbcProduitRepository(bd);
        consoleCategorieService = new ConsoleCategorieService();
    }
    public void menue() {
        System.out.println("\tProduit");
        System.out.println("1-Enregistrer un produit");
        System.out.println("2-Modifier un produit");
        System.out.println("3-lister les produits");
        System.out.println("4-Retrouver a partir d'un identifiant");
        System.out.println("5-Quiter");
    }

    public void ajout() {
        try{
            Produit prod = new Produit();
            scanner.nextLine();
            System.out.println("entrez le code");
            prod.setCode(scanner.nextLine());
            System.out.println("entrez le nom du produit");
            prod.setNomProduit(scanner.nextLine());
            System.out.println("entrer la description");
            prod.setDescriptionProduit(scanner.nextLine());
            this.consoleCategorieService.liste();
            prod.setCategorie(consoleCategorieService.getByid());
            System.out.println("entrer la quantite");
            prod.setQteProduit(scanner.nextFloat());
            System.out.println("entrer le prix unitaire");
            prod.setPrixProduit(scanner.nextFloat());
            jdbcProduitRepository.add(prod);
            System.out.println("Produit ajouter avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void Update() {
        this.liste();
        try{

            Produit prod = this.getByid();
            if (prod == null) return;
            scanner.nextLine();
            System.out.println("entrez le code");
            prod.setCode(scanner.nextLine());
            System.out.println("entrez le nom du produit");
            prod.setNomProduit(scanner.nextLine());
            System.out.println("entrer la description");
            prod.setDescriptionProduit(scanner.nextLine());
            this.consoleCategorieService.liste();
            prod.setCategorie(consoleCategorieService.getByid());
            System.out.println("intrer la quantite");
            prod.setQteProduit(scanner.nextFloat());
            System.out.println("entrer le prix unitaire");
            prod.setPrixProduit(scanner.nextFloat());
            jdbcProduitRepository.update(prod);
            System.out.println("Produit Modifier avec succès");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void liste() {
        System.out.println("Liste des produits");
        try{
            List<Produit> Lprod = jdbcProduitRepository.getAll();
            for (Produit prod : Lprod) {
                System.out.println(prod);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Produit getByid() {
        try{
            System.out.println("entrer l'id du produit");
            int id = this.lireChoix();
            Produit prod = jdbcProduitRepository.findbyId(id);
            if(prod != null){
                System.out.println(prod);
                return prod;
            }else{
                System.out.println("produit introuvable");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public int lireChoix() {
        return scanner.nextInt();
    }
}
