package com.rukon;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private  double price;
    private int quantityStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (this.price>0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;

        if(newQuantity >=0){
            this.quantityStock = newQuantity;
        }
    }

    public void addjustReserve(int quantity){

            int newQuanitiy = this.reserved + quantity;

            if (newQuanitiy <= this.quantityStock) {
                this.reserved = newQuanitiy;
            }

        }





    @Override
    public boolean equals(Object o) {
        System.out.println("Entering StockItem Equal");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;

        String objName = ((StockItem) o).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 30;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.comaparedTo");
        if(this==o) {
            return 0;
        }
        if(o != null){
            return this.name.compareTo(o.getName());
        }

        throw    new NullPointerException();
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
