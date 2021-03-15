package Repository.jdbc;

import Repository.FournisseurRepository;
import Repository.jdbc.Mysql.DataSource;
import domain.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcFournisseurRepository implements FournisseurRepository {
    private final DataSource dataSource;
    public JdbcFournisseurRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean add(Fournisseur fou) {
            String query = "INSERT into fournisseur value(null,?,?,?,?)";
            try {

                Connection connection = dataSource.createConnection();
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, fou.getNom());
                statement.setString(2, fou.getTelephone());
                statement.setString(3, fou.getEmail());
                statement.setString(4, fou.getAdresse());
                statement.execute();
                return true;
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        return false;
    }

    public boolean update(Fournisseur fou) {
        String query = "UPDATE fournisseur set nom = ?, telephone = ?, email = ?, adresse = ? WHERE id = ?";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, fou.getNom());
            statement.setString(2, fou.getTelephone());
            statement.setString(3, fou.getEmail());
            statement.setString(4, fou.getAdresse());
            statement.setInt(5, fou.getId());
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

    public List<Fournisseur> getAll() {
        String query = "SELECT * FROM fournisseur";
        //mapper le résultat
        List<Fournisseur> lfou = new ArrayList<Fournisseur>();
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                //mapping retour db (relationnel) avec objet Prestation
                Fournisseur fournisseur = new Fournisseur(id,nom,telephone,email,adresse);
                lfou.add(fournisseur);
            }
            return lfou;
        }
        catch (SQLException e) {
            return new ArrayList<Fournisseur>();
        }
        catch (Exception ex){
            return new ArrayList<Fournisseur>();
        }
    }

    public Fournisseur findbyId(int id) {
        String query = "SELECT * from fournisseur where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            Fournisseur fournisseur = new Fournisseur();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("id");
                String nom = rs.getString("nom");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                //mapping retour db (relationnel) avec objet Prestation
                fournisseur =  fournisseur = new Fournisseur(id,nom,telephone,email,adresse);
            }
            if (fournisseur.getId() == 0)return null;
            return fournisseur;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
