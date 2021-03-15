package domain;

public class Commande{
    private int id;
    private Produit produit;
    private Fournisseur fournisseur;
    private float qteCommande;

    public Commande() {
    }

    public Commande(int id, Produit produit, Fournisseur fournisseur, float qteCommande) {
        this.id = id;
        this.produit = produit;
        this.fournisseur = fournisseur;
        this.qteCommande = qteCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public float getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(float qteCommande) {
        this.qteCommande = qteCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", produit=" + produit +
                ", fournisseur=" + fournisseur +
                ", qteCommande=" + qteCommande +
                '}';
    }
}
