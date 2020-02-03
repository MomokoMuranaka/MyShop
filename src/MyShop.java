import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class MyShop {
    public static void main(String[] args){
        Recipe myRecipe = new Recipe();
        MenuList myMenuList = new MenuList();
        SalesList mySalesList = new SalesList();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                System.out.print(">");
                String[] command = reader.readLine().split(" ", 0);

                switch (command[0]){
                    case "exit":
                        System.out.println("終了します");
                        return;
                    case "makerecipe":
                        myRecipe.set(command[1], Integer.parseInt(command[2]));
                        System.out.println(command[1] + "をレシピに追加しました");
                        break;

                    case "showrecipe":
                        System.out.println("レシピ名 : " + command[1]);
                        System.out.println("エネルギー : " + myRecipe.getCal(command[1]) + "kCal");
                        break;

                    case "makemenu":
                        List<String> recipeList = new ArrayList<>();
                        for(Integer i = 4; i < command.length; i++){
                            recipeList.add(command[i]);
                        }
                        myMenuList.add(command[1], command[2], Integer.parseInt(command[3]), recipeList);
                        System.out.println(command[1] + "をメニューに追加しました");
                        break;

                    case "showmenu":
                        Menu menu1 = myMenuList.get(command[1]);
                        System.out.println("メニュー名 : " + menu1.getName());
                        System.out.println("ジャンル : " + menu1.getGenre());
                        System.out.println("価格 : " + menu1.getPrice() + "円");
                        for(Object s : menu1.getRecipeName()){
                            System.out.println("レシピ : " + s);
                        }
                        break;

                    case "menustatus":
                        List<Integer> priceList = new ArrayList<>();
                        List<Integer> calList = new ArrayList<>();
                        for(Integer i = 1; i < command.length; i++){
                            Integer cal = 0;
                            for(String s : myMenuList.get(command[i]).getRecipeName()){
                                cal += myRecipe.getCal(s);
                            }
                            calList.add(cal);
                            priceList.add(myMenuList.get(command[i]).getPrice());
                        }
                        System.out.println("平均エネルギー : " + getAverage(calList));
                        System.out.println("最低エネルギー : " + getMin(calList));
                        System.out.println("最高エネルギー : " + getMax(calList));
                        System.out.println("平均価格 : " + getAverage(priceList));
                        System.out.println("最低価格 : " + getMin(priceList));
                        System.out.println("最高価格 : " + getMax(priceList));
                        break;

                    case "showstock":
                        System.out.println(command[1] + "の在庫 : " + myMenuList.showStock(command[1]));
                        break;

                    case "addstock":
                        Menu menu2 = myMenuList.get(command[1]);
                        menu2.addStock(Integer.parseInt(command[2]));
                        System.out.println(command[1] + "の在庫を追加しました");
                        System.out.println(command[1] + "の在庫 : " + menu2.getStock());
                        break;

                    case "delstock":
                        Menu menu3 = myMenuList.get(command[1]);
                        menu3.delStock(Integer.parseInt(command[2]));
                        System.out.println(command[1] + "の在庫を減少しました");
                        System.out.println(command[1] + "の在庫 : " + menu3.getStock());
                        break;

                    case "buy":
                        Integer price = 0;
                        for(Integer i = 2; i < command.length; i++){
                            Menu menu4 = myMenuList.get(command[i]);
                            price += menu4.getPrice();
                        }
                        if(price > Integer.parseInt(command[1])) {
                            System.out.println("お金が足りません");
                            break;
                        }
                        for(Integer i = 2; i < command.length; i++){
                            Menu menu4 = myMenuList.get(command[i]);
                            menu4.delStock(1);
                            mySalesList.add(command[i], new Date(), 1, menu4.getPrice());
                        }
                        System.out.println("合計" + price + "円です");
                        break;

                    case "showsales":
                        Integer totalPrice = 0;
                        Map<String, Sale> salesSumList= new HashMap<>();
                        for(Integer i = 0; i<= mySalesList.size(); i++){
                            Sale sale = mySalesList.get(i);
                            if(salesSumList.containsKey(sale.getName())){
                                Sale salesSum = salesSumList.get(sale.getName());
                                salesSum.setDate(new Date());
                                salesSum.setNum(salesSum.getNum() + sale.getNum());
                                salesSum.setTotal(salesSum.getTotal() + sale.getTotal());
                            }
                            else{
                                salesSumList.put(sale.getName(), sale);
                            }
                            totalPrice += sale.getTotal();
                        }

                        for(Sale s : salesSumList.values()){
                            System.out.println(s.getName() + "  単価 : " + s.getUnit() + "  食数 : " + s.getNum() + "  商品計 : " + s.getTotal());
                        }
                        System.out.println("合計 : " + totalPrice);
                        break;

                    default:
                        System.out.println(command[0] + "はわかりません");
                }

            }
        } catch (Exception e) {
            System.err.println("不明なエラーです");
        }
    }

    private static Integer getAverage(List<Integer> list){
        Integer total = 0;
        for(Integer i : list){
            total += i;
        }
        return total/list.size();
    }

    private static Integer getMin(List<Integer> list) {
        Collections.sort(list);
        return list.get(0);
    }

    private static Integer getMax(List<Integer> list) {

        Collections.sort(list);
        return list.get(list.size()-1);
    }


}
