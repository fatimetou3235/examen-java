package Repository;

import domain.Produit;

import java.util.List;

public interface ProduitRepository {
    public boolean add(Produit cat);
    public boolean update(Produit appro);
    public boolean delete(int id);
    public List<Produit> getAll();
    public Produit findbyId(int id);
}
