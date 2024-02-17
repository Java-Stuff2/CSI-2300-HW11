import java.util.*;

class Book implements Comparable<Book> {
    // declare two fields: title and author
    String title;
    String author;

    // define a constructor that takes two parameters: title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // override the compareTo method to define the natural order of the books
    // compare the books by their titles in lexicographical order
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // override the toString method to return a string representation of the book
    // object
    @Override
    public String toString() {
        return "Book: [" + title + ", by " + author + "]";
    }
}

// define a Sorter class that has two generic methods: bubbleSort and mergeSort
class Sorter {
    // define a generic method that performs bubble sort on an array of type T that
    // extends Comparable
    public <T extends Comparable<T>> void bubbleSort(T[] array) {
        // get the length of the array
        int n = array.length;
        // declare a boolean variable to keep track of the swaps
        boolean swapped;
        // use a loop to iterate over the array n - 1 times
        for (int i = 0; i < n - 1; i++) {
            // initialize the swapped variable to false
            swapped = false;
            // use another loop to iterate over the array from 0 to n - i - 2
            for (int j = 0; j < n - i - 1; j++) {
                // compare the element at index j with the element at index j + 1
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap the elements if they are out of order
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // set the swapped variable to true
                    swapped = true;
                }
            }
            // if the swapped variable is false, break the loop
            if (!swapped) {
                break;
            }
        }
    }

    // define a generic method that performs merge sort on an array of type T that
    // extends Comparable
    public <T extends Comparable<T>> void mergeSort(T[] array) {
        // get the length of the array
        int n = array.length;
        // if the array has less than two elements, return
        if (n < 2) {
            return;
        }
        // find the middle index of the array
        int mid = n / 2;
        // create two subarrays of type T, one for the left half and one for the right
        // half
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, n);
        // recursively sort the left and right subarrays
        mergeSort(left);
        mergeSort(right);
        // merge the sorted subarrays into the original array
        merge(array, left, right);
    }

    // define a private generic method that merges two sorted subarrays into one
    // sorted array
    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        // declare three indices to keep track of the left, right, and merged subarrays
        int i = 0, j = 0, k = 0;
        // while there are elements in both subarrays
        while (i < left.length && j < right.length) {
            // compare the elements of the left and right subarrays and place the smaller or
            // equal one into the merged subarray
            if (left[i].compareTo(right[j]) <= 0) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        // copy the remaining elements of the left subarray, if any, into the merged
        // subarray
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        // copy the remaining elements of the right subarray, if any, into the merged
        // subarray
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}

// define the main class
public class GenericsAssign {
    // define the main method
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nChoose a sorting method:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            int choice = scanner.nextInt();

            // create an array of book objects and initialize it with some sample data
            Book[] books = {
                    new Book("The Catcher in the Rye", "J.D. Salinger"),
                    new Book("To Kill a Mockingbird", "Harper Lee"),
                    new Book("Nineteen Eighty-Four", "George Orwell"),
                    new Book("Things Fall Apart", "Chinua Achebe"),
                    new Book("The Metamorphosis", "Franz Kafka"),
                    new Book("The Da Vinci Code", "Dan Brown"),
                    new Book("The Color Purple", "Alice Walker"),
                    new Book("Anne of Green Gables", "L.M. Montgomery")
            };
            // create an object of the Sorter class
            Sorter sorter = new Sorter();
            // print the array before sorting
            System.out.println("Array before sorting:");
            long startTime = System.currentTimeMillis();
            System.out.println(Arrays.toString(books) + "\n");
            switch (choice) {
                case 1:
                    if (choice == 1) {
                        sorter.bubbleSort(books);
                        // print the array after bubble sorting
                        System.out.println("Array after Bubble sorting by title:");
                        long endTime = System.currentTimeMillis();
                        System.out.println(Arrays.toString(books));
                        System.out.println("Bubble Sort took: " + (endTime - startTime) + "milliseconds to sort. \n");
                    }
                    // call the bubbleSort method on the array of books

                case 2:
                    if (choice == 2) {
                        sorter.mergeSort(books);
                        long endTimes = System.currentTimeMillis();
                        // print the array after merge sorting
                        System.out.println("Array after Merge sorting by title:");
                        System.out.println(Arrays.toString(books));
                        System.out.println("Merge Sort took " + (endTimes - startTime) + " milliseconds to sort. \n");
                    }
                    // call the mergeSort method on the array of books

            }
        }
    }

}
