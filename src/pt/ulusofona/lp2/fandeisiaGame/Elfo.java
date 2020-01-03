package pt.ulusofona.lp2.fandeisiaGame;

public class Elfo extends Creature {
    public static final String DESCRICAO ="Anda por todas as casas a volta e duas de cada vez";//variavel static por ser final, o valor tipo não altera
    public static final String TIPO = "Elfo";//variavel static por ser final, o valor tipo não altera
    public static final String IMAGE_PNG = "bird.png";//variavel static por ser final, o valor tipo não altera
    public static final String COST = "5";//variavel static por ser final, o valor tipo não altera
    private int movement;
    private static final int INICIALMOVEMENT = 2;//variavel static por ser final, o valor tipo não altera

    Elfo( int id, int idEquipa, String orientacao){
        super( id,  idEquipa,  TIPO, IMAGE_PNG,  DESCRICAO,  orientacao);
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
