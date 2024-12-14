import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Class responsible for visualizing the memory allocation
public class MemoryVisualizationPanel extends JPanel {
    private ArrayList<NextFitMemoryAllocator.Block> memoryPool; // Reference to the memory pool

    // Method to set the memory pool data
    public void setMemoryPool(ArrayList<NextFitMemoryAllocator.Block> memoryPool) {
        this.memoryPool = memoryPool; // Assign the memory pool reference
        repaint(); // Trigger a repaint to update the visualization
    }

    // Override the paintComponent method to draw the memory visualization
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (memoryPool == null || memoryPool.isEmpty()) {
            return; // Exit if there is no memory pool to display
        }

        int y = 10; // Vertical position for drawing blocks

        // Loop through each block in the memory pool
        for (NextFitMemoryAllocator.Block block : memoryPool) {
            int height = block.size / 2; // Scale block height for visualization
            g.setColor(block.isAllocated ? Color.RED : Color.GREEN); // Use red for allocated, green for free
            g.fillRect(50, y, 200, height); // Draw the block
            g.setColor(Color.BLACK); // Set text color
            g.drawRect(50, y, 200, height); // Draw block border
            g.drawString("Size: " + block.size + (block.isAllocated ? " (Allocated)" : " (Free)"), 60, y + 20);
            y += height + 10; // Move to the next position
        }
    }
}
