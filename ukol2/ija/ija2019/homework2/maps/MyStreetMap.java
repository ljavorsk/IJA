/**
 * @author xjavor20
 */

package ija.ija2019.homework2.maps;

import java.util.HashMap;
import java.util.Map;

import ija.ija2019.homework2.maps.StreetMap;

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