package GetData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DownloadedCountries {
    private static final List<String> names = new ArrayList<>();
    private static final HashMap<String, Country> connect= new HashMap<>();


    public static void addName(String name){
        names.add(toLC(name));
    }

    public static void addToMap(String s, Country country){
        connect.put(s, country);
    }

    public static boolean containsName(String name){
        return names.stream().anyMatch(e -> e.equals(toLC(name)));
    }

    public static HashMap<String, Country> getConnect() {
        return connect;
    }

    private static String toLC(String l){
        return l.toLowerCase();
    }
}

