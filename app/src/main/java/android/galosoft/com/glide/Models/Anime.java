package android.galosoft.com.glide.Models;

public class Anime {

    private String name;
    private String description;
    private String rating;
    private int nb_episode;
    private String categorie;
    private String studio;
    private String imgage_url;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int nb_episode, String categorie, String studio, String imgage_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.categorie = categorie;
        this.studio = studio;
        this.imgage_url = imgage_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImgage_url() {
        return imgage_url;
    }

    public void setImgage_url(String imgage_url) {
        this.imgage_url = imgage_url;
    }
}
