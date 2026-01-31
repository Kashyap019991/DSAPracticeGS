package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ImmutableUserSettings {
    private final Map<String, String> settings;

    // GOOD CONSTRUCTOR: Deep clones the map
    public ImmutableUserSettings(Map<String, String> settings) {
        // Creates a brand new HashMap instance containing the data
        this.settings = new HashMap<>(settings); 
    }
    
    public Map<String, String> getSettings() {
        // Returns an unmodifiable view of the internal private map
        return Collections.unmodifiableMap(settings);
    }

    public static void main(String[] args) {
        Map<String, String> originalMap = new HashMap<>();
        originalMap.put("theme", "dark");

        ImmutableUserSettings userSettings = new ImmutableUserSettings(originalMap);

        originalMap.put("theme", "light"); // This modifies the 'originalMap', NOT the internal map

        System.out.println(userSettings.getSettings().get("theme")); // Output: dark (Immutability preserved)
        //Use code with caution.

        //2. Return an immutable map wrapper in the getter:
        //The getter must also return an unmodifiable view (Collections.unmodifiableMap()). If you returned the raw internal HashMap reference, an attacker could cast it back to a HashMap and modify it directly using standard map methods.
        //By using deep cloning in the constructor and wrapping the getter result, you guarantee that the internal state of the ImmutableUserSettings object is fixed for its entire lifetime.



    }
}
