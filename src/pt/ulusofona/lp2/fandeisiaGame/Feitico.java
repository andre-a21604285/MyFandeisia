package pt.ulusofona.lp2.fandeisiaGame;

public class Feitico {

    public static String nome;
    public static String cost;
    public static String efeito;


    Feitico(){

    }

    public static String[] EmpurraParaNorte(){
         nome ="EmpurraParaNorte";
         cost = "1";
         efeito = "Move a criatura 1 unidade para Norte.";
         String descricao[] = {nome,cost,efeito};
         return descricao;
    }

    public static String[] EmpurraParaSul(){
        nome ="EmpurraParaSul";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Sul.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] EmpurraParaEste(){
        nome ="EmpurraParaEste";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Este.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] EmpurraParaOeste(){
        nome ="EmpurraParaOeste";
        cost = "1";
        efeito = "Move a criatura 1 unidade para Oeste.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] ReduzAlcance(){
        nome ="ReduzAlcance";
        cost = "2";
        efeito = "Reduz o alcance da criatura para MIN (alcance original, 1)";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] DuplicaAlcance(){
        nome ="DuplicaAlcance";
        cost = "3";
        efeito = "Aumenta o alcance da criatura para o dobro.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] Congela(){
        nome ="Congela";
        cost = "3";
        efeito = "A criatura alvo não se move neste turno.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] Congela4Ever(){
        nome ="Congela4Ever";
        cost = "10";
        efeito = "A criatura alvo não se move mais até ao final do jogo.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
    public static String[] Descongela(){
        nome ="Descongela";
        cost = "8";
        efeito = "Inverte a aplicação de um Feitiço Congela4Ever.\n" +
                "Ou seja, uma criatura que tenha sido congelada com o Congela4Ever pode voltar a mover-se após ser alvo de um Feitiço de Descongela.";
        String descricao[] = {nome,cost,efeito};
        return descricao;
    }
}
