package Repository;

import domain.Approvisionnement;

import java.util.List;

public interface ApprovisionnementRepository {
    public boolean add(Approvisionnement appro);
    public boolean update(Approvisionnement appro);
    public boolean delete(int id);
    public List<Approvisionnement> getAll();
    public Approvisionnement findbyId(int id);

}
