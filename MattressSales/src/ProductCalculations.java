public class ProductCalculations
        implements IProductCalculations {

    private double price;

    // Constructor
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate VAT (15%)
    @Override
    public double GetVat() {

        return price * 0.15;
    }

    // Calculate commission (5%)
    @Override
    public double GetCommission() {

        return price * 0.05;
    }

    // Calculate total amount
    @Override
    public double GetTotal() {

        return price + GetVat() + GetCommission();
    }
}
