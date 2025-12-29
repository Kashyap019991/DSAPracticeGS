package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ImMutabilityBreakUserSettings {
    private final Map<String, String> settings;

    // BAD CONSTRUCTOR: Stores the original reference
    public ImMutabilityBreakUserSettings(Map<String, String> settings) {
        this.settings = settings; 
    }
    
    public Map<String, String> getSettings() {
        return Collections.unmodifiableMap(settings);
    }

    public static void main(String[] args) {

        // Outside the immutable class scope
        Map<String, String> originalMap = new HashMap<>();
        originalMap.put("theme", "dark");

        ImMutabilityBreakUserSettings userSettings = new ImMutabilityBreakUserSettings(originalMap);

        // The calling code still has a reference to the 'originalMap'
        // and can modify the internal state of the 'userSettings' object!

        originalMap.put("theme", "light"); // <-- Modifies the map inside userSettings

        System.out.println(userSettings.getSettings().get("theme")); // Output: light (Immutability compromised)
    }


}


