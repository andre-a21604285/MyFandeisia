package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Creature {

    int id;
    int idEquipa;
    String imagePNG;
    String tipo;
    String descricao;
    int nrPontos;
    String orientacao;
    int x;
    int y;
    int ouro;
    int prata;
    int bronze;
    protected List<String> normalOrientation = Arrays.asList ("Norte","Este","Sul","Oeste");
    protected List<String> unnormalOrientation = Arrays.asList("Norte","Nordeste","Este","Sudeste","Sul","Sudoeste","Oeste","Noroeste");

    Creature(){}

    Creature( int id, int idEquipa, String tipo, String imagePNG, String descricao, String orientacao){
        this.nrPontos = 0;
        this.ouro = 0;
        this.prata = 0;
        this.bronze = 0;
        this.tipo=tipo;
        this.imagePNG=imagePNG;
        this.descricao = descricao;
        this.id = id;
        this.idEquipa = idEquipa;
        this.orientacao = orientacao;
    }

    public int getId(){return id;}
    public int getIdEquipa(){return idEquipa;}
    public int getNrPontos(){return nrPontos;}
    public int getX(){return x;}
    public void setX(int x){
        this.x = x;
    }
    public int getY(){return y; }
    public void setY(int y){
        this.y = y;
    }
    public int getOuro(){return ouro; }
    public int getPrata(){return prata; }
    public int getBronze(){return bronze; }
    public String getOrientation(){return orientacao;}
    public String getdescricao(){return descricao;}
    public String getTipo(){return tipo;}
    public String getImagePNG(){return imagePNG;}
    public void setNrPontos(int pontos){
        this.nrPontos+=pontos;
    }
    public void setOuro(){
        this.ouro++;
    }
    public void setPrata(){
        this.prata++;
    }
    public void setBronze(){
        this.bronze++;
    }
    public String toString(){return (id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " | @ " + x + " | " +
                y);}
    public abstract int getMovement();
    public abstract void movimento();
    public abstract void setOrientation();
    public abstract void setAlcance(int x);
    public abstract void setAlcanceToNormal();
}
