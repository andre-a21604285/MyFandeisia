package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipa {
    List<Creature> creatures;
    int id, moedas, pontos, size;


    Equipa(int id){
        this.moedas = 50;
        this.id = id;
        creatures = new ArrayList<Creature>();
        pontos=0;
        size=0;
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
        size++;
        Collections.sort(creatures, new Sort());

    }

    public void movimento(int linhas, int colunas, List<Buraco> holes){
        for(int i = 0 ; i<creatures.size(); i++){
            creatures.get(i).movimento(linhas,colunas);
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
    public int getSize(){return size;}

    //------Private methods----------
    private boolean checkMovement(int linhas, int colunas, Creature creature, List<Buraco> holes){
        String orientacao=creature.getOrientation();
        int x=creature.getX();
        int y=creature.getY();
        int steps=creature.getMovement();
        boolean isValid=false;

        if(orientacao.equals("Norte")){

        }else if(orientacao.equals("Sul")){

        }else if(orientacao.equals("Este")){

        }else if(orientacao.equals("Oeste")){

        }else if(orientacao.equals("Nordeste")){

        }else if(orientacao.equals("Noroeste")){

        }else if(orientacao.equals("Sudoeste")){

        }else if(orientacao.equals("Sudeste")){

        }
        return isValid;
    }

    private boolean isValidMovement(int x, int y, int steps,Creature creature, int linhas, int colunas, List<Buraco> holes){
        boolean isValid = false;
        //fazer um ciclo for( int i=1 ; i<steps; i++) verificar se é x,y ou x&y
        if(x<=linhas && x>=0 && y<=colunas && y>=0 && checkBuraco(x, y, steps,creature, holes)
                && checkPositionCreature(x,y,steps,creature,creatures)){

        }
        return isValid;
    }

    private boolean checkBuraco(int x, int y, int steps,Creature creature, List<Buraco> holes){
        boolean isValid = true;
        //fazer um ciclo for( int i=1 ; i<steps; i++) verificar se é x,y ou x&y
        for(int i=1;i<steps;i++){

            for(int j=0; j<holes.size();j++){
                if(holes.get(j).getX()==x && holes.get(j).getY()==y){
                    isValid=false;
                    break;
                }
            }
        }
        return isValid;
    }

    private boolean checkPositionCreature(int x, int y, int steps,Creature creature, List<Creature> creatures){
        boolean isValid=true;

        return isValid;
    }
}
