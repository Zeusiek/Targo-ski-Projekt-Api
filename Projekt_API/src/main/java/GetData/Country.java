package GetData;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private String alpha2code;
    private String alpha3code;
    private String demonym;
    private List<String> neighbours = new ArrayList<>();
    private String domain;
    private Localization localization;
    private String nativeName;
    private double area;
    private List<Language> languages = new ArrayList<>();
    private List<String> timeZone = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private String capital;
    private String jsonString;
    private int population;

    public double peoplePerKilometer(){
        return population/area;
    }

    public Country(){ }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
    public void setTimeZone(List<String> timeZone) {
        this.timeZone = timeZone;
    }
    public void setAlpha2code(String alpha2code) {
        this.alpha2code = alpha2code;
    }
    public void setAlpha3code(String alpha3code) {
        this.alpha3code = alpha3code;
    }
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setCurrencies(List<Currency> currency) {
        this.currencies = currency;
    }
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }
    public void setTimeZones(List<String> timeZone) {
        this.timeZone = timeZone;
    }
    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public List<Language> getLanguages() {
        return languages;
    }
    public String getAlpha2code() {
        return alpha2code;
    }
    public String getAlpha3code() {
        return alpha3code;
    }
    public String getDemonym() {
        return demonym;
    }
    public String getName() {
        return name;
    }
    public List<String> getNeighbours() {
        return neighbours;
    }
    public double getArea() {
        return area;
    }
    public int getPopulation() {
        return population;
    }
    public List<Currency> getCurrencies() {
        return currencies;
    }
    public String getCapital() {
        return capital;
    }
    public String getDomain() {
        return domain;
    }
    public Localization getLocalization() {
        return localization;
    }
    public String getNativeName() {
        return nativeName;
    }
    public List<String> getTimeZone() {
        return timeZone;
    }
    public String getJsonString() {
        return jsonString;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", alpha2code='" + alpha2code + '\'' +
                ", alpha3code='" + alpha3code + '\'' +
                ", demonym='" + demonym + '\'' +
                ", neighbours=" + neighbours +
                ", domain='" + domain + '\'' +
                ", localization=" + localization +
                ", nativeName='" + nativeName + '\'' +
                ", area=" + area +
                ", languages=" + languages +
                ", timeZone=" + timeZone +
                ", currencies=" + currencies +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }

    public void addBorder(String s){
        neighbours.add(s);
    }
    public void addLanguage(Language l){
        languages.add(l);
    }
    public void addTimeZone(String s){
        timeZone.add(s);
    }
    public void addCurrency(Currency c){
        currencies.add(c);
    }

}

