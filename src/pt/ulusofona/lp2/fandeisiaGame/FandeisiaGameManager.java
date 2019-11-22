package pt.ulusofona.lp2.fandeisiaGame;
import java.util.*;
import java.lang.*;



import java.util.ArrayList;
import java.util.List;

public class FandeisiaGameManager {

    int i;
    int count;
    int turn = 0;
    boolean over = false;
    int linhas;
    int colunas;
    int teamId = 0;
    int pontosLDR = 0;
    int pontosRes = 0;
    String vencedor;
    int pontosVencedor;
    int pontosDerrotado;
    String derrotado;
    String[] criaturas = new String[1000]; // variavel necessária para getResults()
    List<Creature> world = new ArrayList();
    List<Tresure> tresure = new ArrayList();
    List<String> results = new ArrayList<String>();








    private boolean jogoADecorrer;


    public FandeisiaGameManager() {

        jogoADecorrer = true;


    }

    public boolean pointsWorld() {
        int point = 0;
        count = 0;
        while (count < world.size()) {
            point = world.get(count).getNrPontos();
        }

        if (point > (tresure.size() / 2)) {
            return true;
        }

        return false;

    }

    public String[][] getCreatureTypes() {

        String[][] creatureTypes = new String[1][4];

        creatureTypes[0][0] = "Pássaro";
        creatureTypes[0][1] = "bird.png";
        creatureTypes[0][2] = "Ele voa";
        creatureTypes[0][3] = "100";


        return creatureTypes;
    }

    public void startGame(String[] content, int rows, int columns) {

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
    }


    public void setInitialTeam(int teamId) {
        Creature creature = new Creature();
        creature.idEquipa = teamId;
        world.add(creature);

        for (i = 0; i < world.size(); i++) {
            criaturas[i] = "\n" + world.get(i).toString();
        }
    }

    public void processTurn() {

        Collections.sort(world, new Sort());
        for (i = 0; i < world.size(); i++) {
            for (count = 0; count < world.size(); count++) {
                if (world.get(i).getOrientacao().equals("Norte")) {
                    if (world.get(i).getY() == colunas || world.get(i).getY() == 0 || world.get(i).getY() + 1 == world.get(count).getY() && world.get(i).getX() == world.get(count).getX()) {
                        world.get(i).setOrientacao("Este");
                    } else {
                        world.get(i).setMaisY();
                        if (world.get(i).getX() == tresure.get(count).getX() && world.get(i).getY() == tresure.get(count).getY()) {
                            world.get(i).nrPontos++;
                        }
                    }

                } else if (world.get(i).equals("Sul")) {
                    if (world.get(i).getY() == colunas || world.get(i).getY() == 0 || world.get(i).getY() - 1 == world.get(count).getY() && world.get(i).getX() == world.get(count).getX()) {
                        world.get(i).setOrientacao("Oeste");
                    } else {
                        world.get(i).setMenosY();
                        if (world.get(i).getX() == tresure.get(count).getX() && world.get(i).getY() == tresure.get(count).getY()) {
                            world.get(i).nrPontos++;
                        }
                    }

                } else if (world.get(i).equals("Este")) {
                    if (world.get(i).getX() == linhas || world.get(i).getX() == 0 || world.get(i).getY() == world.get(count).getY() && world.get(i).getX() + 1 == world.get(count).getX()) {
                        world.get(i).setOrientacao("Sul");
                    } else {
                        world.get(i).setMaisX();
                        if (world.get(i).getX() == tresure.get(count).getX() && world.get(i).getY() == tresure.get(count).getY()) {
                            world.get(i).nrPontos++;
                        }
                    }

                } else if (world.get(i).equals("Oeste")) {
                    if (world.get(i).getX() == linhas || world.get(i).getX() == 0 || world.get(i).getY() == world.get(count).getY() && world.get(i).getX() - 1 == world.get(count).getX()) {
                        world.get(i).setOrientacao("Norte");
                    } else {
                        world.get(i).setMenosX();
                        if (world.get(i).getX() == tresure.get(count).getX() && world.get(i).getY() == tresure.get(count).getY()) {
                            world.get(i).nrPontos++;
                        }
                    }
                }


            }


        }

        turn++;
        setCurrentTeamId(teamId);

    }

    public List<Creature> getCreatures() {
        return world;
    }


    public boolean gameIsOver() {

        if (turn == 15) {
            return true;
        } else if (tresure == null) {
            return true;
        } else if (pointsWorld() == true) {
            return true;
        } else {
            return over;
        }


    }

    public List<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("    André Rego  - 21604285  ");
        authors.add("   Gonçalo Matos  - 21600767  ");



        return authors;
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

    public void setCurrentTeamId(int x) {
        if (x == 0) {
            x++;
        } else {
            x--;
        }
    }

    public int getCurrentTeamId() {
        return teamId;
    }

    public String getVencedor() {

        return vencedor;
    }

    public String getDerrotado() {

        return derrotado;
    }


    public void setVencedor() {
        if (pontosLDR > pontosRes) {
            vencedor = "LDR";
            derrotado = "Resistencia";
            pontosVencedor = pontosLDR;
            pontosDerrotado = pontosRes;
        } else if (pontosLDR < pontosRes) {
            vencedor = "Resistencia";
            derrotado = "LDR";
            pontosVencedor = pontosRes;
            pontosDerrotado = pontosLDR;
        } else {
            vencedor = "Empate";
            derrotado = "Empate";
        }

    }

    public void setResults() {


        String empate = "\n Welcome to FANDEISIA \n Resultado: EMPATE \n LRD: " + pontosLDR + "\n RESISTENCIA: "
                + pontosRes + "\n Nr. de Turnos jogados: " + turn + "\n" + criaturas;

        String vitoria = "\n Welcome to FANDEISIA \n Resultado: Vitoria da Equipa \n " + vencedor + "\n"
                + vencedor + " : " + pontosVencedor + "\n" + derrotado + " : " + pontosDerrotado +
                "\n Nr. de Turnos jogados: " + turn;
        results.add(empate);
        results.add(vitoria);

    }


    public List<String> getResults() {

        return results;
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

}
