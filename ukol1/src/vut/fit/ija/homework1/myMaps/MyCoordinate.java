/**
 * @author xjavor20
 */

package vut.fit.ija.homework1.myMaps;

import vut.fit.ija.homework1.maps.Coordinate;

public class MyCoordinate implements Coordinate{

    private int x_coordinate;
    private int y_coordinate;

    /**
     * Constructor
     */
    private MyCoordinate(int x_coordinate, int y_coordinate){
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    
    public static MyCoordinate create(int x, int y){
        if (x >= 0 && y >= 0){
            return new MyCoordinate(x, y);
        }
        return null;
    }

    @Override
    public int getX(){
        return this.x_coordinate;
    }

    @Override
    public int getY(){
        return this.y_coordinate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){ // Test for identity
            return true;
        }
        if (!(obj instanceof MyCoordinate)){ // Test before casting
            return false;
        }
        MyCoordinate my_coord_obj = (MyCoordinate) obj; // Casting
        return (my_coord_obj.getX() == (this.getX()) && my_coord_obj.getY() == (this.getY()));
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 42 + this.getX();
        hash = hash * 42 + this.getY();
        return hash;
    }
}