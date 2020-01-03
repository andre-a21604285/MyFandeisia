package pt.ulusofona.lp2.fandeisiaGame;
//0=vazio  | b=buracos | h=humanos | a=anao | d=dragao | g=gigante | e=elfo | t=tesouros |
public class Mapa {
    char [][] map;

    Mapa(){}

    Mapa(int linhas, int colunas){
        map = new char[linhas][colunas];
    }
    public void addPosition(int x, int y, char symbol){
        map[x][y] = symbol;

    }

    public boolean isPositionFilled(int x, int y){
        return map[x][y]!='0';
    }

    public boolean checkCreature(int x, int y){
        return map[x][y] != '0' && map[x][y] !='b' && map[x][y] !='t';
    }

    public boolean checkBuraco(int x, int y){
        return map[x][y] == 'b';
    }

    public boolean checkGigante(int x, int y){
        return map[x][y] == 'g';
    }

    public boolean checkTresure(int x, int y){
        return map[x][y] == 't';
    }
}
