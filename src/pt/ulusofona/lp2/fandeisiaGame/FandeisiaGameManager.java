package pt.ulusofona.lp2.fandeisiaGame;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class FandeisiaGameManager {

    private int i;
    private int count;
    int turn = 0;
    int linhas;
    int colunas;
    int pontosLDR = 0;
    int pontosRes = 0;
    private boolean jogoADecorrer;
    String[] criaturas = new String[1000]; // variavel necessária para getResults()
    List<Tresure> tresure = new ArrayList();
    List<String> results = new ArrayList<String>();
    Equipa user;
    Equipa computer;
    Equipa corrente;
    Equipa vencedor;
    List<Creature> world;


    public FandeisiaGameManager() {
        user = new Equipa(10);
        computer = new Equipa(20);
        jogoADecorrer = true;
    }

    public void setResults() {
        String resultado;
        String creatures;
        if(vencedor==null){
            resultado="\n Welcome to FANDEISIA \n Resultado: EMPATE \n LRD: " + user.getPontos() + "\n RESISTENCIA: "
                    + computer.getPontos() + "\n Nr. de Turnos jogados: " + turn +"\n----------\n";
        }else{
            String vencedor = "RESISTENCIA";
            String derrotado = "LRD";
            Equipa derr = user;
            if(this.vencedor.getId()==10){
                vencedor = "LRD";
                derrotado = "RESISTENCIA";
                derr = computer;
            }
            resultado="\n Welcome to FANDEISIA \n Resultado: Vitoria da Equipa \n " + vencedor + "\n"
                    + vencedor + " : " + this.vencedor.getPontos() + "\n" + derrotado + " : " + derr.getPontos() +
                    "\n Nr. de Turnos jogados: " + turn +"\n----------\n";
        }
        results.add(resultado);
        for(Creature creature:world){
            creatures= creature.getId() + " : " + creature.getTipo() +" : "+creature.getOuro()+" : "+creature.getPrata()+" : "+creature.getBronze()+" : "
                    +creature.getNrPontos();
            results.add(creatures);
        }
    }

    public int startGame(String[] content, int rows, int columns) {
        Collections.sort(world, new Sort());
        int count;
        for (count = 0; count < content.length; count++) {
            String dados[] = content[count].split(", ");
            dados[0] = dados[0].replace("id: ", "");
            dados[1] = dados[1].replace("type: ", "");
            int id = Integer.parseInt(dados[0]);
            String type = dados[1];
            if (dados[1].equals("treasure")) {
                dados[2] = dados[2].replace("x: ", "");
                dados[3] = dados[3].replace("y: ", "");
                int x = Integer.parseInt(dados[2]);
                int y = Integer.parseInt(dados[3]);
            } else if (dados[1].equals("hole")) {
                dados[2] = dados[2].replace("x: ", "");
                dados[3] = dados[3].replace("y: ", "");
                int x = Integer.parseInt(dados[2]);
                int y = Integer.parseInt(dados[3]);
            } else {
                dados[2] = dados[2].replace("teamId: ", "");
                int teamId = Integer.parseInt(dados[2]);
                dados[3] = dados[3].replace("x: ", "");
                int x = Integer.parseInt(dados[3]);
                dados[4] = dados[4].replace("y: ", "");
                int y = Integer.parseInt(dados[4]);
                dados[5] = dados[5].replace("orientation: ", "");
                String orientation = dados[5];
            }
            count++;
        }
        linhas = rows;
        colunas = columns;
        return validation();
    }
    public void setInitialTeam(int teamId) {
        if(teamId == 10){
            corrente = user;
        }else{
            corrente = computer;
        }
    }
    public void processTurn() {
        //Movimentar criaturas
        if(corrente.getId() == 10)
            corrente=computer;
        else
            corrente=user;
        turn++;
    }
    public List<Creature> getCreatures() {
        world =user.getCreatures();
        world.addAll(computer.getCreatures());//addAll = adiciona uma colecao á lista
        return world;
    }
    public boolean pointsWorld() {
        int point = 0;
        count = 0;
        while (count < world.size()) {
            point = world.get(count).getNrPontos();
            count++;
        }
        if (point > (tresure.size() / 2)) {
            return true;
        }
        return false;
    }
    public String[][] getCreatureTypes() {
        String[][] creatureTypes = new String[5][4];
        creatureTypes[0][0] = Anao.tipo;
        creatureTypes[0][1] = Anao.imagePNG;
        creatureTypes[0][2] = Anao.descricao;
        creatureTypes[0][3] = Anao.cost;

        creatureTypes[1][0] = Dragao.tipo;
        creatureTypes[1][1] = Dragao.imagePNG;
        creatureTypes[1][2] = Dragao.descricao;
        creatureTypes[1][3] = Dragao.cost;

        creatureTypes[2][0] = Humano.tipo;
        creatureTypes[2][1] = Humano.imagePNG;
        creatureTypes[2][2] = Humano.descricao;
        creatureTypes[2][3] = Humano.cost;

        creatureTypes[3][0] = Elfo.tipo;
        creatureTypes[3][1] = Elfo.imagePNG;
        creatureTypes[3][2] = Elfo.descricao;
        creatureTypes[3][3] = Elfo.cost;

        creatureTypes[4][0] = Gigante.tipo;
        creatureTypes[4][1] = Gigante.imagePNG;
        creatureTypes[4][2] = Gigante.descricao;
        creatureTypes[4][3] = Gigante.cost;
        return creatureTypes;
    }
    public String[][] getSpellTypes() {
        String[][] spellTypes = new String[8][3];
        spellTypes[0][0] = Feitico.EmpurraParaNorte()[0];
        spellTypes[0][1] = Feitico.EmpurraParaNorte()[1];
        spellTypes[0][2] = Feitico.EmpurraParaNorte()[2];

        spellTypes[1][0] = Feitico.EmpurraParaSul()[0];
        spellTypes[1][1] = Feitico.EmpurraParaSul()[1];
        spellTypes[1][2] = Feitico.EmpurraParaSul()[2];

        spellTypes[2][0] = Feitico.EmpurraParaEste()[0];
        spellTypes[2][1] = Feitico.EmpurraParaEste()[1];
        spellTypes[2][2] = Feitico.EmpurraParaEste()[2];

        spellTypes[3][0] = Feitico.ReduzAlcance()[0];
        spellTypes[3][1] = Feitico.ReduzAlcance()[1];
        spellTypes[3][2] = Feitico.ReduzAlcance()[2];

        spellTypes[4][0] = Feitico.DuplicaAlcance()[0];
        spellTypes[4][1] = Feitico.DuplicaAlcance()[1];
        spellTypes[4][2] = Feitico.DuplicaAlcance()[2];

        spellTypes[5][0] = Feitico.Congela()[0];
        spellTypes[5][1] = Feitico.Congela()[1];
        spellTypes[5][2] = Feitico.Congela()[2];

        spellTypes[6][0] = Feitico.Congela4Ever()[0];
        spellTypes[6][1] = Feitico.Congela4Ever()[1];
        spellTypes[6][2] = Feitico.Congela4Ever()[2];

        spellTypes[7][0] = Feitico.Descongela()[0];
        spellTypes[7][1] = Feitico.Descongela()[1];
        spellTypes[7][2] = Feitico.Descongela()[2];
        return spellTypes;
    }
    public boolean gameIsOver() {
        if (turn == 15 || tresure.isEmpty() || pointsWorld() == true ) {
            return true;
        }else{
            return false;}
    }
    public int getElementId(int x, int y) {
        int elementId = 0;
        for (i = 0; i < world.size(); i++) {
            if (world.get(i).getX() == x && world.get(i).getY() == y) {
                elementId = world.get(i).getId();
            }
        }
        return elementId;
    }
    public int getCurrentTeamId() {
        return corrente.getId();
    }

    public int getCurrentScore(int teamID) {

        if (teamID == 0) {
            return pontosLDR;
        } else {
            return pontosRes;
        }
    }
    public void setCurrentScore(int teamID) {
        for (i = 0; i < world.size(); i++) {
            if (world.get(i).getIdEquipa() == 0) {
                pontosLDR += world.get(i).getNrPontos();
            } else {
                pontosRes += world.get(i).getNrPontos();
            }
        }
    }
    public List<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("    André Rego  - 21604285  ");
        authors.add("   Gonçalo Matos  - 21600767  ");
        return authors;
    }
    public List<String> getResults() {return results;}

    private int validation(){
        int valor;
        if(user.getMoedas()<0 && computer.getMoedas()<0){
            valor=1;
        }else if(user.getMoedas()<0 && computer.getMoedas()>=0){
            valor=2;
        }else if(user.getMoedas()>=0 && computer.getMoedas()<0){
            valor=3;
        }else{
            valor=0;
        }
        return valor;
    }

}
