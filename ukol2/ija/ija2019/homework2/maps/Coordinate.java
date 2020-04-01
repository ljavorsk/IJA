/**
 * @author xjavor20
 */

package ija.ija2019.homework2.maps;


public class Coordinate{

    private int x_coordinate;
    private int y_coordinate;

    /**
     * Constructor
     */
    private Coordinate(int x, int y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    
    public static Coordinate create(int x, int y){
        if (x >= 0 && y >= 0){
            return new Coordinate(x, y);
        }
        return null;
    }

    public int diffX(Coordinate c){
        return this.x_coordinate - c.x_coordinate;
    }

    public int diffY(Coordinate c){
        return this.y_coordinate - c.y_coordinate;
    }

    public int getX(){
        return this.x_coordinate;
    }

    public int getY(){
        return this.y_coordinate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){ // Test for identity
            return true;
        }
        if (!(obj instanceof Coordinate)){ // Test before casting
            return false;
        }
        Coordinate coord_obj = (Coordinate) obj; // Casting
        return (coord_obj.getX() == (this.getX()) && coord_obj.getY() == (this.getY()));
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 42 + this.getX();
        hash = hash * 42 + this.getY();
        return hash;
    }
}
