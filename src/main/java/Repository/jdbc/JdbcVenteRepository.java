package Repository.jdbc;

import Repository.VenteRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Produit;
import domain.Vente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenteRepository implements VenteRepository {
    private final DataSource dataSource;
    public JdbcVenteRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean add(Vente vente) {
        String query = "INSERT into vente value(null,?,?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, vente.getDateVente());
            statement.setInt(2, vente.getProduit().getId());
            statement.setFloat(3, vente.getQte());
            statement.setFloat(4, vente.getPrixU());
            statement.setFloat(5, vente.getMontant());
            statement.execute();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Vente vente) {
        String query = "UPDATE vente set datevente = ?, idproduit = ?, qte = ?, prixu = ?, montant = ? WHERE idvante = ?";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, vente.getDateVente());
            statement.setInt(2, vente.getProduit().getId());
            statement.setFloat(3, vente.getQte());
            statement.setFloat(4, vente.getPrixU());
            statement.setFloat(5, vente.getMontant());
            statement.setInt(6, vente.getId());
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

    public List<Vente> getAll() {
        String query = "SELECT * FROM vente";
        //mapper le résultat
        List<Vente> Lvente = new ArrayList<Vente>();
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("idvante");
                String datev = rs.getString("datevente");
                int idprod = rs.getInt("idproduit");
                float qte = rs.getFloat("qte");
                float prixu = rs.getFloat("prixu");
                float montant = rs.getFloat("montant");
                //mapping retour db (relationnel) avec objet Prestation
                Produit produit = new Produit();
                produit.setId(idprod);
                Vente vente = new Vente(id,datev,produit,qte,prixu,montant);
                Lvente.add(vente);
            }
            return Lvente;
        }
        catch (SQLException e) {
            return new ArrayList<Vente>();
        }
        catch (Exception ex){
            return new ArrayList<Vente>();
        }
    }

    public Vente findbyId(int id) {
        String query = "SELECT * from vente where idvante = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Vente vente = new Vente();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idvente = rs.getInt("idvante");
                String datev = rs.getString("datevente");
                int idprod = rs.getInt("idproduit");
                float qte = rs.getFloat("qte");
                float prixu = rs.getFloat("prixu");
                float montant = rs.getFloat("montant");
                //mapping retour db (relationnel) avec objet Prestation
                Produit produit = new Produit();
                produit.setId(idprod);
                vente = new Vente(id,datev,produit,qte,prixu,montant);
            }
            if (vente.getId() == 0)return null;
            return vente;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
