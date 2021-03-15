package service.console;

import Repository.jdbc.JdbcFournisseurRepository;
import Repository.jdbc.JdbcProduitRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Fournisseur;
import service.FournisseurService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleFournisseurService implements FournisseurService {
    private DataSource bd;
    JdbcFournisseurRepository jdbcFournisseurRepository;
    private final Scanner scanner;
    public ConsoleFournisseurService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcFournisseurRepository = new JdbcFournisseurRepository(bd);
    }
    public void menue() {
        System.out.println("\tFournisseur");
        System.out.println("1-Enregistrer un fournisseur");
        System.out.println("2-Modifier un fournisseur");
        System.out.println("3-lister les fournisseur");
        System.out.println("4-Retrouver a partir d'un identifiant");
        System.out.println("5-Quiter");
    }

    public void ajout() {
        try{
            Fournisseur fou = new Fournisseur();
            scanner.nextLine();
            System.out.println("entrez le nom");
            fou.setNom(scanner.nextLine());
            System.out.println("entrez le telephone");
            fou.setTelephone(scanner.nextLine());
            System.out.println("entrer l'email");
            fou.setEmail(scanner.nextLine());
            System.out.println("entrer l'adresse");
            fou.setAdresse(scanner.nextLine());;
            jdbcFournisseurRepository.add(fou);
            System.out.println("Fournisseur ajouter avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void Update() {
        this.liste();
        try{
            //System.out.println("selectionner l'id du fournisseur a modifier");
            Fournisseur fou = this.getByid();
            if(fou == null )return;
            scanner.nextLine();
            System.out.println("entrez le nom");
            fou.setNom(scanner.nextLine());
            System.out.println("entrez le telephone");
            fou.setTelephone(scanner.nextLine());
            System.out.println("entrer l'email");
            fou.setEmail(scanner.nextLine());
            System.out.println("entrer l'adresse");
            fou.setAdresse(scanner.nextLine());;
            jdbcFournisseurRepository.update(fou);
            System.out.println("Fournisseur modifier avec succès");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void liste() {
        System.out.println("Liste des fournisseur");
        try{
            List<Fournisseur> Lfou = jdbcFournisseurRepository.getAll();
            for (Fournisseur fou : Lfou) {
                System.out.println(fou);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Fournisseur getByid() {
        try{
            System.out.println("entrer l'id du fournisseur");
            int id = this.lireChoix();
            Fournisseur fou = jdbcFournisseurRepository.findbyId(id);
            if(fou != null){
                System.out.println(fou);
            }else{
                System.out.println("fournisseur introuvable");
            }
            return fou;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public int lireChoix() {
        return scanner.nextInt();
    }
}
