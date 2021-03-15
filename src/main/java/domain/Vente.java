package domain;

public class Vente {
    private int id;
    private String dateVente;
    private Produit produit;
    private float qte;
    private float prixU;
    private float montant;

    public Vente() {
    }

    public Vente(int id, String dateVente, Produit produit, float qte, float prixU, float montant) {
        this.id = id;
        this.dateVente = dateVente;
        this.produit = produit;
        this.qte = qte;
        this.prixU = prixU;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public float getQte() {
        return qte;
    }

    public void setQte(float qte) {
        this.qte = qte;
    }

    public float getPrixU() {
        return prixU;
    }

    public void setPrixU(float prixU) {
        this.prixU = prixU;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "id=" + id +
                ", dateVente='" + dateVente + '\'' +
                ", produit=" + produit +
                ", qte=" + qte +
                ", prixU=" + prixU +
                ", montant=" + montant +
                '}';
    }
}
