// Listing 8-4 Pokemon Class

import java.util.ArrayList;

public class Pokemon {

    private int no;       // 番号         
    private String name;  // 名前
    private String description;   // 説明
    private Pokemon before;   // 進化前
    private Pokemon after;    // 進化後

    public Pokemon(int no, String name, String description) {
        this.no = no;
        this.name = name;
        this.description = description;
    }

    public void setBefore(Pokemon before) {
        this.before = before;
    }

    public Pokemon getBefore() {
        return before;
    }

    public void setAfter(Pokemon after) {
        this.after = after;
    }

    public Pokemon getAfter() {
        return after;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return no + ": " + name;
    }
}

class PokemonCenter {

    private ArrayList<Pokemon> list;

    public PokemonCenter() {
        list = new ArrayList<>();
        Pokemon p25 = new Pokemon(25, "ピカチュウ",
                "肌は黄色・背に茶色の縞模様があり、耳の先端が黒い。");
        Pokemon p26 = new Pokemon(26, "ライチュウ",
                "ピカチュウから進化したポケモンであり、全体的に体格が良い。");
        Pokemon p172 = new Pokemon(172, "ピチュー",
                "ピカチュウの進化前。ピカチュウとは大きさや頬の色、耳の形が異なる。");
        p25.setAfter(p26);
        p25.setBefore(p172);
        list.add(p25);
        p26.setBefore(p25);
        list.add(p26);
        p172.setAfter(p25);
        list.add(p172);
    }

    public ArrayList<Pokemon> getPokemons() {
        return list;
    }
}
