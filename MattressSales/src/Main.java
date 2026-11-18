//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;

    // Constructor
    public Main() {

        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createForm();
    }

    // Create menu
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

// File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);

// Tools menu
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    // Create the GUI form
    private void createForm() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

// Customer name
        JLabel lblCustomer = new JLabel("Customer Name:");

        txtCustomerName = new JTextField();

// Product selection
        JLabel lblProduct = new JLabel("Select Product:");

        cmbProduct = new JComboBox<>(new String[] {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        });

// Product price
        JLabel lblPrice = new JLabel("Enter Price:");

        txtPrice = new JTextField();

// Process button
        JButton btnProcess = new JButton("PROCESS");

        btnProcess.addActionListener(e -> processSale());

// Add components to panel
        panel.add(lblCustomer);
        panel.add(txtCustomerName);

        panel.add(lblProduct);
        panel.add(cmbProduct);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);
    }

    // Process the sale
    private void processSale() {

        String customerName = txtCustomerName.getText().trim();
        String productName = (String) cmbProduct.getSelectedItem();

// Check empty fields
        if (customerName.isEmpty() || txtPrice.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter all information.");

            return;
        }
        double price;

// Check that price is a valid number
        try {
            price = Double.parseDouble(
                    txtPrice.getText().trim());

            if (price < 0) {
                JOptionPane.showMessageDialog(this, "Price cannot be negative.");

                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");

            return;
        }

// Create calculations object
        ProductCalculations calculations = new ProductCalculations(price);

        double vat = calculations.GetVat();
        double commission = calculations.GetCommission();
        double total = calculations.GetTotal();

// Display results
        String message = "Customer Name: " + customerName + "\nProduct: " + productName +
                "\nVAT: R " + vat + "\nCOMMISSION: R " + commission + "\nTOTAL: R " + total;

        JOptionPane.showMessageDialog(this, message);

// Save information to file
        saveToFile(customerName, productName, vat, commission, total);
    }

    // Save information in data.txt
    private void saveToFile(String customer,
                            String product,
                            double vat,
                            double commission,
                            double total) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true));

            writer.println("DATA LOG");
            writer.println("****************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("****************************");
            writer.println();
            writer.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "Error saving information.");
        }
    }

    // Clear all text fields
    private void clearForm() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
