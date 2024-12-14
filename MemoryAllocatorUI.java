import javax.swing.*;
import java.awt.*;

// Main class for the UI of the memory allocator
public class MemoryAllocatorUI {
    private NextFitMemoryAllocator allocator; // Instance of the memory allocator
    private MemoryVisualizationPanel visualizationPanel; // Panel for memory visualization
    private JFrame frame; // Main frame for the UI

    // Constructor to initialize the allocator and the UI
    public MemoryAllocatorUI() {
        allocator = new NextFitMemoryAllocator(); // Create the allocator instance
        visualizationPanel = new MemoryVisualizationPanel(); // Create the visualization panel
        initializeUI(); // Set up the UI components
    }

    // Method to set up the UI
    private void initializeUI() {
        frame = new JFrame("Next Fit Memory Allocator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Set up the memory visualization panel
        visualizationPanel.setPreferredSize(new Dimension(300, 600));
        visualizationPanel.setBackground(Color.WHITE);
        mainPanel.add(visualizationPanel, BorderLayout.CENTER);

        // Set up the control panel for user input
        JPanel controlPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        JTextField blockSizeField = new JTextField();
        JButton addBlockButton = new JButton("Add Block");

        // Listener for adding a memory block
        addBlockButton.addActionListener(e -> {
            try {
                int size = Integer.parseInt(blockSizeField.getText());
                allocator.addMemoryBlock(size);
                updateVisualization(); // Update the visualization
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid size!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JTextField processSizeField = new JTextField();
        JButton allocateButton = new JButton("Allocate");

        // Listener for allocating memory
        allocateButton.addActionListener(e -> {
            try {
                int size = Integer.parseInt(processSizeField.getText());
                boolean allocated = allocator.allocateMemory(size);
                if (!allocated) {
                    JOptionPane.showMessageDialog(frame, "Allocation failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                updateVisualization(); // Update the visualization
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid size!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JTextField deallocateIndexField = new JTextField();
        JButton deallocateButton = new JButton("Deallocate");

        // Listener for deallocating memory
        deallocateButton.addActionListener(e -> {
            try {
                int index = Integer.parseInt(deallocateIndexField.getText());
                allocator.deallocateMemory(index);
                updateVisualization(); // Update the visualization
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid index!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add controls to the panel
        controlPanel.add(new JLabel("Block Size:"));
        controlPanel.add(blockSizeField);
        controlPanel.add(addBlockButton);
        controlPanel.add(new JLabel("Process Size:"));
        controlPanel.add(processSizeField);
        controlPanel.add(allocateButton);
        controlPanel.add(new JLabel("Deallocate Index:"));
        controlPanel.add(deallocateIndexField);
        controlPanel.add(deallocateButton);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        // Initialize memory with some default blocks for demonstration
        allocator.initializeMemory(new int[]{100, 50, 200, 300});
        updateVisualization();
    }

    // Method to update the memory visualization panel
    private void updateVisualization() {
        visualizationPanel.setMemoryPool(allocator.getMemoryPool());
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MemoryAllocatorUI::new);
    }
}
