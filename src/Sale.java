import java.util.Date;

public class Sale {
    private String manuName;
    private Date date;
    private Integer num;
    private Integer unit;
    private Integer total;

    public Sale(String manuName, Date date, Integer num, Integer unit){
        this.manuName = manuName;
        this.date =date;
        this.num = num;
        this.unit = unit;
        this.total = unit * num;
    }

    public String getName(){
        return this.manuName;
    }

    public Date getDate(){
        return this.date;
    }

    public Integer getNum(){
        return this.num;
    }

    public Integer getUnit(){
        return this.unit;
    }

    public Integer getTotal(){
        return this.total;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setNum(Integer num){
        this.num = num;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setTotal(Integer total){
        this.total = total;
    }

}