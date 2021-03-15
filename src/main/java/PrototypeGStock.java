import Repository.jdbc.JdbcCategorieRepository;
import Repository.jdbc.Mysql.MysqlDataSource;
import controller.MainController;
import domain.Categorie;

public class PrototypeGStock {

    public static void main(String args[]){
//        MysqlDataSource bd = new MysqlDataSource();
//       // System.out.println("tunchi");
//        System.out.println(bd.createConnection());
//        JdbcCategorieRepository categorieRepository = new JdbcCategorieRepository(bd);
//        //Categorie cat = new Categorie(1,"gestion");
//        //categorieRepository.findbyId(1);
//        System.out.println(categorieRepository.findbyId(1));
        MainController mainController = new MainController();
        mainController.process();
    }
}
