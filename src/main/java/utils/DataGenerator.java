package utils;

import java.util.UUID;

public class DataGenerator {

    public static String generateUniqueName(String prefix) {
        String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return prefix + " " + uuidPart;
    }
}
