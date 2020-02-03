import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesList {
    private List<Sale> salesList;

    public SalesList(){
        salesList = new ArrayList<>();
    }

    public void add(String manuName, Date date, Integer num, Integer unit){
        Sale sale = new Sale(manuName, date, num, unit);
        this.salesList.add(sale);
    }

    public Sale get(Integer index) {
        return this.salesList.get(index);
    }

    public Integer size(){
        return this.salesList.size();
    }

}
