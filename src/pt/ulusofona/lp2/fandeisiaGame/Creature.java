package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class Creature {

    int id;
    int idEquipa;
    String imagePNG;
    String creatureType;
    int nrPontos;
    String orientacao;
    List<Ponto> coordenadas= new ArrayList();


    Creature(){}

    Creature( int id, String creatureType){
        this.id=id;
        this.creatureType=creatureType;
    }

    public int getId(){
        return id;
    }

    public String getImagePNG(){
        return imagePNG;
    }

    public String toString(){
        return (id + " | " + creatureType + " | " + idEquipa + " | " + nrPontos + " | @ " + coordenadas + " | " +
                orientacao);
    }
“<ID> | <Tipo> | <ID Equipa> |
<Nr Pontos> @ (<x>, <y>)
<Orientacão>”
}
