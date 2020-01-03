package pt.ulusofona.lp2.fandeisiaGame;

public class Dragao extends Creature {
    public static final String DESCRICAO ="Voa por todas as casas a volta ";//variavel static por ser final, o valor tipo não altera
    public static final String TIPO = "Dragao";//variavel static por ser final, o valor tipo não altera
    public static final String IMAGE_PNG = "bird.png";//variavel static por ser final, o valor tipo não altera
    public static final String COST = "9";//variavel static por ser final, o valor tipo não altera
    private int movement;
    private static final int INICIALMOVEMENT = 3;//variavel static por ser final, o valor tipo não altera

    Dragao( int id, int idEquipa, String orientacao){
        super( id,  idEquipa,  TIPO,  IMAGE_PNG,  DESCRICAO,  orientacao);
        movement=INICIALMOVEMENT;
    }
    public int getMovement() {return movement;}
    public void movimento(){
        if(orientacao.equals("Norte")){
            y-=movement;
        }else if(orientacao.equals("Sul")){
            y+=movement;
        }else if(orientacao.equals("Este")){
            x+=movement;
        }else if(orientacao.equals("Oeste")){
            x-=movement;
        }else if(orientacao.equals("Nordeste")) {
            y -= movement;
            x += movement;
        }else if(orientacao.equals("Noroeste")){
            y-=movement;
            x-=movement;
        }else if(orientacao.equals("Sudeste")){
            y+=movement;
            x+=movement;
        }else if(orientacao.equals("Sudoeste")){
            y+=movement;
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
    public void setAlcance(int x){
        this.movement = x;

    }
    public void setAlcanceToNormal(){
        this.movement = INICIALMOVEMENT;
    }
}
