//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {

    String[] cities = {"CAPE TOWN", "PORT ELIZABETH", "PRETORIA"};
    int[][] sales = {{1000, 2000, 3000}, {2000, 3000, 4000}, {1500, 1100, 1200}};
    String[] consoles = {"PS5", "XBOX", "SWITCH"};

    System.out.println("-----------------------------------------------------");
    System.out.println("GAMING CONSOLE REPORT");
    System.out.println("-----------------------------------------------------");

    System.out.printf("%-20s%10s%10s%10s%n",
            "", consoles[0], consoles[1], consoles[2]);

    for (int i = 0; i < cities.length; i++) {
        System.out.printf("%-20s%10d%10d%10d%n",
                cities[i],
                sales[i][0],
                sales[i][1],
                sales[i][2]);
    }

    System.out.println("------------------------------------------------------");
    System.out.println("CONSOLE SALES TOTALS FOR EACH CITY");
    System.out.println("------------------------------------------------------");

    int highestTotal = 0;
    String cityWithMostSales = "";

    for (int i = 0; i < cities.length; i++) {

        int total = 0;

        for (int j = 0; j < sales[i].length; j++) {
            total += sales[i][j];
        }

        System.out.printf("%-20s%d%n", cities[i], total);

        if (total > highestTotal) {
            highestTotal = total;
            cityWithMostSales = cities[i];
        }
    }

    System.out.println();
    System.out.println("CITY WITH THE MOST SALES: " + cityWithMostSales);
    System.out.println("----------------------------------------------------");
}
