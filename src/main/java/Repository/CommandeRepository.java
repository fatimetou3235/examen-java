package Repository;

import domain.Commande;

import java.util.List;

public interface CommandeRepository {
    public boolean add(Commande cat);
    public boolean update(Commande appro);
    public boolean delete(int id);
    public List<Commande> getAll();
    public Commande findbyId(int id);
}
