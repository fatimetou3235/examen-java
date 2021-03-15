package service;

import domain.Categorie;
import domain.Produit;

public interface ProduitService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Produit getByid();
    public int lireChoix();
}
