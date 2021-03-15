package Repository.jdbc;

import Repository.ApprovisionnementRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Approvisionnement;
import domain.Fournisseur;
import domain.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcApprovisionnementRepository implements ApprovisionnementRepository {
    private final DataSource dataSource;

    public JdbcApprovisionnementRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean add(Approvisionnement appro) {
        String query = "INSERT into approvisionnement value(null,?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, appro.getProduit().getId());
            statement.setFloat(2, appro.getQteApp());
            statement.setString(3, appro.getDateApp());
            statement.setInt(4, appro.getFournisseur().getId());
            statement.execute();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Approvisionnement appro) {
        String query = "UPDATE approvisionnement set idproduit = ?, qteapp = ?, dateapp = ?, idfournisseur = ? WHERE idappro = ?";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, appro.getProduit().getId());
            statement.setFloat(2, appro.getQteApp());
            statement.setString(3, appro.getDateApp());
            statement.setInt(4, appro.getFournisseur().getId());
            statement.setInt(5, appro.getId());
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

    public List<Approvisionnement> getAll() {
        String query = "SELECT * FROM approvisionnement";
        //mapper le résultat
        List<Approvisionnement> appro = new ArrayList<Approvisionnement>();
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("idappro");
                int idProduit = rs.getInt("idproduit");
                int idfournisseur = rs.getInt("idfournisseur");
                float qteApp = rs.getInt("qteapp");
                String dateApp = rs.getString("dateapp");
                //mapping retour db (relationnel) avec objet Prestation
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(idfournisseur);
                Produit prod = new Produit();
                prod.setId(idProduit);
                Approvisionnement approvisionnement = new Approvisionnement(
                        id,
                        prod,
                        qteApp,
                        dateApp,
                        fournisseur
                );
                appro.add(approvisionnement);
            }
            return appro;
        }
        catch (SQLException e) {
            return new ArrayList<Approvisionnement>();
        }
        catch (Exception ex){
            return new ArrayList<Approvisionnement>();
        }
    }

    public Approvisionnement findbyId(int id) {
        String query = "SELECT * from approvisionnement where idappro = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Approvisionnement approvisionnement = new Approvisionnement();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idappro = rs.getInt("idappro");
                int idProduit = rs.getInt("idproduit");
                int idfournisseur = rs.getInt("idfournisseur");
                float qteApp = rs.getInt("qteapp");
                String dateApp = rs.getString("dateapp");
                //mapping retour db (relationnel) avec objet Prestation
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(idfournisseur);
                Produit prod = new Produit();
                prod.setId(idProduit);
                approvisionnement = new Approvisionnement(
                        idappro,
                        prod,
                        qteApp,
                        dateApp,
                        fournisseur
                );
            }
            if (approvisionnement.getId() == 0)return null;
            return approvisionnement;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
