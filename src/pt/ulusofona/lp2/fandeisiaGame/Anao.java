package pt.ulusofona.lp2.fandeisiaGame;

public class Anao extends Creature {
    public static final String DESCRICAO ="Só anda uma casa e nunca nas diagonais";//variavel static por ser final, o valor tipo não altera
    public static final String TIPO = "Anao";//variavel static por ser final, o valor tipo não altera
    public static final String IMAGE_PNG = "anao.png";//variavel static por ser final, o valor tipo não altera
    public static final String COST = "1";//variavel static por ser final, o valor tipo não altera
    private int movement;
    private static final int INICIALMOVEMENT = 1;//variavel static por ser final, o valor tipo não altera
    int custo;


    Anao(  int id, int idEquipa, int x, int y, String orientacao){
        super( id,  idEquipa,  TIPO,  IMAGE_PNG,  DESCRICAO, x, y,  orientacao);
        movement=INICIALMOVEMENT;
        this.custo=1;

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

    public int getCost(){
        return this.custo;
    }




}
