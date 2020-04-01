/*
 * Zdrojové kódy josu součástí zadání 1. úkolu pro předmětu IJA v ak. roce 2019/2020.
 * (C) Radek Kočí
 */
package ija.ija2019.homework2.maps;

/**
 * Reprezentuje zastávku. Zastávka má svůj unikátní identifikátor a dále souřadnice umístění a zná ulici, na které je umístěna.
 * Zastávka je jedinečná svým identifikátorem. Reprezentace zastávky může existovat, ale nemusí mít
 * přiřazeno umístění (tj. je bez souřadnic a bez znalosti ulice). Pro shodu objektů platí, že dvě zastávky jsou shodné, pokud
 * mají stejný identifikátor.
 * @author koci
 */
public interface Stop {

    /**
     * Vrátí identifikátor zastávky.
     * @return Identifikátor zastávky.
     */
    public String getId();
    /**
     * Vrátí pozici zastávky.
     * @return Pozice zastávky. Pokud zastávka existuje, ale dosud nemá umístění, vrací null.
     */
    public Coordinate getCoordinate();
    /**
     * Nastaví ulici, na které je zastávka umístěna.
     * @param s Ulice, na které je zastávka umístěna.
     */
    public void setStreet(Street s);
    /**
     * Vrátí ulici, na které je zastávka umístěna.
     * @return Ulice, na které je zastávka umístěna. Pokud zastávka existuje, ale dosud nemá umístění, vrací null.
     */
    public Street getStreet();

    public static Stop defaultStop(String id, Coordinate c){
        return new Stop(){
            private String id_stop = id;
            private Coordinate coordinate = c;
            private Street street;
        
            @Override
            public String getId() {
                return this.id_stop;
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
            public String toString() {
                return "stop("+ this.id_stop+")";
            }

        };
    }
}
