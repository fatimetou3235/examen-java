package domain;

public class Categorie {
    private int id;
    private String nomCategorie;

    public Categorie() {
    }

    public Categorie(int id, String nomCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nomCategorie='" + nomCategorie + '\'' +
                '}';
    }
}
