package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class Creature {

    int id;

    String creatureTypes;
    List<Ponto> coordenadas= new ArrayList();


    Creature(){}

    Creature( int id, String tipo){
        this.id=id;
        this.creatureTypes=creatureTypes;
    }

}
