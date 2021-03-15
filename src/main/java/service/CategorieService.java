package service;

import domain.Categorie;

public interface CategorieService {
    public void menue();
    public void ajout();
    public void Update();
    public void liste();
    public Categorie getByid();
    public int lireChoix();
}
