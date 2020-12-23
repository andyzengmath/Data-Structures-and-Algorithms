public class LintCode_249 {
    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        if (A == null || A.length == 0) {
            return results;
        }
        BlockArray blockArray = new BlockArray(10000);
        for (int i = 0; i < A.length; i++) {
            results.add(blockArray.countSmaller(A[i]));
            blockArray.insert(A[i]);
        }
        return results;
    }
}

class BlockArray {
    public Block[] blocks;
    public int blockSize;
    
    public BlockArray(int capacity) {
        blockSize = (int) Math.sqrt(capacity);
        int blockCount = capacity / blockSize + 1;
        blocks = new Block[blockCount];
        for (int i = 0; i < blockCount; i++) {
            blocks[i] = new Block(blockSize);
        }
    }
    
    public int countSmaller(int value) {
        int index = value / blockSize;
        int count = 0;
        for (int i = 0; i < index; i++) {
            count += blocks[i].total;
        }
        
        for (int i = 0; i + index * blockSize < value; i++) {
            count += blocks[index].counter[i];
        }
        
        return count;
    }
    
    public void insert(int value) {
        int index = value / blockSize;
        blocks[index].total++;
        blocks[index].counter[value - index * blockSize]++;
    }
}

class Block {
    public int total;
    public int[] counter;
    public Block(int blockSize) {
        this.total = 0;
        this.counter = new int[blockSize];
    }
}