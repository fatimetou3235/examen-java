package service;

import domain.Fournisseur;

public interface FournisseurService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Fournisseur getByid();
    public int lireChoix();
}
