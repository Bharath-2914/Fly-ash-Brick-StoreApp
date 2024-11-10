import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BrickStoreApp extends JFrame implements ActionListener {

    // Fields for user interaction
    private JComboBox<String> brickTypeComboBox;
    private JTextField quantityField;
    private JList<String> villageList;
    private JTextArea cartArea;
    private JLabel totalCostLabel;
    private DefaultListModel<String> villageListModel;

    // Brick pricing and transportation configuration
    private final double SMALL_BRICK_PRICE = 18;
    private final double MEDIUM_BRICK_PRICE = 23;
    private final double LARGE_BRICK_PRICE = 26;
    private final double CUSTOM_BRICK_PRICE = 29;

    // Village names and prices
    private final String[] VILLAGES = {
            "Hanuman Junction - 500 Rs",
            "Seetharamapuram - 500 Rs",
            "M.N.Palem - 400 Rs",
            "Pallerlamudi - 500 Rs",
            "Koyyuru - 600 Rs",
            "Veleru - 600 Rs",
            "Tallamudi - 550 Rs",
            "Bommuluru - 650 Rs",
            "Kalparu - 600 Rs",
            "Marribandam - 500 Rs",
            "Meerjapuram - 600 Rs",
            "Billanapali - 550 Rs",
            "Kothapalli - 600 Rs",
            "Gollapali - 650 Rs",
            "Morsapudi - 650 Rs",
            "Tulluluru - 700 Rs",
            "Veeravali - 600 Rs",
            "Telaprolu - 650 Rs",
            "Punukoiiu - 650 Rs",
            "Pedapadu - 700 Rs",
            "Tippanagunta - 650 Rs",
            "Kanumolu - 550 Rs",
            "Arugolanu - 600 Rs",
            "Ogirala - 600 Rs",
            "Madicherla - 650 Rs"
    };

    // Initialize store name, owner, and address
    private final String STORE_NAME = "GODAVARI FLY ASH BRICKS";
    private final String OWNER_NAME = "Venkateswar Rao";
    private final String PHONE = "9848107952";
    private final String ADDRESS = "HANUMAN JUNCTION, AP, 521105";

    public BrickStoreApp() {
        // Set up main frame
        setTitle(STORE_NAME);
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Change the background color
        getContentPane().setBackground(Color.CYAN);

        // Title Section
        JPanel titlePanel = new JPanel(new GridLayout(3, 1));
        titlePanel.add(new JLabel(STORE_NAME, JLabel.CENTER));
        titlePanel.add(new JLabel("Owner: " + OWNER_NAME + " | Phone: " + PHONE, JLabel.CENTER));
        add(titlePanel, BorderLayout.NORTH);

        // Brick Selection Section
        JPanel selectionPanel = new JPanel(new GridLayout(6, 2));
        selectionPanel.add(new JLabel("Select Brick Type:"));
        String[] brickTypes = {"Small - 18 Rs", "Medium - 23 Rs", "Large - 26 Rs", "Custom - 29 Rs"};
        brickTypeComboBox = new JComboBox<>(brickTypes);
        brickTypeComboBox.addActionListener(e -> {
            if (brickTypeComboBox.getSelectedItem().equals("Custom - 29 Rs")) {
                showCustomSizeDialog();
            }
        });
        selectionPanel.add(brickTypeComboBox);

        selectionPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        selectionPanel.add(quantityField);

        selectionPanel.add(new JLabel("Select Village:"));
        villageListModel = new DefaultListModel<>();

        // Sort village list alphabetically by village name
        Arrays.sort(VILLAGES, (v1, v2) -> v1.split(" - ")[0].compareTo(v2.split(" - ")[0]));

        // Add sorted villages to list model
        for (String village : VILLAGES) {
            villageListModel.addElement(village);
        }

        villageList = new JList<>(villageListModel);
        villageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(villageList);
        selectionPanel.add(scrollPane);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(this);
        selectionPanel.add(addToCartButton);

        add(selectionPanel, BorderLayout.CENTER);

        // Cart and Summary Section
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(new JLabel("Cart:"), BorderLayout.NORTH);
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartPanel.add(new JScrollPane(cartArea), BorderLayout.CENTER);

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalCostLabel = new JLabel("Total Cost: 0 Rs");
        totalPanel.add(totalCostLabel, BorderLayout.WEST);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> calculateTotal());
        totalPanel.add(checkoutButton, BorderLayout.EAST);

        cartPanel.add(totalPanel, BorderLayout.SOUTH);
        add(cartPanel, BorderLayout.SOUTH);
    }

    private void showCustomSizeDialog() {
        // Create a dialog to ask for custom brick size
        JTextField lengthField = new JTextField(10);
        JTextField widthField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Enter Length (in cm):"));
        panel.add(lengthField);
        panel.add(new JLabel("Enter Width (in cm):"));
        panel.add(widthField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Custom Brick Size", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());

                // Update the brick type label and cart with the custom size
                cartArea.append("Size: " + length + "x" + width + " cm\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for size.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Clear previous error highlights
            quantityField.setBackground(Color.WHITE);
            brickTypeComboBox.setBackground(Color.WHITE);
            villageList.setBackground(Color.WHITE);

            // Retrieve brick type and validate fields
            int quantity = Integer.parseInt(quantityField.getText());
            String brickType = (String) brickTypeComboBox.getSelectedItem();
            String selectedVillage = villageList.getSelectedValue();

            if (quantity <= 0 || brickType == null || selectedVillage == null) {
                if (quantity <= 0) {
                    quantityField.setBackground(Color.RED);
                }
                if (brickType == null) {
                    brickTypeComboBox.setBackground(Color.RED);
                }
                if (selectedVillage == null) {
                    villageList.setBackground(Color.RED);
                }
                JOptionPane.showMessageDialog(this, "Please fill all the required fields!");
                return;
            }

            double brickCost = 0;
            String[] villageDetails = selectedVillage.split(" - ");
            double deliveryCost = Integer.parseInt(villageDetails[1].replaceAll("[^0-9]", ""));

            // Calculate the brick cost based on the type
            if (brickType.startsWith("Small")) {
                brickCost = SMALL_BRICK_PRICE * quantity;
                cartArea.append("Size: 6x6\n");
            } else if (brickType.startsWith("Medium")) {
                brickCost = MEDIUM_BRICK_PRICE * quantity;
                cartArea.append("Size: 8x8\n");
            } else if (brickType.startsWith("Large")) {
                brickCost = LARGE_BRICK_PRICE * quantity;
                cartArea.append("Size: 9x9\n");
            } else if (brickType.startsWith("Custom")) {
                brickCost = CUSTOM_BRICK_PRICE * quantity;
                cartArea.append("Size: Custom\n");
            }

            // Add to cart display
            cartArea.append(quantity + " x " + brickType + " bricks = " + brickCost + " Rs\n");
            cartArea.append("Delivery Cost for " + villageDetails[0] + ": " + deliveryCost + " Rs\n");

            // Update total cost label
            totalCostLabel.setText("Total Cost: " + (brickCost + deliveryCost) + " Rs");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity.");
        }
    }

    private void calculateTotal() {
        // Display final total and address
        JOptionPane.showMessageDialog(this, "Total Cost: " + totalCostLabel.getText() + "\n\nThank you for shopping with us!\n" + ADDRESS);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BrickStoreApp app = new BrickStoreApp();
            app.setVisible(true);
        });
    }
}
