public class Vehicle {
    private String sipp;
    private String name;
    private float price;
    private String supplier;
    private float rating;

    public Vehicle(String sipp, String name, float price, String supplier, float rating) {
        this.sipp = sipp;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.rating = rating;
    }

    public String getSipp() {
        return sipp;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public float getRating() {
        return rating;
    }


}
