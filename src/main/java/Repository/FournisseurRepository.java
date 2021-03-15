package Repository;

import domain.Fournisseur;

import java.util.List;

public interface FournisseurRepository {
    public boolean add(Fournisseur cat);
    public boolean update(Fournisseur appro);
    public boolean delete(int id);
    public List<Fournisseur> getAll();
    public Fournisseur findbyId(int id);
}
