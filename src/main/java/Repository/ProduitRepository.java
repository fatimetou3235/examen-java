package Repository;

import domain.Produit;

import java.util.List;

public interface ProduitRepository {
    public boolean add(Produit cat);
    public boolean update(Produit prod);
    public boolean delete(int id);
    public List<Produit> getAll();
    public Produit findbyId(int id);
}
