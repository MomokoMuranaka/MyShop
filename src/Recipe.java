import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private Map<String, Integer> recipe;

    public Recipe(){
        this.recipe = new HashMap<>();
    }

    public void set(String name, Integer calory){
        this.recipe.put(name, calory);
    }

    public Integer getSize(Integer index){
        return this.recipe.size();
    }

    public Integer getCal(String name){
        return this.recipe.get(name);
    }

}

