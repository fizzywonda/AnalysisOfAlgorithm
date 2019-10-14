import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxHeap {
    private int max_size;
    private String [] arr;
    private ArrayList<String> h;

    public MaxHeap(int userMaxsize) {
        this.max_size = userMaxsize;
        this.h = new ArrayList<String>(max_size + 1);
//        this.arr new ArrayList<String>();
    }

    public void print() {
        for (String i : this.h) {
            System.out.print(i);
        }
        System.out.println();
    }

    public void insert(String item) {
//        if (this.h.get(1) == null) {
//            this.h.add(1, item);
//        } else {

            this.h.add(item);
            int itemIndex = this.h.size() - 1;    //
            int parentIndex = (itemIndex - 1) / 2;
            while (this.h.get(parentIndex).compareTo(this.h.get(itemIndex)) < 0) {
                String temp = this.h.get(parentIndex);
                this.h.set(parentIndex, this.h.get(itemIndex));
                this.h.set(itemIndex, temp);
                itemIndex = parentIndex;
                parentIndex = (itemIndex - 1) / 2;
            }
            this.print();
    }

    public String extractMax(){
        String firstElement = this.h.get(0);     //get the first
        String lastElement = this.h.get(this.h.size() - 1);
        this.h.set(0, lastElement);  //replace the first element with last element in the array
        this.h.set(this.h.size() - 1, firstElement);
        String deletedNode = this.h.get(this.h.size() - 1);
        this.h.remove(this.h.size() - 1);
//        this.max_size -= 1;
        int parentIndex = 0;


        while (((2 *parentIndex + 2) < this.h.size()) && (this.h.get(parentIndex).compareTo(this.h.get(2*parentIndex + 1)) < 0 ||
                this.h.get(parentIndex).compareTo(this.h.get(2*parentIndex + 2)) < 0)){

            if (this.h.get(2*parentIndex +1).compareTo(this.h.get(2*parentIndex + 2)) > 0){
                String temp = this.h.get(parentIndex);
                this.h.set(parentIndex, this.h.get(2*parentIndex + 1));
                this.h.set(2*parentIndex + 1, temp);
                parentIndex = 2*parentIndex + 1;
            }
            else{

                String temp = this.h.get(parentIndex);
                this.h.set(parentIndex, this.h.get(2*parentIndex + 2));
                this.h.set(2*parentIndex + 2, temp);
                parentIndex = 2*parentIndex + 2;
            }

        }
        return deletedNode;
    }

    public void heapSort(){
        int size = this.h.size();
        this.arr = new String[size];
        while (this.h.size() > 0){
            String node = extractMax();
            this.arr[(size--) - 1]= node;
        }
        printArray();
    }

    public void printArray(){
        for (String node: arr) {
            System.out.print(node);
        }
    }

    public static void main (String[]args){


//        System.out.print("Enter number of string: ");
            File file = new File("./input.txt");
            try {
                Scanner in = new Scanner(file);
                int size = Integer.parseInt(in.nextLine());
                MaxHeap heap = new MaxHeap(size);

                while (in.hasNext()) {
                    String item = in.nextLine();
                    System.out.println(item);
                    heap.insert(item);
                }

                heap.heapSort();

//                for (int j= 0;j < 26; j++){
//                    heap.extractMax();
//                    heap.print();
//                }


            } catch (FileNotFoundException e) {
                System.out.print(e);
            }
//        MaxHeap heap = new MaxHeap(8);
//        heap.insert("a");
//        heap.insert("b");
//        heap.insert("c");
//        heap.insert("d");
//        heap.insert("e");
//        heap.insert("f");
//
//
//        heap.extractMax();
//        heap.print();
//        heap.extractMax();
//        heap.print();
//        heap.extractMax();
//        heap.print();
//        heap.extractMax();
//        heap.print();
//        heap.extractMax();
//        heap.print();

        }

}
