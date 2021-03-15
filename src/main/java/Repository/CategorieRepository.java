package Repository;

import domain.Approvisionnement;
import domain.Categorie;

import java.util.List;

public interface CategorieRepository {
    public boolean add(Categorie cat);
    public boolean update(Categorie appro);
    public boolean delete(int id);
    public List<Categorie> getAll();
    public Categorie findbyId(int id);
}
