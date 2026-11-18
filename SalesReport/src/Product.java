public class Product implements IProduct {

    private String[] productNames;
    private int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count += sales[i].length;
        }
        if (count == 0) {
            return 0;
        }

        return (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int highest = -1;
        int popularIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
            if (total > highest) {
                highest = total;
                popularIndex = i;
            }
        }
        return productNames[popularIndex] + " (" + highest + ")";
    }
}

