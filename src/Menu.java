import java.util.List;

public class Menu {
    private String name;
    private String genre;
    private Integer price;
    private Integer stock;
    private List<String> recipeName;

    public Menu(String name, String genre, Integer price, List<String> recipeName){
        this.name = name;
        this.genre =genre;
        this.price = price;
        this.stock = 0;
        this.recipeName = recipeName;
    }

    public String getName(){
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public Integer getPrice(){
        return this.price;
    }

    public List<String> getRecipeName(){
        return this.recipeName;
    }

    public Integer getStock(){
        return this.stock;
    }

    public void addStock(Integer num) {
        this.stock += num;
    }

    public void delStock(Integer num){
        this.stock -= num;
    }
}
