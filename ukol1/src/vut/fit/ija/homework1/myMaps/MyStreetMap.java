/**
 * @author xjavor20
 */

package vut.fit.ija.homework1.myMaps;

import java.util.HashMap;
import java.util.Map;

import vut.fit.ija.homework1.maps.Street;
import vut.fit.ija.homework1.maps.StreetMap;

public class MyStreetMap implements StreetMap {

    private Map<String,Street> map_of_streets;

    /**
     * Constructor
     */
    public MyStreetMap(){
        this.map_of_streets = new HashMap<String, Street>();
    }

    @Override
    public void addStreet(Street s) {
        this.map_of_streets.put(s.getId(), s);
    }

    @Override
    public Street getStreet(String id) {

        // Search
        if (map_of_streets.containsKey(id)){
            return map_of_streets.get(id);
        }
        // Not found
        return null;
    }
}