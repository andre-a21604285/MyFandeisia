package pt.ulusofona.lp2.fandeisiaGame;

public class Tresure{
    int id;
    int x;
    int y;
    static final String tipo = "tresure";

    Tresure(){}

    Tresure(int id){
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
