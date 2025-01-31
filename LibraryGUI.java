import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryGUI {
    // Create the library collection to store books, DVDs, and magazines
    static List<Item> items = new ArrayList<>();
    static List<String> borrowedItems = new ArrayList<>();
    static List<String> returnedItems = new ArrayList<>();

    static JLabel addedItemsLabel = new JLabel("<html><b>Added Items:</b><br></html>");
    static JLabel borrowedItemsLabel = new JLabel("<html><b>Borrowed Items:</b><br></html>");
    static JLabel returnedItemsLabel = new JLabel("<html><b>Returned Items:</b><br></html>");

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null); // Center the frame

        // Set the look and feel of the UI for a modern touch
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the tabs for navigation
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // Add sections for Add Items, Borrow/Return Items, Search Items, and View Items
        tabbedPane.addTab("Add Items", createAddItemPanel());
        tabbedPane.addTab("Borrow/Return Items", createBorrowReturnPanel());
        tabbedPane.addTab("Search Items", createSearchPanel());
        tabbedPane.addTab("View Items", createViewItemsPanel());

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Panel for adding, updating books, DVDs, and magazines
    public static JPanel createAddItemPanel() {
        JPanel addItemPanel = new JPanel();
        addItemPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        addItemPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Items"));
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding between components

        // Input fields
        JTextField itemNameField = new JTextField(15);
        JComboBox<String> itemTypeComboBox = new JComboBox<>(new String[]{"Book", "DVD", "Magazine"});

        // Update Item related fields
        JComboBox<Item> itemListComboBox = new JComboBox<>();
        JTextField updatedItemNameField = new JTextField(15);
        JComboBox<String> updatedItemTypeComboBox = new JComboBox<>(new String[]{"Book", "DVD", "Magazine"});

        // Buttons
        JButton addButton = new JButton("Add Item");
        JButton updateButton = new JButton("Update Item");
        JLabel resultLabel = new JLabel("Item added successfully!");
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        resultLabel.setForeground(Color.GREEN);

        // Add Item Action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameField.getText();
                String itemType = (String) itemTypeComboBox.getSelectedItem();

                if (itemName.isEmpty()) {
                    resultLabel.setText("Please enter an item name.");
                    resultLabel.setForeground(Color.RED);
                } else {
                    // Add item to the list
                    Item newItem = new Item(itemName, itemType);
                    items.add(newItem);
                    resultLabel.setText(itemName + " has been added to the library.");
                    resultLabel.setForeground(Color.GREEN);
                    updateItemListComboBox(itemListComboBox); // Update the list for editing
                    updateViewItems(); // Update the view after adding an item
                }
            }
        });

        // Update Item Action
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Item selectedItem = (Item) itemListComboBox.getSelectedItem();
                if (selectedItem != null) {
                    String newItemName = updatedItemNameField.getText();
                    String newItemType = (String) updatedItemTypeComboBox.getSelectedItem();
                    if (!newItemName.isEmpty()) {
                        selectedItem.setName(newItemName);
                        selectedItem.setType(newItemType);
                        resultLabel.setText("Item updated successfully.");
                        resultLabel.setForeground(Color.GREEN);
                        updateViewItems();  // Update the view after updating an item
                    } else {
                        resultLabel.setText("Please enter a valid item name.");
                        resultLabel.setForeground(Color.RED);
                    }
                }
            }
        });

        // Update the JComboBox with items that can be updated
        updateItemListComboBox(itemListComboBox);

        // Layout for Add Item Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        addItemPanel.add(new JLabel("Item Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        addItemPanel.add(itemNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addItemPanel.add(new JLabel("Item Type:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        addItemPanel.add(itemTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addItemPanel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        addItemPanel.add(resultLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        addItemPanel.add(new JLabel("Select Item to Update:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        addItemPanel.add(itemListComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        addItemPanel.add(new JLabel("Updated Item Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        addItemPanel.add(updatedItemNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        addItemPanel.add(new JLabel("Updated Item Type:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        addItemPanel.add(updatedItemTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        addItemPanel.add(updateButton, gbc);

        return addItemPanel;
    }

    // Panel for borrowing/returning items
    public static JPanel createBorrowReturnPanel() {
        JPanel borrowReturnPanel = new JPanel();
        borrowReturnPanel.setLayout(new GridLayout(4, 2, 10, 10));
        borrowReturnPanel.setBorder(BorderFactory.createTitledBorder("Borrow / Return Items"));

        JTextField borrowReturnField = new JTextField();
        JComboBox<String> borrowReturnComboBox = new JComboBox<>(new String[]{"Borrow", "Return"});
        JButton borrowReturnButton = new JButton("Submit");
        JLabel borrowReturnResultLabel = new JLabel("Operation successful!");

        borrowReturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = borrowReturnField.getText();
                String operation = (String) borrowReturnComboBox.getSelectedItem();

                if (itemName.isEmpty()) {
                    borrowReturnResultLabel.setText("Please enter an item name.");
                    return;
                }

                if (operation.equals("Borrow")) {
                    // Check if the item exists in the library
                    if (items.stream().anyMatch(item -> item.getName().equals(itemName))) {
                        borrowedItems.add(itemName);
                        items.removeIf(item -> item.getName().equals(itemName));
                        borrowReturnResultLabel.setText(itemName + " has been borrowed.");
                    } else {
                        borrowReturnResultLabel.setText("Item not available in library.");
                    }
                } else {
                    // Return borrowed item
                    if (borrowedItems.contains(itemName)) {
                        borrowedItems.remove(itemName);
                        returnedItems.add(itemName);
                        borrowReturnResultLabel.setText(itemName + " has been returned.");
                    } else {
                        borrowReturnResultLabel.setText("Item was not borrowed.");
                    }
                }
                updateViewItems();  // Update the view after borrowing/returning an item
            }
        });

        borrowReturnPanel.add(new JLabel("Item Name:"));
        borrowReturnPanel.add(borrowReturnField);
        borrowReturnPanel.add(new JLabel("Borrow/Return:"));
        borrowReturnPanel.add(borrowReturnComboBox);
        borrowReturnPanel.add(borrowReturnButton);
        borrowReturnPanel.add(borrowReturnResultLabel);

        return borrowReturnPanel;
    }

    // Panel for searching items in the library
    public static JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1, 10, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Items"));

        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JLabel searchResultLabel = new JLabel("Search results will be shown here.");

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                if (query.isEmpty()) {
                    searchResultLabel.setText("Please enter a search term.");
                    return;
                }

                StringBuilder result = new StringBuilder("<html>Search results:<br>");
                boolean found = false;

                // Search in items list
                for (Item item : items) {
                    if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                        result.append(item.getName()).append(" - ").append(item.getType()).append("<br>");
                        found = true;
                    }
                }

                if (!found) {
                    result.append("No items found.");
                }

                result.append("</html>");
                searchResultLabel.setText(result.toString());
            }
        });

        searchPanel.add(new JLabel("Search Item:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(searchResultLabel);

        return searchPanel;
    }

    // Panel for viewing items: Added, Borrowed, and Returned
    public static JPanel createViewItemsPanel() {
        JPanel viewItemsPanel = new JPanel();
        viewItemsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        viewItemsPanel.setBorder(BorderFactory.createTitledBorder("View Items"));

        // Add the labels to the panel
        viewItemsPanel.add(addedItemsLabel);
        viewItemsPanel.add(borrowedItemsLabel);
        viewItemsPanel.add(returnedItemsLabel);

        return viewItemsPanel;
    }

    // Utility method to update the view items
    public static void updateViewItems() {
        StringBuilder addedItemsText = new StringBuilder("<html><b>Added Items:</b><br>");
        for (Item item : items) {
            addedItemsText.append(item.getName()).append(" - ").append(item.getType()).append("<br>");
        }
        addedItemsText.append("</html>");
        addedItemsLabel.setText(addedItemsText.toString());

        StringBuilder borrowedItemsText = new StringBuilder("<html><b>Borrowed Items:</b><br>");
        for (String item : borrowedItems) {
            borrowedItemsText.append(item).append("<br>");
        }
        borrowedItemsText.append("</html>");
        borrowedItemsLabel.setText(borrowedItemsText.toString());

        StringBuilder returnedItemsText = new StringBuilder("<html><b>Returned Items:</b><br>");
        for (String item : returnedItems) {
            returnedItemsText.append(item).append("<br>");
        }
        returnedItemsText.append("</html>");
        returnedItemsLabel.setText(returnedItemsText.toString());
    }

    // Update the item list combo box for editing
    public static void updateItemListComboBox(JComboBox<Item> itemListComboBox) {
        itemListComboBox.removeAllItems();
        for (Item item : items) {
            itemListComboBox.addItem(item);
        }
    }

    // Item class for encapsulating the item details
    static class Item {
        private String name;
        private String type;

        public Item(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
