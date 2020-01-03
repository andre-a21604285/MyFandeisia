package pt.ulusofona.lp2.fandeisiaGame;

public class Gigante extends Creature {
    public static final String DESCRICAO ="Anda tres casas mas nunca nas diagonais";//variavel static por ser final, o valor tipo não altera
    public static final String TIPO = "Elfo";//variavel static por ser final, o valor tipo não altera
    public static final String IMAGE_PNG = "bird.png";//variavel static por ser final, o valor tipo não altera
    public static final String COST = "5";//variavel static por ser final, o valor tipo não altera
    private int movement;
    private static final int INICIALMOVEMENT = 3;//variavel static por ser final, o valor tipo não altera
    Gigante( int id, int idEquipa, String orientacao){
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
        }
    }
    public void setOrientation(){
        if(orientacao.equals(normalOrientation.get(normalOrientation.size()-1))){
            orientacao = "Norte";
        }else{
            orientacao = normalOrientation.get(normalOrientation.indexOf(orientacao)+1);
        }
    }
    public void setAlcance(int x){
        this.movement = x;

    }
    public void setAlcanceToNormal(){
        this.movement = INICIALMOVEMENT;
    }
}
