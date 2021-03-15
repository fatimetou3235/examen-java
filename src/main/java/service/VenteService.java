package service;

import domain.Vente;

public interface VenteService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Vente getByid();
    public int lireChoix();

}
