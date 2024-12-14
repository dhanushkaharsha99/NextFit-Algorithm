import java.util.ArrayList;

// Class to handle Next Fit Memory Allocation logic
public class NextFitMemoryAllocator {
    // Inner class representing a memory block
    static class Block {
        int size; // Size of the block
        boolean isAllocated; // Allocation status of the block

        public Block(int size) {
            this.size = size; // Initialize block size
            this.isAllocated = false; // Block is free by default
        }
    }

    private ArrayList<Block> memoryPool; // List representing the memory blocks
    private int nextFitIndex; // Keeps track of the last allocated block for Next Fit

    // Constructor to initialize the memory pool and the next fit index
    public NextFitMemoryAllocator() {
        memoryPool = new ArrayList<>();
        nextFitIndex = 0; // Start from the beginning of the memory pool
    }

    // Method to initialize the memory pool with predefined block sizes
    public void initializeMemory(int[] blockSizes) {
        for (int size : blockSizes) {
            memoryPool.add(new Block(size));
        }
    }

    // Method to add a new memory block manually
    public void addMemoryBlock(int blockSize) {
        memoryPool.add(new Block(blockSize));
    }

    // Method to allocate memory to a process using the Next Fit strategy
    public boolean allocateMemory(int processSize) {
        int start = nextFitIndex; // Start from the last allocated block
        for (int i = 0; i < memoryPool.size(); i++) {
            int currentIndex = (start + i) % memoryPool.size(); // Wrap around if needed
            Block block = memoryPool.get(currentIndex);

            // Check if the block is free and large enough
            if (!block.isAllocated && block.size >= processSize) {
                block.isAllocated = true; // Allocate the block
                int remainingSize = block.size - processSize; // Calculate remaining size
                block.size = processSize; // Update block size to fit the process
                nextFitIndex = currentIndex; // Update the next fit index

                // If there is remaining space, create a new block
                if (remainingSize > 0) {
                    memoryPool.add(currentIndex + 1, new Block(remainingSize));
                }
                return true; // Allocation successful
            }
        }
        return false; // Allocation failed
    }

    // Method to deallocate a block at a specific index
    public void deallocateMemory(int blockIndex) {
        if (blockIndex < memoryPool.size()) {
            Block block = memoryPool.get(blockIndex);
            if (block.isAllocated) {
                block.isAllocated = false; // Mark the block as free
            }
        }
    }

    // Getter method to expose the memory pool for visualization
    public ArrayList<Block> getMemoryPool() {
        return memoryPool;
    }
}
