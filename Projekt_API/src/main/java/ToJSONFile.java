
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ToJSONFile {
    public static void createFile(String name, String jsonObject){
        try {
            File file = new File(name+".json");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8));
            writer.write(jsonObject);
            writer.close();
        }catch (IOException e){
            System.err.println("Error");
        }
    }
}
