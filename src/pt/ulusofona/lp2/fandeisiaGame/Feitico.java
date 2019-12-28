package pt.ulusofona.lp2.fandeisiaGame;

public class Feitico {

    public static String nome;
    public static String cost;
    public static String efeito;


    Feitico(String nome){
        this.nome=nome;
        this.cost=cost;
        this.efeito=efeito;
    }

    public int getFeitico(int x, int y, String name){
        if(name.equals("empurraParaNorte")){
            return paraNorte(x,y);
        }else if(name.equals("empurraParaSul")){
            return paraSul(x,y);
        }else if(name.equals("empurraParaEste")){
            return paraEste(x,y);
        }else if(name.equals("empurraParaOeste")){
            return paraOeste(x,y);
        }else if(name.equals("reduzAlcance")){
            return menosAlcance(x,y);
        }else if(name.equals("duplicaAlcance")){
            return maisAlcance(x,y);
        }else if(name.equals("congela")){
            return gelo(x,y);
        }else if(name.equals("congela4Ever")){
            return sempreGelo(x,y);
        }else if(name.equals("descongela")){
            return semGelo(x,y);
        }
        return 0;
    }

    public static String[] empurraParaNorte(){
         nome ="EmpurraParaNorte";
         cost = "1";
         efeito = "Move a criatura 1 unidade para Norte.";
         String descricao[] = {nome,cost,efeito};
         return descricao;
    }

    public static String[] empurraParaSul(){
        nome ="EmpurraParaSul";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Sul.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] empurraParaEste(){
        nome ="EmpurraParaEste";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Este.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] empurraParaOeste(){
        nome ="EmpurraParaOeste";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Oeste.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] reduzAlcance(){
        nome ="ReduzAlcance";
        cost = "2";
        efeito = "Reduz o alcance da criatura para MIN (alcance original, 1)";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] duplicaAlcance(){
        nome ="DuplicaAlcance";
        cost = "3";
        efeito = "Aumenta o alcance da criatura para o dobro.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] congela(){
        nome ="Congela";
        cost = "3";
        efeito = "A criatura alvo não se move neste turno.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] congela4Ever(){
        nome ="Congela4Ever";
        cost = "10";
        efeito = "A criatura alvo não se move mais até ao final do jogo.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }

    public static String[] descongela(){
        nome ="Descongela";
        cost = "8";
        efeito = "Inverte a aplicação de um Feitiço Congela4Ever.\n" +
                "Ou seja, uma criatura que tenha sido congelada com o Congela4Ever pode voltar a mover-se após ser alvo de um Feitiço de Descongela.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }



    private int paraNorte( int x, int y){
        return y+1;
    }
    private int paraSul( int x, int y){
        return y-1;
    }
    private int paraEste( int x, int y){
        return x+1;
    }
    private int paraOeste( int x, int y){return x-1;}
    private int menosAlcance( int x, int y){//reduzir o movimento
        return ;
    }

    private int maisAlcance( int x, int y){//reduzir o movimento
        return ;
    }

    private int gelo( int x, int y){ // congelar
        return ;
    }

    private int sempreGelo( int x, int y){ // congelar o resto do jogo
        return ;
    }

    private int semGelo( int x, int y){ // descongelar
        return ;
    }

}
