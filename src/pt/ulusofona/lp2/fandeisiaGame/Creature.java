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
    String orientacao = "Norte";
    int x;
    int y;



    Creature(){}

    Creature( int id, int idEquipa, String tipo, String imagePNG, String descricao, int custo, String orientacao){
        this.tipo=tipo;
        this.imagePNG=imagePNG;
        this.descricao = descricao;
        this.custo = custo;
        this.id = id;
        this.idEquipa = idEquipa;

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
    public int getNrPontos(){
        return nrPontos;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setMaisY(){
        y++;
    }
    public void setMenosY(){
        y--;
    }
    public void setMaisX(){x++;}
    public void setMenosX(){x--;}

    public String getCoordenadas(){
        String pontos;
        pontos = ("("+getX()+","+getY()+")");
        return pontos;
    }
    public String getOrientacao(){
        return orientacao;
    }



    public void setOrientacao(String orientacao){

        this.orientacao = orientacao;


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
        return (id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " | @ " + x + " | " +
                y);
    }

}
