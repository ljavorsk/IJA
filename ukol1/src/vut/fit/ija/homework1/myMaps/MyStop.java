/**
 * @author xjavor20
 */

package vut.fit.ija.homework1.myMaps;

import vut.fit.ija.homework1.maps.Coordinate;
import vut.fit.ija.homework1.maps.Stop;
import vut.fit.ija.homework1.maps.Street;

public class MyStop implements Stop {

    private String id;
    private Coordinate coordinate;
    private Street street;

    /**
     * Constructor
     */
    public MyStop(String id, Coordinate coordinate){
        this.id = id;
        this.coordinate = coordinate;
    }

    /**
     * Overloaded constructor
     */
    public MyStop(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public void setStreet(Street s) {
        this.street = s;
    }

    @Override
    public Street getStreet() {
        return this.street;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){ // Test for identity
            return true;
        }
        if (!(obj instanceof MyStop)){ // Test before casting
            return false;
        }
        MyStop my_stop_obj = (MyStop) obj; // Casting
        return (my_stop_obj.id.equals(this.id));
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 42 + this.id.hashCode();
        hash = hash * 42 + (this.coordinate == null ? 0 : this.coordinate.hashCode());
        hash = hash * 42 + (this.street == null ? 0 : this.street.hashCode());
        return hash;
    }
    
}