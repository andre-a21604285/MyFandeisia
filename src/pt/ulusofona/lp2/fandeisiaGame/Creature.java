package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class Creature {

    int id;
    int idEquipa;
    String imagePNG;
    String tipo;
    String descricao;
    int nrPontos;
    int custo;
    String orientacao;
    List<Ponto> coordenadas= new ArrayList();


    Creature(){}

    Creature( int id, String creatureType, String descricao, int custo){
        this.id=id;
        this.tipo=tipo;
        this.descricao = descricao;
        this.custo = custo;
    }

    public int getId(){
        return id;
    }

    public int getCusto(){
        return custo;
    }


    public String getdescricao(){
        return descricao;
    }

    public String getImagePNG(){
        return imagePNG;
    }

    public String toString(){
        return (id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " | @ " + coordenadas + " | " +
                orientacao);
    }

}
