public class PrintProduct {
    // Print total sales
    public void PrintTotalSales(IProduct product) {

        System.out.println("TOTAL PRODUCT SALES: "
                + product.GetTotalProductsSold());
    }

    // Print average sales
    public void PrintAverageSales(IProduct product) {

        System.out.println("AVERAGE PRODUCT SALES: "
                + product.GetAverageProductSold());
    }

    // Print most popular product
    public void PrintMostPopularProduct(IProduct product) {

        System.out.println("MOST POPULAR PRODUCT: "
                + product.GetMostPopularProduct());
    }

    // Print complete report
    public void PrintReport(IProduct product) {

        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("********************************");

        PrintTotalSales(product);
        PrintAverageSales(product);
        PrintMostPopularProduct(product);
    }
}

