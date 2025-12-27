package pl.niker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    private static final Map<String, String> values = new HashMap<>();

    public static void load() throws IOException {
        Files.lines(Paths.get("config.yml")).forEach(line -> {
            if (line.contains(":") && !line.trim().startsWith("#")) {
                String[] parts = line.split(":", 2);
                values.put(parts[0].trim(), parts[1].trim());
            }
        });
    }

    public static String get(String key) {
        return values.get(key);
    }
}