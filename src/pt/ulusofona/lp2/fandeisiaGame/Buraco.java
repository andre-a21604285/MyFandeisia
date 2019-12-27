package pt.ulusofona.lp2.fandeisiaGame;

public class Buraco {
    int id;
    int x;
    int y;
    static final String tipo = "buraco";

    Buraco(){}

    Buraco(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}
