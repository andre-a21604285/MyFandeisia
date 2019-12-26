package pt.ulusofona.lp2.fandeisiaGame;

public class Anao extends Creature {
    public static final String descricao ="Só anda uma casa e nunca nas diagonais";
    public static final String tipo = "Anao";
    public static final String imagePNG = "bird.png";
    public static final String cost = "1";
    private int movement;

    Anao( int id, int idEquipa, String orientacao){
        super( id,  idEquipa,  tipo,  imagePNG,  descricao,  orientacao);
        movement=1;
    }

    public int getMovement() {return movement;}
    public void movimento(){
        if(orientacao.equals("Norte")){
            y+=movement;
        }else if(orientacao.equals("Sul")){
            y-=movement;
        }else if(orientacao.equals("Este")){
            x+=movement;
        }else if(orientacao.equals("Oeste")){
            x-=movement;
        }
    }
    public void setOrientation(){
        if(orientacao.equals(normalOrientation.get(normalOrientation.size()-1))){
            orientacao = "Norte";
        }else{
            orientacao = normalOrientation.get(normalOrientation.indexOf(orientacao)+1);
        }
    }
}