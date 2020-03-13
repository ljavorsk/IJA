/**
 * @author xjavor20
 */

package vut.fit.ija.homework1.myMaps;

import java.util.ArrayList;
import java.util.List;

import vut.fit.ija.homework1.maps.Coordinate;
import vut.fit.ija.homework1.maps.Stop;
import vut.fit.ija.homework1.maps.Street;

public class MyStreet implements Street {

    private String id;
    private List<Coordinate> list_of_coordinates;
    private List<Stop> list_of_stops;

    /**
     * Constructor
     */
    public MyStreet(String id, MyCoordinate coordinate1, MyCoordinate coordinate2){
        this.id = id;
        this.list_of_coordinates = new ArrayList<Coordinate>();
        this.list_of_coordinates.add(coordinate1);
        this.list_of_coordinates.add(coordinate2);

        this.list_of_stops = new ArrayList<Stop>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return this.list_of_coordinates;
    }

    @Override
    public List<Stop> getStops() {
        return this.list_of_stops;
    }

    @Override
    public void addStop(Stop stop) {
        this.list_of_stops.add(stop);
        stop.setStreet(this);
    }
    
}
