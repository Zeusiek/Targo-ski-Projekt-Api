package GetData;

public class Language {
    private String name;
    private String nativeName;
    private String iso639_1;
    private String iso639_2;

    public Language(String name, String nativeName, String iso639_1, String iso639_2){
        setIso639_1(iso639_1);
        setIso639_2(iso639_2);
        setName(name);
        setNativeName(nativeName);

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
    public void setIso639_2(String iso639_2) {
        this.iso639_2 = iso639_2;
    }
    public void setIso639_1(String iso639_1) {
        this.iso639_1 = iso639_1;
    }

    public String getName() {
        return name;
    }
    public String getNativeName() {
        return nativeName;
    }
    public String getIso639_1() {
        return iso639_1;
    }
    public String getIso639_2() {
        return iso639_2;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", iso639_1='" + iso639_1 + '\'' +
                ", iso639_2='" + iso639_2 + '\'' +
                '}';
    }
}
