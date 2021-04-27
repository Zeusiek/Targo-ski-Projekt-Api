import GetData.Country;
import GetData.Currency;
import GetData.Language;

import java.util.List;
import java.util.Scanner;

public abstract class Interface {
    Interface(){ }

    protected static void getInfo(Country country){
        mainInfo(country);
        addLanguages(country);
        borders(country);
        currencies(country);
    }

    private static void mainInfo(Country country){
        System.out.printf(
                """
                #######################################
                #             Information             #
                #######################################
                 Country: %s                           
                 ├ Native name: %s
                 │
                 ├ Alpha codes
                 │ ├ Alpha 2: %s
                 │ └ Alpha 3: %s
                 │
                 ├ Domain: %s
                 ├ Capital: %s
                 ├ Area: %s km²  
                 │ 
                 ├ Population:  
                 │ ├ Total: %s   
                 │ └ Per km²: %s
                 │
                 ├ Localization:
                 │ ├ Region: %s
                 │ ├ Subregion: %s
                 │ └ Coordinates
                 │   ├ Latitude: %s
                 │   └ Longitude: %s
                 │
                 ├ Languages:
                """,
                country.getName(),
                country.getNativeName(),
                country.getAlpha2code(),
                country.getAlpha3code(),
                country.getDomain(),
                country.getCapital(),
                country.getArea(),
                country.getPopulation(),
                country.peoplePerKilometer(),
                country.getLocalization().getRegion(),
                country.getLocalization().getSubregion(),
                country.getLocalization().getLatitude(),
                country.getLocalization().getLongitude()
        );
    }

    private static void addLanguages(Country country){
        List<Language> languages = country.getLanguages();
        for(int i = 0; i < languages.size(); i++){
            if(i + 1 != languages.size()){
                System.out.printf(
                        """
                         │ ├ %s
                         │ │ ├ %s
                         │ │ └ ISO:     
                         │ │   ├ 639_1: %s    
                         │ │   └ 639_2: %s    
                        """,
                        languages.get(i).getName(),
                        languages.get(i).getNativeName(),
                        languages.get(i).getIso639_1(),
                        languages.get(i).getIso639_2()
                );
            }else{
                System.out.printf(
                        """
                         │ └ %s
                         │   ├ %s
                         │   └ ISO:     
                         │     ├ 639_1: %s    
                         │     └ 639_2: %s    
                        """,
                        languages.get(i).getName(),
                        languages.get(i).getNativeName(),
                        languages.get(i).getIso639_1(),
                        languages.get(i).getIso639_2()

                );
            }
        }
    }
    private static void borders(Country country){
        List<String> borders1 = country.getNeighbours();
        System.out.print("""
                 │
                 ├ Neighbours: 
                """);
        for(int i = 0; i < borders1.size(); i++){
            if (i + 1 != borders1.size()){
                System.out.printf("""
                         │ ├ %s
                        """,
                        borders1.get(i)
                        );
            }else {
                System.out.printf("""
                         │ └ %s
                         │
                        """,
                        borders1.get(i)
                );
            }
        }
    }
    private static void currencies(Country country){
        List<Currency> currencies = country.getCurrencies();
        System.out.print("""
                 ├ Currencies:
                """);
        for(int i = 0; i < currencies.size(); i++){
            if (i + 1 != currencies.size()){
                System.out.printf("""
                         │ ├ %s
                         │ │ ├ Code: %s
                         │ │ └ Symbol: %s
                        """,
                        currencies.get(i).getName(),
                        currencies.get(i).getCode(),
                        currencies.get(i).getSymbol()
                );
            }else {
                System.out.printf("""
                         │ └ %s
                         │   ├ Code: %s
                         │   └ Symbol: %s
                         └────────────────────
                         
                         ### Do you want to save? ###
                         1.Yes
                         2.No
                        """,
                        currencies.get(i).getName(),
                        currencies.get(i).getCode(),
                        currencies.get(i).getSymbol()
                );
                int option = new Scanner(System.in).nextInt();
                if(option == 1){
                    ToJSONFile.createFile(country.getName(), country.getJsonString());
                }
            }
        }
    }


}
