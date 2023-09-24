package d22_09_2023.Zadatak1;

import java.util.ArrayList;

public class Bookmark extends Adresa{

    ArrayList<Adresa> adrese;

    public Bookmark() {
        super();
        this.adrese = new ArrayList<>();
    }

    public Bookmark(ArrayList<Adresa> adrese) {
        this.adrese = adrese;
    }

    public ArrayList<Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(ArrayList<Adresa> adrese) {
        this.adrese = adrese;
    }



    public void dodajAdresu(Adresa url){
        this.adrese.add(url);
    }
}
