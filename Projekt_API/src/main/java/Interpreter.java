import GetData.Country;
import GetData.Currency;
import GetData.Language;
import GetData.Localization;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Interpreter {
    private static JSONObject countryJSON;

    public static Country getCountryByName(String name) {
        String url = "https://restcountries.eu/rest/v2/name/" + name;
        Country country = new Country();
        try{
            countryJSON = APIReader.toJSONObject(APIReader.toJSONArray(APIReader.getAPI(url)).get(0));
            country.setName(getC("name"));
            country.setJsonString(APIReader.getAPI(url));
            for (int i = 0; i < APIReader.toJSONArray(countryJSON.get("borders")).size(); i++) {
                country.addBorder(tagReflector(APIReader.toJSONArray(countryJSON.get("borders")).get(i).toString()));
            }
            for(int i = 0; i < APIReader.toJSONArray(countryJSON.get("timezones")).size(); i++){
                country.addTimeZone(APIReader.toJSONArray(countryJSON.get("timezones")).get(i).toString());
            }
            JSONArray currencies = APIReader.toJSONArray(countryJSON.get("currencies"));
            for(int i = 0; i < APIReader.toJSONArray(countryJSON.get("currencies")).size(); i++){
                JSONObject curency = APIReader.toJSONObject(currencies.get(i));
                country.addCurrency(new Currency(
                        curency.get("name").toString(),
                        curency.get("code").toString(),
                        curency.get("symbol").toString()

                ));
            }
            JSONArray langs = APIReader.toJSONArray(countryJSON.get("languages"));
            for (Object lang : langs) {
                JSONObject jsOb = APIReader.toJSONObject(lang);
                country.addLanguage(new Language(
                        jsOb.get("name").toString(),
                        jsOb.get("nativeName").toString(),
                        jsOb.get("iso639_1").toString(),
                        jsOb.get("iso639_2").toString()
                ));
            }
            country.setLocalization(new Localization(
                    getC("region"),
                    getC("subregion"),
                    Double.parseDouble(APIReader.toJSONArray(countryJSON.get("latlng")).get(0).toString()),
                    Double.parseDouble(APIReader.toJSONArray(countryJSON.get("latlng")).get(1).toString())
            ));

            country.setCapital(getC("capital"));
            country.setNativeName(getC("nativeName"));
            country.setDomain(getC("topLevelDomain"));
            country.setArea((double) countryJSON.get("area"));
            country.setPopulation(Integer.parseInt(getC("population")));
            country.setDemonym(getC("demonym"));
            country.setAlpha2code(getC("alpha2Code"));
            country.setAlpha3code(getC("alpha3Code"));
            return country;

        }catch (Exception ignored){
            System.out.println(
                    """
                    #######################################
                    #      ERROR: COUNTRY NOT FOUND       #
                    #######################################
                    """);
        }
        return null;
    }

    public static Country getCountryByTag(String tag){
        return getCountryByName(tagReflector(tag));
    }

    private static String getC(String element){
        return countryJSON.get(element).toString();
    }

    public static String tagReflector(String tag){
        try{
            return APIReader.toJSONObject(APIReader.getAPI("https://restcountries.eu/rest/v2/alpha/" + tag)).get("name").toString();
        }catch (ParseException ignored) { }
        return null;
    }
}
