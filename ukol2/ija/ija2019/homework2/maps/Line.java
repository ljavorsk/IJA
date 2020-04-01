/*
 * Zdrojové kódy jsou součástí zadání 2. úkolu pro předmětu IJA v ak. roce 2019/2020.
 * (C) Lukas Javorsky
 */
package ija.ija2019.homework2.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;


/**
 * Reprezentuje linku autobusovej prevadzky
 * @author xjavor20
 */
public interface Line {
    
    public boolean addStop(Stop stop);

    public boolean addStreet(Street street);

    public List<SimpleImmutableEntry<Street, Stop>> getRoute();

    public static Line defaultLine(String id){
        return new Line(){
            private String id_line = id;
            private List<SimpleImmutableEntry<Street, Stop>> route = new ArrayList<>();
        
                @Override
                public boolean addStreet(Street street) {
                    if (this.route.isEmpty()){        // First street
                        return false;
                    }
                    
                    Street last_street = this.route.get(route.size() -1).getKey();
                    if (!street.follows(last_street)){   // They are not connected
                        return false;
                    }
                    this.route.add(new SimpleImmutableEntry<Street, Stop>(street, null));
                    return true;
                }
        
                @Override
                public boolean addStop(Stop stop) {
                    if (this.route.isEmpty()){      // Starting stop
                        this.route.add(new SimpleImmutableEntry<Street, Stop>(stop.getStreet(), stop));
                        return true;
                    }
                    if (stop.getStreet() != null){      // Stop have street
                        if (stop.getStreet().follows(this.route.get(this.route.size() - 1).getKey())){       // Streets are connected
                            this.route.add(new SimpleImmutableEntry<Street, Stop>(stop.getStreet(), stop));
                            return true;
                        }
                    }
                    return false;
                }

                @Override
                public List<SimpleImmutableEntry<Street, Stop>> getRoute() {
                    return new ArrayList<>(route);
                }

        };
    }
}
