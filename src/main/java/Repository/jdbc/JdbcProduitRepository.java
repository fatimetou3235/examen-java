package Repository.jdbc;

import Repository.ProduitRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Categorie;
import domain.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProduitRepository implements ProduitRepository {
    private final DataSource dataSource;
    public JdbcProduitRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean add(Produit prod) {
        String query = "INSERT into produit value(null,?,?,?,?,?,?)";
        try {

            Connection connection = dataSource.Connection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, prod.getCode());
            statement.setString(2, prod.getNomProduit());
            statement.setString(3, prod.getDescriptionProduit());
            statement.setFloat(4, prod.getQteProduit());
            statement.setFloat(5, prod.getPrixProduit());
            statement.setInt(6, prod.getCategorie().getId());
            statement.execute();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Produit prod) {
        String query = "UPDATE produit set code = ?, nomproduit = ?, description = ?, qteproduit = ?, prixproduit = ?, idcategorie = ? WHERE id = ?";
        try {

            Connection connection = dataSource.Connection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, prod.getCode());
            statement.setString(2, prod.getNomProduit());
            statement.setString(3, prod.getDescriptionProduit());
            statement.setFloat(4, prod.getQteProduit());
            statement.setFloat(5, prod.getPrixProduit());
            statement.setInt(6, prod.getCategorie().getId());
            statement.setInt(7, prod.getId());
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

    public List<Produit> getAll() {
        String query = "SELECT * FROM produit";
        //mapper le résultat
        List<Produit> Lprod = new ArrayList<Produit>();
        try {
            Connection connection = dataSource.Connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String nomproduit = rs.getString("nomproduit");
                String description = rs.getString("description");
                float qteproduit = rs.getFloat("qteproduit");
                float prixproduit = rs.getFloat("prixproduit");
                int idcategorie = rs.getInt("idcategorie");
                //mapping retour db (relationnel) avec objet Prestation
                Categorie categorie = new Categorie();
                categorie.setId(idcategorie);
                Produit produit = new Produit(id,code,nomproduit,description,qteproduit,prixproduit,categorie);
                Lprod.add(produit);
            }
            return Lprod;
        }
        catch (SQLException e) {
            return new ArrayList<Produit>();
        }
        catch (Exception ex){
            return new ArrayList<Produit>();
        }

    }

    public Produit findbyId(int id) {
        String query = "SELECT * from produit where id = ?";
        try {
            Connection connection = dataSource.Connection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Produit produit = new Produit();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idprod = rs.getInt("id");
                String code = rs.getString("code");
                String nomproduit = rs.getString("nomproduit");
                String description = rs.getString("description");
                float qteproduit = rs.getFloat("qteproduit");
                float prixproduit = rs.getFloat("prixproduit");
                int idcategorie = rs.getInt("idcategorie");
                //mapping retour db (relationnel) avec objet Prestation
                Categorie categorie = new Categorie();
                categorie.setId(idcategorie);
                produit = new Produit(id,code,nomproduit,description,qteproduit,prixproduit,categorie);
            }
            if (produit.getId() == 0)return null;
            return produit;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
