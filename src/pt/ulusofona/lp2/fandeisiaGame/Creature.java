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
    Ponto coordenadas = new Ponto();


    Creature(){}

    Creature( int id, int idEquipa, String tipo, String imagePNG, String descricao, int custo, String orientacao){
        this.tipo=tipo;
        this.imagePNG=imagePNG;
        this.descricao = descricao;
        this.custo = custo;
        this.id = id;
        this.idEquipa = idEquipa;
        coordenadas.x=1;
        coordenadas.y=1;
    }


    public int getId(){
        return id;
    }
    public int getIdEquipa(){
        return idEquipa;
    }
    public int getCusto(){
        return custo;
    }
    public int getX(){
        return coordenadas.x;
    }
    public int getY(){
        return coordenadas.y;
    }
    public String getOrientacao(){
        return orientacao;
    }



    public String getdescricao(){
        return descricao;
    }

    public String getTipo(){
        return tipo;
    }

    public String getImagePNG(){
        return imagePNG;
    }

    public String toString(){
        return (id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " | @ " + coordenadas + " | " +
                orientacao);
    }

}
