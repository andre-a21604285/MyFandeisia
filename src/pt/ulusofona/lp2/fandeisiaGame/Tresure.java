package pt.ulusofona.lp2.fandeisiaGame;

public class Tresure{

    int id;
    static final String tipo = "tresure";
    Ponto coordenadas = new Ponto();

    Tresure(){}

    Tresure( int id){
        this.id = id;
        coordenadas.x=2;
        coordenadas.y=2;
    }

    public int getId(){
        return id;
    }


    public int getX(){
        return coordenadas.x;
    }
    public int getY(){
        return coordenadas.y;
    }

}
