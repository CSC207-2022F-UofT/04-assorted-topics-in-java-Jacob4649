/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /**
     * Adds a pair to this {@link DrivableMap} if not matching ID already exists
     * @param id the {@link String} ID for this pair
     * @param d {@link Drivable} object for this pair
     * @return whether the item was added
     */
    public boolean addDrivable(String id, Drivable d) {
        if (!drivable_map.containsKey(id)) {
            drivable_map.put(id, d);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param speed speed to check
     * @return whether any item in this {@link DrivableMap} has
     * a max speed equal or faster than the provided speed
     */
    public boolean hasFasterThan(int speed) {
        for (Drivable d : drivable_map.values()) {
            if (d.getMaxSpeed() >= speed)
                return true;
        }
        return false;
    }

    /**
     * 
     * @return {@link List} of {@link Tradable} items in this {@link DrivableMap}
     */
    public List<Tradable> getTradable() {
        return drivable_map.values().stream()
            .filter(x -> x instanceof Tradable).map(x -> (Tradable) x).collect(Collectors.toList());
    }

    
}