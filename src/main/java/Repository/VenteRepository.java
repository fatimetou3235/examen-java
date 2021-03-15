package Repository;

import domain.Vente;

import java.util.List;

public interface VenteRepository {
    public boolean add(Vente cat);
    public boolean update(Vente appro);
    public boolean delete(int id);
    public List<Vente> getAll();
    public Vente findbyId(int id);
}
