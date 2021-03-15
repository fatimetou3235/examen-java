package service.console;

import Repository.jdbc.JdbcCommandeRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Commande;
import domain.Fournisseur;
import domain.Produit;
import service.CommandeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleCommandeService implements CommandeService {
    private DataSource bd;
    JdbcCommandeRepository jdbcCommandeRepository;
    ConsoleFournisseurService consoleFournisseurService;
    ConsoleProduitService consoleProduitService;
    private final Scanner scanner;
    public ConsoleCommandeService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcCommandeRepository = new JdbcCommandeRepository(bd);
        consoleFournisseurService = new ConsoleFournisseurService();
        consoleProduitService = new ConsoleProduitService();

    }
    public void menue() {
        System.out.println("\tCommande");
        System.out.println("1-Enregistrer une commande");
        System.out.println("2-Modifier une commande");
        System.out.println("3-lister les commandes");
        System.out.println("4-Retrouver a partir d'un identifiant");
        System.out.println("5-Quiter");
    }

    public void ajout() {
        try{
            Commande    com = new Commande();
            consoleFournisseurService.liste();
            Fournisseur fou = consoleFournisseurService.getByid();
            if(fou == null)return;
            com.setFournisseur(fou);
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            com.setProduit(prod);
            System.out.println("entrez la quantité a commander");
            com.setQteCommande(scanner.nextFloat());
            jdbcCommandeRepository.add(com);
            System.out.println("Commande effectuer avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void Update() {
        this.liste();
        try{
            Commande com = this.getByid();
            if (com == null)return;
            consoleFournisseurService.liste();
            Fournisseur fou = consoleFournisseurService.getByid();
            if(fou == null)return;
            com.setFournisseur(fou);
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            com.setProduit(prod);
            System.out.println("entrez la quantité a commander");
            com.setQteCommande(scanner.nextFloat());
            jdbcCommandeRepository.update(com);
            System.out.println("Commande effectuer avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void liste() {
        System.out.println("Liste des Commande");
        try{
            List<Commande> Lcom = jdbcCommandeRepository.getAll();
            for (Commande com : Lcom) {
                System.out.println(com);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Commande getByid() {
        try{
            System.out.println("entrer l'id du Commande");
            int id = this.lireChoix();
            Commande com = jdbcCommandeRepository.findbyId(id);
            if(com != null){
                System.out.println(com);
                return com;
            }else{
                System.out.println("Commande introuvable");
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
