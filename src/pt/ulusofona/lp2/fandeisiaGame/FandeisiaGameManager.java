package pt.ulusofona.lp2.fandeisiaGame;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class FandeisiaGameManager {

    private int i;
    int turn = 0;
    int linhas;
    int colunas;
    List<String> results = new ArrayList<String>();
    Equipa user;
    Equipa computer;
    Equipa corrente;
    Equipa vencedor;
    List<Creature> world;
    List<Tresure> tresures = new ArrayList();
    List<Buraco> holes = new ArrayList();
    Map<String,Creature> feiticosTurno;
    List<Creature> congelados;
    Mapa map;

    public FandeisiaGameManager() {
        user = new Equipa(10);
        computer = new Equipa(20);
        feiticosTurno = new HashMap<>();
        congelados = new ArrayList();
        map = new Mapa(linhas,colunas);
    }

    public void addCreature(Equipa equipa, int id, String tipo, String orientacao){
        equipa.addCreature(id,tipo,orientacao);
        //adicionar no mapa
        //map.addPosition();
    }

    public void addTresure(int id, int x , int y){
        map.addPosition(x,y,'t');
        tresures.add(new Tresure(id,x,y));
    }

    public int startGame(String[] content, int rows, int columns) {
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
        if(corrente.getId() == 10){
            corrente=computer;
        }else{
            corrente=user;
        }
        corrente.movimento(linhas,colunas,map);
        turn++;
        tiraGelo();
    }

    public void toggleAI(boolean active){

    }
    public boolean saveGame(File fich){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
            out.writeObject(turn);
            out.writeObject(linhas);
            out.writeObject(colunas);
            out.writeObject(user);
            out.writeObject(computer);
            out.writeObject(corrente);
            out.writeObject(world);
            out.writeObject(tresures);
            out.writeObject(holes);
            out.writeObject(feiticosTurno);
            out.writeObject(congelados);
            out.writeObject(map);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public boolean loadGame(File fich){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fich));
            turn = in.readInt();
            linhas =in.readInt();
            colunas=in.readInt();
            user=(Equipa)in.readObject();
            computer=(Equipa)in.readObject();
            corrente=(Equipa)in.readObject();
            world=(List<Creature>) in.readObject();
            tresures=(List<Tresure>) in.readObject();
            holes=(List<Buraco>) in.readObject();
            feiticosTurno=(Map<String, Creature>) in.readObject();
            congelados=(List<Creature>) in.readObject();
            map=(Mapa) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public Map<String, Integer> createComputerArmy(){
        Map<String, Integer> equipa = new HashMap<>();
        equipa.put("Humano", 20);
        return equipa;
    }

    public List<Creature> getCreatures() {
        world =user.getCreatures();
        world.addAll(computer.getCreatures());//addAll = adiciona uma colecao á lista
        return world;
    }

    public String[][] getCreatureTypes() {
        String[][] creatureTypes = new String[5][4];
        creatureTypes[0][0] = Anao.TIPO;
        creatureTypes[0][1] = Anao.IMAGE_PNG;
        creatureTypes[0][2] = Anao.DESCRICAO;
        creatureTypes[0][3] = Anao.COST;

        creatureTypes[1][0] = Dragao.TIPO;
        creatureTypes[1][1] = Dragao.IMAGE_PNG;
        creatureTypes[1][2] = Dragao.DESCRICAO;
        creatureTypes[1][3] = Dragao.COST;

        creatureTypes[2][0] = Humano.TIPO;
        creatureTypes[2][1] = Humano.IMAGE_PNG;
        creatureTypes[2][2] = Humano.DESCRICAO;
        creatureTypes[2][3] = Humano.COST;

        creatureTypes[3][0] = Elfo.TIPO;
        creatureTypes[3][1] = Elfo.COST;
        creatureTypes[3][2] = Elfo.DESCRICAO;
        creatureTypes[3][3] = Elfo.COST;

        creatureTypes[4][0] = Gigante.TIPO;
        creatureTypes[4][1] = Gigante.IMAGE_PNG;
        creatureTypes[4][2] = Gigante.DESCRICAO;
        creatureTypes[4][3] = Gigante.COST;
        return creatureTypes;
    }

    public String[][] getSpellTypes() {
        String[][] spellTypes = new String[9][3];
        spellTypes[0][0] = Feitico.empurraParaNorte()[0];
        spellTypes[0][1] = Feitico.empurraParaNorte()[1];
        spellTypes[0][2] = Feitico.empurraParaNorte()[2];

        spellTypes[1][0] = Feitico.empurraParaSul()[0];
        spellTypes[1][1] = Feitico.empurraParaSul()[1];
        spellTypes[1][2] = Feitico.empurraParaSul()[2];

        spellTypes[2][0] = Feitico.empurraParaEste()[0];
        spellTypes[2][1] = Feitico.empurraParaEste()[1];
        spellTypes[2][2] = Feitico.empurraParaEste()[2];

        spellTypes[3][0] = Feitico.empurraParaOeste()[0];
        spellTypes[3][1] = Feitico.empurraParaOeste()[1];
        spellTypes[3][2] = Feitico.empurraParaOeste()[2];

        spellTypes[4][0] = Feitico.reduzAlcance()[0];
        spellTypes[4][1] = Feitico.reduzAlcance()[1];
        spellTypes[4][2] = Feitico.reduzAlcance()[2];

        spellTypes[5][0] = Feitico.duplicaAlcance()[0];
        spellTypes[5][1] = Feitico.duplicaAlcance()[1];
        spellTypes[5][2] = Feitico.duplicaAlcance()[2];

        spellTypes[6][0] = Feitico.congela()[0];
        spellTypes[6][1] = Feitico.congela()[1];
        spellTypes[6][2] = Feitico.congela()[2];

        spellTypes[7][0] = Feitico.congela4Ever()[0];
        spellTypes[7][1] = Feitico.congela4Ever()[1];
        spellTypes[7][2] = Feitico.congela4Ever()[2];

        spellTypes[8][0] = Feitico.descongela()[0];
        spellTypes[8][1] = Feitico.descongela()[1];
        spellTypes[8][2] = Feitico.descongela()[2];
        return spellTypes;
    }

    public boolean gameIsOver() {
        if (turn == 15 || tresures.isEmpty() || pointsWorld() == true ) {
            return true;
        }
            return false;
    }

    public boolean enchant(int x, int y, String spellName){ //vamos fazer um arraybidimensional

        Feitico feitico = new Feitico(spellName);
        Creature creature = getCreatureByPosition(x, y);
        if(creature==null){
            return false;
        }else if(caiuEmBuraco(spellName,creature)){
            return false;
        }
        feitico.getFeitico(creature,spellName);
        feiticosTurno.put(spellName,creature);
        if(spellName.equals("congela")){
            congelados.add(creature);
        }
        return true;
    }

    public String getSpell(int x, int y) { //verificar no mapa de feiticos qual a criatura afetada
        String spellName="";
        for (Map.Entry<String, Creature> entry : feiticosTurno.entrySet()) {
            Creature v = entry.getValue();
            if(v.getX() == x && v.getY()==y ){
                spellName = entry.getKey();
                break;
            }
        }
        return spellName;
    }

    public int getElementId(int x, int y) {
        int elementId = 0;
        int all=world.size()+tresures.size()+holes.size();
        for (i = 0; i < all; i++) {
            if (world.get(i).getX() == x && world.get(i).getY() == y) {
                elementId = world.get(i).getId();
            } else if(tresures.get(i).getX() == x && tresures.get(i).getY() == y){
                elementId = tresures.get(i).getId();
            }else if(holes.get(i).getX() == x && holes.get(i).getY() == y){
                elementId = holes.get(i).getId();
            }
        }
        return elementId;
    }

    public int getCurrentTeamId() {
        return corrente.getId();
    }

    public int getCurrentScore(int teamID) {

        if (teamID == 10) {
            return user.getPontos();
        } else {
            return computer.getPontos();
        }
    }

    public int getCoinTotal(int teamID){
        if (teamID == 10) {
            return user.getMoedas();
        } else {
            return computer.getMoedas();
        }
    }

    public List<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("    André Rego  - 21604285  ");
        authors.add("   Gonçalo Matos  - 21600767  ");
        return authors;
    }

    public String whoIsLordEder(){
        String lord="Ederzito Antonio Macedo Lopes";
        return lord;
    }

    public List<String> getResults() {return results;}

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

    // - Metodos privados - //
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

    private boolean pointsWorld(){
        int sum=0;
        for(Tresure tresure : tresures){
            sum+=tresure.getPoints();//soma os valores de pontos totais no board na variavel sum
        }
        if(user.getPontos() >sum/2 || computer.getPontos() > sum/2){
            return true;
        }
        return false;
    }

    private Creature getCreatureByPosition(int x, int y){
        int i;
        Creature creature=null;
        for(i=0; i<world.size();i++){
            if(world.get(i).getX()==x && world.get(i).getY()==y){
                creature=world.get(i);
                break;
            }
        }
        return creature;
    }
    private boolean hasBuraco(int x, int y){
        int i;
        boolean found=false;
        for(i=0; i<holes.size();i++){
            if(holes.get(i).getX()==x && world.get(i).getY()==y){
                found=true;
                break;
            }
        }
        return found;
    }

    private boolean caiuEmBuraco(String name,Creature creature){
        boolean found = false;
        switch (name){
            case "empurraParaNorte":
                hasBuraco(creature.getX(),creature.getY()+1);
                found=true;
                break;
            case "empurraParaSul":
                hasBuraco(creature.getX(),creature.getY()-1);
                found=true;
                break;
            case "empurraParaEste":
                hasBuraco(creature.getX()+1,creature.getY());
                found=true;
                break;
            case "empurraParaOeste":
                hasBuraco(creature.getX()-1,creature.getY()+1);
                found = true;
                break;
        }
        return found;
    }
    private void tiraGelo(){
        for(int i=0; i<congelados.size();i++){
            congelados.get(i).setAlcanceToNormal();
        }
        congelados.clear();
    }
}

