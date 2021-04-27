package GetData;

public class Currency {
    private String symbol;
    private String name;
    private String code;

    public Currency(String name, String code, String symbol){
        setName(name);
        setCode(code);
        setSymbol(symbol);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public String getName() {
        return name;
    }
     public String getCode() {
        return code;
    }
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
