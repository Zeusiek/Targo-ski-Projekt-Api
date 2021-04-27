import GetData.Country;
import GetData.DownloadedCountries;

import java.util.Scanner;

public class MainSystem extends Interface{
    private final Scanner scanner = new Scanner(System.in);
    MainSystem(){
        System.out.print("""
                #######################################
                #       COUNTRIES OF THE WORLD        #
                #######################################
                """);
        options();
    }

    public void options(){
        while (true){
            String name;
            Country country;
            System.out.print("""
                     
                     ### OPTIONS ###
                     1.Get country by name
                     2.Get country by tag
                     3.Exit
                    """);
            int option = scanner.nextInt();
            if(option == 1){
                System.out.print("Name: ");
                name = scanner.next();

                if(!DownloadedCountries.containsName(name)){
                    country = Interpreter.getCountryByName(name);
                    DownloadedCountries.addName(name);
                    DownloadedCountries.addToMap(name, country);
                }else{
                    country = DownloadedCountries.getConnect().get(name);
                }
                getInfo(country);

            }else if(option == 2){
                System.out.print("Tag: ");
                name = scanner.next();
                if(!DownloadedCountries.containsName(Interpreter.tagReflector(name))){
                    country = Interpreter.getCountryByTag(name);
                    DownloadedCountries.addName(Interpreter.tagReflector(name));
                    DownloadedCountries.addToMap(Interpreter.tagReflector(name), country);
                }else{
                    country = DownloadedCountries.getConnect().get(Interpreter.tagReflector(name));
                }
                getInfo(country);

            }else if(option == 3){
                break;
            }
        }
    }
}
