package src;

/**
 * Spoorthi Gowda
 * 
 * Homeowork 7 part 2
 */
public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
        this.data = new Integer[this.data.length];
        size = 0;
        for (Integer item : data) {
            if (item == null) {
                break;
            }
            this.data[size] = item; 
            size++;
            
            int current = size-1; 
            while (this.data[current] > this.data[current/2]) { 
                int tmp; 
                tmp = this.data[current]; 
                this.data[current] = this.data[current/2]; 
                this.data[current/2] = tmp; 
                
                current = current/2; 
            } 
    }
        
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        
        this.data = new Integer[this.data.length];
        size = 0;
        for (Integer item : data) {
            if (item == null) {
                break;
            }
            this.data[size] = item; 
            size++;
        }
        int indexSize = size;
        int startIdx = (indexSize/ 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            int largest = i;   // Initialize largest as root 
            int l = 2 * i + 1; // left = 2*i + 1 
            int r = 2 * i + 2; // right = 2*i + 2 
            
            // If left child is larger than root 
            if (l < indexSize && this.data[l] > this.data[largest]) 
                largest = l; 
      
            // If right child is larger than largest so far 
            if (r < indexSize && this.data[r] > this.data[largest]) 
                largest = r; 
            int largestIndex = i;
            while(largest != largestIndex) {
                int swap = this.data[largestIndex]; 
                this.data[largestIndex] = this.data[largest]; 
                this.data[largest] = swap;
                
                largestIndex = largest;
                
                l = 2 * largestIndex + 1; // left = 2*i + 1 
                r = 2 * largestIndex + 2; // right = 2*i + 2 
                
                // If left child is larger than root 
                if (l < indexSize && this.data[l] > this.data[largest]) 
                    largest = l; 
          
                // If right child is larger than largest so far 
                if (r < indexSize && this.data[r] > this.data[largest]) 
                    largest = r; 
                
            }
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        
        if (size==data.length) {
            return false;
        }
        data[size] = item; 
        size++;
        int current = size-1; 
        while (this.data[current] > this.data[current/2]) { 
            int tmp; 
            tmp = this.data[current]; 
            this.data[current] = this.data[current/2]; 
            this.data[current/2] = tmp; 
            
            current = current/2; 
        }
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        
    	if (size>0) {
    	    return data[0];
	}
        return null;
    }

    // remove the root item
    public Integer pop() {
        
    	if (size==0) {
    	    return null;
	} 
    	int root = data[0];
    	size--;
    	for (int i = 0; i < size; i++) {
			data[i] = data[i+1];
	}
    	data[size] = null;
    	MaxHeapN(data);
        return root;
    } 
}
