package com.rukon;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
    StockItem temp = new StockItem("Bread", 0.90, 100);
    stockList.addStock(temp);

    temp = new StockItem("Jelly", 0.70, 10);
    stockList.addStock(temp);

        temp = new StockItem("Bean", 0.2, 5);
        stockList.addStock(temp);
        temp = new StockItem("Bean", 0.2, 5);
        stockList.addStock(temp);

        temp = new StockItem("Oil", 3.5, 3);
        stockList.addStock(temp);

        temp = new StockItem("Oil", 4.5, 5);
        stockList.addStock(temp);

        temp = new StockItem("Jello", 1, 20);
        stockList.addStock(temp);

        temp = new StockItem("Chicken", 1.80, 30);
        stockList.addStock(temp);

        temp = new StockItem("Banana", 5, 200);
        stockList.addStock(temp);

        System.out.println(stockList);

        Busket rukonsBusket = new Busket("Rukon");
        sellItem(rukonsBusket, "Banana", 100);
        System.out.println(rukonsBusket);
        System.out.println(stockList);

        sellItem(rukonsBusket, "Chicken", 10);
        System.out.println(rukonsBusket);
        System.out.println(stockList);

        checkOut(rukonsBusket);
        System.out.println(rukonsBusket);
        System.out.println(stockList);




    }

public static int sellItem(Busket busket, String item, int quantitiy){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We do not sell " + item);
            return 0;
        }

        if(stockList.addToReverve(item, quantitiy) !=0){
            busket.addToBasket(stockItem, quantitiy);
            return quantitiy;
        }
        return 0;
}

public static void checkOut(Busket busket){
    for (Map.Entry<StockItem, Integer> item : busket.Items().entrySet()){
        if(stockList.sellStock(item.getKey().getName(), item.getValue()) !=0){

            busket.removeFromBasket(item.getKey(), item.getValue());
            System.out.println("Item " + item.getKey().getName() + " with quantity " + item.getValue() + " checked out from the busket" );
        }
    }
    busket.busketClear(busket);
}


}
