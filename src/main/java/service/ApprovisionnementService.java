package service;

import domain.Approvisionnement;

public interface ApprovisionnementService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Approvisionnement getByid();
    public int lireChoix();
}
