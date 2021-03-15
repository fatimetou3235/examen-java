package service.console;

import Repository.jdbc.JdbcVenteRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Produit;
import domain.Vente;
import service.VenteService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleVenteService implements VenteService {
    private DataSource bd;
    JdbcVenteRepository jdbcVenteRepository;
    private final Scanner scanner;
    ConsoleProduitService consoleProduitService;
    public ConsoleVenteService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcVenteRepository = new JdbcVenteRepository(bd);
        consoleProduitService = new ConsoleProduitService();
    }
    public void menue() {
        System.out.println("\tVente");
        System.out.println("1-effecter une vente");
        System.out.println("2-Modifier un vente");
        System.out.println("3-liste des vente");
        System.out.println("4-Retrouver a partir d'un identifiant");
        System.out.println("5-Quiter");

    }

    public void ajout() {
        try{
            Vente vente = new Vente();
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            vente.setProduit(prod);
            Date date = new Date();
            vente.setDateVente(date.getDate()+"/"+date.getMonth()+"/"+date.getYear());
            System.out.println("entrer la quantite");
            vente.setQte(scanner.nextFloat());
            System.out.println("entrer le prix unitaire");
            vente.setPrixU(scanner.nextFloat());
            System.out.println("entrer le Montant");
            vente.setMontant(scanner.nextFloat());
            jdbcVenteRepository.add(vente);
            System.out.println("Vente effectuer avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void Update() {
        this.liste();
        try{

            Vente vente = this.getByid();
            if (vente == null) return;
            consoleProduitService.liste();
            Produit prod = consoleProduitService.getByid();
            if (prod == null)return;
            vente.setProduit(prod);
            //vente.setDateVente(new Date().toString());
            System.out.println("entrer la quantite");
            vente.setQte(scanner.nextFloat());
            System.out.println("entrer le prix unitaire");
            vente.setPrixU(scanner.nextFloat());
            System.out.println("entrer le Montant");
            vente.setMontant(scanner.nextFloat());
            jdbcVenteRepository.update(vente);
            System.out.println("Vente effectuer avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void liste() {
        System.out.println("Liste des ventes");
        try{
            List<Vente> Lvente = jdbcVenteRepository.getAll();
            for (Vente vente : Lvente) {
                System.out.println(vente);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Vente getByid() {
        try{
            System.out.println("entrer l'id du vente");
            int id = this.lireChoix();
            Vente vente = jdbcVenteRepository.findbyId(id);
            if(vente != null){
                System.out.println(vente);
                return vente;
            }else{
                System.out.println("vente introuvable");
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
