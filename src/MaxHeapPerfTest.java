/**
 *
 * Spoorthi Gowda
 * Homework 7 - problem 2 - performance test
 *
 *
 */

import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.junit.Test;
import java.util.concurrent.TimeUnit;



public class MaxHeapPerfTest {

    public static void main(String[] args) {
        Integer[] arr;
        Integer n;
       
        for ( int size= 1; size <= 10 ; size++){
           
            n = 10000 * size;
            arr = new Integer[n];
            Random r = new Random();
            for (int i = 0; i < n  ; i++) {
                arr[i] = r.nextInt((n  - 1) + 1) + 1;
            }
            System.out.print("size == " + n +  "  ");
            MaxHeapLogN(arr);
            MaxHeapN(arr);
        }
   
    }

    public static void MaxHeapLogN(Integer data[]) {

        long startTime = System.nanoTime();
        MaxHeap mh = new MaxHeap(data.length);
        mh.MaxHeapLogN(data);
        long endTime = System.nanoTime();
       
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.print(" MaxHeapN " + durationInMillis + " ");

    }

    public static void MaxHeapN(Integer data[]) {

        long startTime = System.nanoTime();
        MaxHeap mh = new MaxHeap(data.length);
        mh.MaxHeapLogN(data);
        long endTime = System.nanoTime();
       
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.print(" MaxHeapNLOGN " + durationInMillis + "\n");

    }

}
