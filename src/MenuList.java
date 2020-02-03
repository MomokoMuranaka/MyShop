import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuList {
    private Map<String, Menu> menuList;

    public MenuList(){
        this.menuList = new HashMap<>();
    }

    public void add(String name, String genre, Integer price, List recipeList) {
        Menu menu = new Menu(name, genre, price, recipeList);
        this.menuList.put(name, menu);
    }

    public Menu get(String name){
        return this.menuList.get(name);
    }

    public Integer showStock(String genre) {
        Integer stock = 0;
        for (Menu menu : this.menuList.values()) {
            if (menu.getGenre().equals(genre)) {
                stock += menu.getStock();
            }
        }
        return stock;
    }


}
