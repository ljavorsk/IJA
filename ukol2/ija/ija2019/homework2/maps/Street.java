/*
 * Zdrojové kódy josu součástí zadání 1. úkolu pro předmětu IJA v ak. roce 2019/2020.
 * (C) Radek Kočí
 */
package ija.ija2019.homework2.maps;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Reprezentuje jednu ulici v mapě. Ulice má svůj identifikátor (název) a je definována souřadnicemi. Pro 1. úkol
 * předpokládejte pouze souřadnice začátku a konce ulice.
 * Na ulici se mohou nacházet zastávky.
 * @author koci
 */
public interface Street {

    /**
     * Vrátí identifikátor ulice.
     * @return Identifikátor ulice.
     */
    public String getId();

    /**
     * Vrátí seznam souřadnic definujících ulici. První v seznamu je vždy počátek a poslední v seznamu konec ulice.
     * @return Seznam souřadnic ulice.
     */
    public List<Coordinate> getCoordinates();

    /**
     * Vrátí seznam zastávek na ulici.
     * @return Seznam zastávek na ulici. Pokud ulize nemá žádnou zastávku, je seznam prázdný.
     */
    public List<Stop> getStops();

    /**
     * Přidá do seznamu zastávek novou zastávku.
     * @param stop Nově přidávaná zastávka.
     */
    public boolean addStop(Stop stop);

    public Coordinate end();

    public Coordinate begin();

    public boolean follows(Street s);

    public static Street defaultStreet(String id, Coordinate... coordinates){
        Coordinate previous_c = coordinates[0];
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getX() != previous_c.getX() && coordinate.getY() != previous_c.getY()){
                return null;
            }
            previous_c = coordinate;
        }
        return new Street(){
            private String id_str = id;
            private List<Coordinate> list_of_coordinates = Arrays.asList(coordinates);
            private List<Stop> list_of_stops = new ArrayList<Stop>();
        
            @Override
            public List<Stop> getStops() {
                return this.list_of_stops;
            }
        
            @Override
            public String getId() {
                return this.id_str;
            }
        
            @Override
            public List<Coordinate> getCoordinates() {
                return this.list_of_coordinates;
            }
        
            @Override
            public boolean follows(Street s) {
                if (s == null){
                    return false;
                }
                Coordinate beginning_first = this.begin();
                Coordinate end_first = this.end();

                Coordinate beginning_second = s.getCoordinates().get(0);
                Coordinate end_second = s.getCoordinates().get(s.getCoordinates().size() -1);

                if (beginning_first.equals(end_second) || beginning_second.equals(end_first)){
                    return true;
                }
                else {
                    return false;
                }
            }
        
            @Override
            public Coordinate end() {
                List<Coordinate> street_coords = this.getCoordinates();
                return street_coords.get(street_coords.size() -1);
            }
        
            @Override
            public Coordinate begin() {
                List<Coordinate> street_coords = this.getCoordinates();
                return street_coords.get(0);
            }
        
            @Override
            public boolean addStop(Stop stop) {
                Coordinate stop_c = stop.getCoordinate();
                for (int i = 0; i < this.list_of_coordinates.size() - 1; i++){
                    Coordinate c_A = this.list_of_coordinates.get(i);
                    Coordinate c_B = this.list_of_coordinates.get(i+1);

                    if (c_A.getX() == c_B.getX()){      // Look like __
                        if (c_A.getX() != stop_c.getX()){ continue; }
                        if((stop_c.getY() >= c_A.getY() && stop_c.getY() <= c_B.getY()) ||
                            (stop_c.getY() <= c_A.getY() && stop_c.getY() >= c_B.getY())){   // Inside of street
                                this.list_of_stops.add(stop);
                                stop.setStreet(this);
                                return true;
                        }
                    }
                    else if(c_A.getY() == c_B.getY()) { // Look like |
                        if (c_A.getY() != stop_c.getY()){ continue; }
                        if((stop_c.getX() >= c_A.getX() && stop_c.getX() <= c_B.getX()) || 
                            (stop_c.getX() <= c_A.getX() && stop_c.getX() >= c_B.getX())){   // Inside of street
                                this.list_of_stops.add(stop);
                                stop.setStreet(this);
                                return true;
                        }
                    }
                }
                return false;
            }
        };

    }

}
