package service;

import domain.Commande;

public interface CommandeService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Commande getByid();
    public int lireChoix();
}
