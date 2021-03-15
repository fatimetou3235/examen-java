package service.console;

import Repository.jdbc.JdbcApprovisionnementRepository;
import Repository.jdbc.JdbcCommandeRepository;
import Repository.jdbc.JdbcFournisseurRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Approvisionnement;
import domain.Fournisseur;
import domain.Produit;
import service.ApprovisionnementService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleApprovisionnementService implements ApprovisionnementService {
    private DataSource bd;
    JdbcApprovisionnementRepository jdbcApprovisionnementRepository;
    ConsoleFournisseurService consoleFournisseurService;
    ConsoleProduitService consoleProduitService;
    private final Scanner scanner;
    public ConsoleApprovisionnementService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcApprovisionnementRepository = new JdbcApprovisionnementRepository(bd);
        consoleFournisseurService = new ConsoleFournisseurService();
        consoleProduitService = new ConsoleProduitService();

    }

    public void menue() {
        System.out.println("\tApprovisionnement");
        System.out.println("1-Enregistrer un approvisionnement");
        System.out.println("2-Modifier un approvisionnement");
        System.out.println("3-lister les approvisionnement");
        System.out.println("4-Retrouver a partir d'un identifiant");
        System.out.println("5-Quiter");
    }

    public void ajout() {
        try{
            Approvisionnement appro = new Approvisionnement();
            consoleFournisseurService.liste();
            Fournisseur fou = consoleFournisseurService.getByid();
            if(fou == null)return;
            appro.setFournisseur(fou);
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            appro.setProduit(prod);
            Date date = new Date();
            appro.setDateApp(date.getDate()+"/"+date.getMonth()+"/"+date.getYear());
            System.out.println("entrez la quantité");
            appro.setQteApp(scanner.nextFloat());
            jdbcApprovisionnementRepository.add(appro);
            System.out.println("Approvisionnement effectuer avec succès");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void Update() {
        this.liste();
        try{
            Approvisionnement appro = this.getByid();
            consoleFournisseurService.liste();
            Fournisseur fou = consoleFournisseurService.getByid();
            if(fou == null)return;
            appro.setFournisseur(fou);
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            appro.setProduit(prod);
            //appro.setDateApp(new Date().toString());
            System.out.println("entrez la quantité");
            appro.setQteApp(scanner.nextFloat());
            jdbcApprovisionnementRepository.update(appro);
            System.out.println("Approvisionnement Modifier avec succès");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void liste() {
        System.out.println("Liste des approvisionnement");
        try{
            List<Approvisionnement> Lapp = jdbcApprovisionnementRepository.getAll();
            for (Approvisionnement app : Lapp) {
                System.out.println(app);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public Approvisionnement getByid() {
        try{
            System.out.println("entrer l'id de approvisionnement");
            int id = this.lireChoix();
            Approvisionnement appro = jdbcApprovisionnementRepository.findbyId(id);
            if(appro != null){
                System.out.println(appro);
                return appro;
            }else{
                System.out.println("approvisionnement introuvable");
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
