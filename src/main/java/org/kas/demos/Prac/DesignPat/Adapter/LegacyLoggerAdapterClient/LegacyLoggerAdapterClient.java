package org.kas.demos.Prac.DesignPat.Adapter.LegacyLoggerAdapterClient;

// Target interface expected by the new application
interface Logger {
    void log(String message);
}

// Adaptee: The incompatible legacy logging component
class LegacyLogger {
    public void writeLog(String logMessage) {
        System.out.println("Legacy system logging: " + logMessage);
    }
}

// Adapter: Makes the LegacyLogger compatible with the new Logger interface
class LegacyLoggerAdapter implements Logger {
    private LegacyLogger legacyLogger;

    public LegacyLoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void log(String message) {
        legacyLogger.writeLog(message); // Translates the call
    }
}

// Client code uses the standard interface without knowing the implementation
public class LegacyLoggerAdapterClient {
    public static void main(String[] args) {
        LegacyLogger legacyLogger = new LegacyLogger();
        Logger adapter = new LegacyLoggerAdapter(legacyLogger);
        adapter.log("This is a message from the new system.");
    }
}
