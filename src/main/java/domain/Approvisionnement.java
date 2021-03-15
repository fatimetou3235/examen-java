package domain;

public class Approvisionnement {
    private int id;
    private Produit produit;
    private float qteApp;
    private String dateApp;
    private Fournisseur fournisseur;

    public Approvisionnement() {
    }

    public Approvisionnement(int id, Produit produit, float qteApp, String dateApp, Fournisseur fournisseur) {
        this.id = id;
        this.produit = produit;
        this.qteApp = qteApp;
        this.dateApp = dateApp;
        this.fournisseur = fournisseur;
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

    public float getQteApp() {
        return qteApp;
    }

    public void setQteApp(float qteApp) {
        this.qteApp = qteApp;
    }

    public String getDateApp() {
        return dateApp;
    }

    public void setDateApp(String dateApp) {
        this.dateApp = dateApp;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Approvisionnement{" +
                "id=" + id +
                ", Produit=" + produit +
                ", qteApp=" + qteApp +
                ", dateApp='" + dateApp + '\'' +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
