package service.console;

import Repository.jdbc.JdbcCategorieRepository;
import Repository.jdbc.Mysql.DataSource;
import Repository.jdbc.Mysql.MysqlDataSource;
import domain.Categorie;
import service.CategorieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleCategorieService implements CategorieService {
    private DataSource bd;
    JdbcCategorieRepository jdbcCategorieRepository;
    private final Scanner scanner;
    public ConsoleCategorieService() {
        this.scanner =  new Scanner(System.in);
        bd = new MysqlDataSource();
        jdbcCategorieRepository = new JdbcCategorieRepository(bd);
    }

    public void menue() {
        System.out.println("\tCategorie");
        System.out.println("1-Enregistrer un categorie");
        System.out.println("2-lister les categorie");
        System.out.println("3-Quiter");
    }

    public void ajout() {
        try{
            Categorie cat = new Categorie();
            System.out.println("description");
            scanner.nextLine();
            cat.setNomCategorie(scanner.nextLine());
           jdbcCategorieRepository.add(cat);
            System.out.println("categorie ajouter");
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public void liste() {
        System.out.println("Liste des categorie");
        List<String> li = new ArrayList<String>();

        try{
            List<Categorie> Lcat = jdbcCategorieRepository.getAll();
            for (Categorie cat : Lcat) {
                System.out.println(cat);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Categorie getByid() {
        try{
            System.out.println("entrer l'id du categorie");
        int id = this.lireChoix();
        Categorie cat = jdbcCategorieRepository.findbyId(id);
        if(cat != null){
            System.out.println(cat);
        }else{
            System.out.println("categorie introuvable");
        }
        return cat;
    }catch (Exception e){
        System.out.println(e);
    }
        return null;
    }
    public int lireChoix() {
        return scanner.nextInt();
    }
}
