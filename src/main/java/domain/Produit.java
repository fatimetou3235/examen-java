package domain;

public class Produit {
    private int id;
    private String code;
    private String nomProduit;
    private String descriptionProduit;
    private float qteProduit;
    private float prixProduit;
    private Categorie categorie;

    public Produit() {
    }

    public Produit(int id, String code, String nomProduit, String descriptionProduit, float qteProduit, float prixProduit, Categorie categorie) {
        this.id = id;
        this.code = code;
        this.nomProduit = nomProduit;
        this.descriptionProduit = descriptionProduit;
        this.qteProduit = qteProduit;
        this.prixProduit = prixProduit;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public float getQteProduit() {
        return qteProduit;
    }

    public void setQteProduit(float qteProduit) {
        this.qteProduit = qteProduit;
    }

    public float getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nomProduit='" + nomProduit + '\'' +
                ", descriptionProduit='" + descriptionProduit + '\'' +
                ", qteProduit=" + qteProduit +
                ", prixProduit=" + prixProduit +
                ", categorie=" + categorie +
                '}';
    }
}
