package pt.ulusofona.lp2.fandeisiaGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FandeisiaGameManager {
    Creature c1 = new Creature(01, 00 ,"Dragao", null , " Cospe Fogo" , 100, "Norte");
    Creature c2 = new Creature(02, 00 ,"Elfo", null , " Faz cenas" , 100, "Sul");

    Tresure t1 = new Tresure(11);

     public FandeisiaGameManager() {

    }

    public String [][] getCreatureTypes() {

        String[][] creatureTypes = new String[1][4];

        creatureTypes[0][0] ="Macaco";
        creatureTypes[0][1] ="bird.png";
        creatureTypes[0][2] = "...";
        creatureTypes[0][3] = "0";



        return creatureTypes;
    }

    public void startGame(String[] content, int rows, int columns){

         int count;
         for(count = 0; count <content.length; count++){
             String dados[] = content[count].split(",");
             dados[0].replace("id: ","");
             dados[1].replace("type: ","");
             dados[2].replace("id: ","");
             dados[3].replace("id: ","");
             dados[4].replace("id: ","");
             dados[5].replace("id: ","");
             int id = Integer.parseInt(dados[0]);
             String type = dados[1];
             if(dados[1].equals("type: treasure")){
                 dados[2].replace("x: ","");
                 dados[3].replace("y: ","");
                 int x = Integer.parseInt(dados[2]);
                 int y = Integer.parseInt(dados[3]);
             }else{
                 dados[2].replace("teamID: ","");
                 dados[3].replace("x: ","");
                 dados[4].replace("y: ","");
                 dados[5].replace("orientation: ","");
                 int teamID = Integer.parseInt(dados[2]);
                 int x = Integer.parseInt(dados[3]);
                 int y = Integer.parseInt(dados[4]);
                 String orientation = dados[5];
             }
             count++;
         }




        rows = 8;
        columns = 8;
    }



    public void setInitialTeam(int teamId){
         if(teamId == 0){

         }

    }

    public List<Creature> getCreatures(){
        ArrayList<Creature> creaturesList = new ArrayList<Creature>();

        return creaturesList;
    }


    public boolean gameIsOver(){
        boolean over = false;

        return over;
    }

    public int getElementId(int x, int y){
        int elementId = 0;

        return elementId;
    }

    public List<String> getResults() {
        ArrayList<String> results = new ArrayList<String>();



        return results;
    }




    public List<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("    André Rego  - 21604285  ");
        authors.add("   Gonçalo Matos  - 21600767  ");


        return authors;
    }

}
