package Repository.jdbc;

import Repository.CommandeRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Approvisionnement;
import domain.Commande;
import domain.Fournisseur;
import domain.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCommandeRepository implements CommandeRepository {
    private final DataSource dataSource;
    public JdbcCommandeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean add(Commande com) {
        String query = "INSERT into commande value(null,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, com.getFournisseur().getId());
            statement.setInt(2, com.getProduit().getId());
            statement.setFloat(3, com.getQteCommande());
            statement.execute();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Commande com) {
        String query = "UPDATE commande set idfournisseur = ?, idproduit = ?, qte = ? WHERE id = ?";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, com.getFournisseur().getId());
            statement.setInt(2, com.getProduit().getId());
            statement.setFloat(3, com.getQteCommande());
            statement.setFloat(4, com.getId());
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

    public List<Commande> getAll() {
        String query = "SELECT * FROM commande";
        //mapper le résultat
        List<Commande> lcom = new ArrayList<Commande>();
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                int idProduit = rs.getInt("idproduit");
                int idfournisseur = rs.getInt("idfournisseur");
                float qte = rs.getFloat("qte");
                //mapping retour db (relationnel) avec objet Prestation
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(idfournisseur);
                Produit produit = new Produit();
                produit.setId(idProduit);
                Commande commande = new Commande(
                        id,
                        produit,
                        fournisseur,
                        qte
                );
                lcom.add(commande);
            }
            return lcom;
        }
        catch (SQLException e) {
            return new ArrayList<Commande>();
        }
        catch (Exception ex){
            return new ArrayList<Commande>();
        }
    }

    public Commande findbyId(int id) {
        String query = "SELECT * from commande where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Commande commande = new Commande();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("id");
                int idProduit = rs.getInt("idproduit");
                int idfournisseur = rs.getInt("idfournisseur");
                float qte = rs.getFloat("qte");
                //mapping retour db (relationnel) avec objet Prestation
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(idfournisseur);
                Produit produit = new Produit();
                produit.setId(idProduit);
                 commande = new Commande(
                        idc,
                        produit,
                        fournisseur,
                        qte
                );
            }
            if (commande.getId() == 0)return null;
            return commande;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
