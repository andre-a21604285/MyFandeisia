package pt.ulusofona.lp2.fandeisiaGame;

public class Elfo extends Creature {
    public static final String descricao ="Anda por todas as casas a volta e duas de cada vez";
    public static final String tipo = "Elfo";
    public static final String imagePNG = "bird.png";
    public static final String cost = "5";
    private int movement;

    Elfo( int id, int idEquipa, String orientacao){
        super( id,  idEquipa,  tipo,  imagePNG,  descricao,  orientacao);
        movement=2;
    }
    public int getMovement() {return movement;}
    public void movimento(){
        if(orientacao.equals("Norte")){
            y+=movement;
        }else if(orientacao.equals("Nordeste")){
            y+=movement;
            x+=movement;
        }else if(orientacao.equals("Noroeste")){
            y+=movement;
            x-=movement;
        }else if(orientacao.equals("Sul")){
            y-=movement;
        }else if(orientacao.equals("Sudeste")){
            y-=movement;
            x+=movement;
        }else if(orientacao.equals("Sudoeste")){
            y-=movement;
            x-=movement;
        }else if(orientacao.equals("Este")){
            x+=movement;
        }else if(orientacao.equals("Oeste")){
            x-=movement;
        }
    }
    public void setOrientation(){
        if(orientacao.equals(unnormalOrientation.get(unnormalOrientation.size()-1))){
            orientacao = "Norte";
        }else{
            orientacao = unnormalOrientation.get(unnormalOrientation.indexOf(orientacao)+1);
        }
    }
}
