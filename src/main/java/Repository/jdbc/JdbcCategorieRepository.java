package Repository.jdbc;

import Repository.CategorieRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Approvisionnement;
import domain.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCategorieRepository implements CategorieRepository {
    private final DataSource dataSource;
    public JdbcCategorieRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean add(Categorie cat) {
        String query = "INSERT into categorie value(null,?)";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cat.getNomCategorie());
            //System.out.println(statement.execute());
            statement.execute();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Categorie cat) {
        String query = "UPDATE categorie set nom = ? WHERE id = ?";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, cat.getNomCategorie());
            statement.setInt(2, cat.getId());
            statement.executeUpdate();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        return false;
    }

    public List<Categorie> getAll() {
        String query = "SELECT * FROM categorie";
        //mapper le résultat
        List<Categorie> Lcat = new ArrayList<Categorie>();
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;
            Categorie cat  = new Categorie();
            while (rs.next()) {
                int idcat = rs.getInt("id");
                String nom = rs.getString("nom");
                //mapping retour db (relationnel) avec objet Prestation
                cat = new Categorie(idcat, nom);

                Lcat.add(cat);
            }
            return Lcat;
        }
        catch (SQLException e) {
            return new ArrayList<Categorie>();
        }
        catch (Exception ex){
            return new ArrayList<Categorie>();
        }
    }

    public Categorie findbyId(int id) {
        String query = "SELECT * FROM `categorie` WHERE id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Categorie cat = new Categorie();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idcat = rs.getInt("id");
                String nom = rs.getString("nom");
                //mapping retour db (relationnel) avec objet Prestation
                cat = new Categorie(idcat, nom);
            }
            if (cat.getId() == 0)return null;
            return cat;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
