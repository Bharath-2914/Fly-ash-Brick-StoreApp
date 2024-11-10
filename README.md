# Fly-ash-Brick-StoreApp
Here’s a `README.md` file to help users understand and set up the `BrickStoreApp` Java application.

```markdown
# GODAVARI FLY ASH BRICKS - Brick Store Application

This is a Java Swing-based GUI application designed for **GODAVARI FLY ASH BRICKS** to facilitate brick ordering and calculate delivery costs based on the selected brick type, quantity, and delivery location.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Customization](#customization)
- [License](#license)

## Features

- **Brick Type Selection**: Choose from pre-defined brick types (Small, Medium, Large) or specify a custom brick size.
- **Quantity Input**: Enter the number of bricks required.
- **Village Selection**: Select a village to determine the delivery cost.
- **Cart Summary**: View added items in the cart with individual and total costs.
- **Total Cost Calculation**: Calculates the total cost including brick prices and delivery charges.
- **Checkout**: View the final cost with a message upon checkout.

## Getting Started

Follow these instructions to set up and run the application on your local machine.

### Prerequisites

- **Java Development Kit (JDK)** - Ensure you have JDK 8 or later installed.
- **IDE (Optional)** - You can use any Java IDE such as IntelliJ IDEA, Eclipse, or NetBeans.

### Installation

1. **Clone or download the repository**:
   ```bash
   git clone https://github.com/yourusername/BrickStoreApp.git
   ```
2. **Open the project in your IDE**:
   - If you're using IntelliJ IDEA, open the directory where you've downloaded the project.
   
3. **Compile and run the code**:
   - Compile the project, and run the `BrickStoreApp` class. The main entry point of the program is:
     ```java
     public static void main(String[] args)
     ```

### Usage

1. **Select Brick Type**: Choose from Small, Medium, Large, or Custom brick types.
2. **Enter Quantity**: Enter the desired quantity of bricks.
3. **Select Village**: Choose a delivery location from the village list to add transportation charges.
4. **Add to Cart**: Click `Add to Cart` to add the selected items and view details in the cart area.
5. **Checkout**: After adding items, click `Checkout` to see the total cost.

### Application Structure

- **UI Components**: Created with Java Swing, including `JFrame`, `JLabel`, `JComboBox`, `JTextField`, `JList`, and `JButton`.
- **Brick Pricing and Transport Configuration**:
  - Pricing for each brick type is defined by constants.
  - Village names and transportation costs are predefined in the application.

### Customization

- **Brick Types**: Update brick types and pricing by modifying the values in the `SMALL_BRICK_PRICE`, `MEDIUM_BRICK_PRICE`, `LARGE_BRICK_PRICE`, and `CUSTOM_BRICK_PRICE` fields.
- **Village List**: Add or modify village names and delivery charges in the `VILLAGES` array.

### Code Highlights

1. **Custom Brick Size Input**: Prompts the user to enter a custom brick size with a dialog box if "Custom" brick type is selected.
2. **Cart and Checkout**: The cart area displays all added items, including quantity, size, and delivery cost.
3. **Total Cost Calculation**: Calculates the final cost with brick and delivery charges.

### Example Output

Upon successful checkout, a dialog displays the total cost along with the owner's address and a thank-you message.

### License

This project is licensed under the MIT License.

---

**Contact Information**:
- Owner: **Venkateswar Rao**
- Phone: **9848107952**
- Address: **HANUMAN JUNCTION, AP, 521105**

---

Thank you for choosing **GODAVARI FLY ASH BRICKS**!

```

This README includes instructions on setting up, running, and customizing the application, as well as explaining its features and structure.
