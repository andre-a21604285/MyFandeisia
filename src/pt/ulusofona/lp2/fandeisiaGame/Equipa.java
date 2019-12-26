package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class Equipa {
    List<Creature> creatures;
    int id, moedas, pontos;

    Equipa(int id){
        this.moedas = 50;
        this.id = id;
        creatures = new ArrayList<Creature>();
        pontos=0;
    }
    public void addCreature(int id, String tipo, String orientacao){
        switch(tipo){
            case "anao":
                creatures.add( new Anao(id,this.id,orientacao));
                setMoedas(Integer.parseInt(Anao.cost));
                break;
            case "dragao":
                creatures.add( new Dragao(id,this.id,orientacao));
                setMoedas(Integer.parseInt(Dragao.cost));
                break;
            case "humano":
                creatures.add( new Humano(id,this.id,orientacao));
                setMoedas(Integer.parseInt(Humano.cost));
                break;
            case "gigante":
                creatures.add( new Gigante(id,this.id,orientacao));
                setMoedas(Integer.parseInt(Gigante.cost));
                break;
            case "elfo":
                creatures.add( new Elfo(id,this.id,orientacao));
                setMoedas(Integer.parseInt(Elfo.cost));
                break;
        }

    }

    public void movimento(){
        for(int i = 0 ; i<creatures.size(); i++){
            creatures.get(i).movimento();
        }
    }

    public void setMoedas(int moedas){
        this.moedas-=moedas;
    }
    public int getMoedas(){
        return moedas;
    }
    public int getId(){return id;}
    public List<Creature> getCreatures(){return creatures;}
    public int getPontos(){return pontos;}

    public void setPontos(int pontos){
        this.pontos += pontos;
    }
}
