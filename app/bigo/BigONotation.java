package bigo;

public class BigONotation {
    // O(1)
    public static void printFirstItem(int[] items) {
        System.out.println(items[0]);
    }

    // O(n)
    public static void printAllItems(int[] items) {
        for (int item : items) {
            System.out.println(item);
        }
    }

    // O(n^2)

    public static void printAllPossibleOrderedPairs(int[] items) {
        for (int firstItem : items) {
            for (int secondItem : items) {
                System.out.println(firstItem + ", " + secondItem);
            }
        }
    }

    // N could be the actual input, or the size of the input
    public static void sayHiNTimes(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("hi");
        }
    }

    // Drop the constant,  O(2n), which we just call O(n).
    public static void printAllItemsTwice(int[] items) {
        for (int item : items) {
            System.out.println(item);
        }

        // once more, with feeling
        for (int item : items) {
            System.out.println(item);
        }
    }

    // O(1 + n/2 + 100)O(1+n/2+100), which we just call O(n).
    public static void printFirstItemThenFirstHalfThenSayHi100Times(int[] items) {
        System.out.println(items[0]);

        int middleIndex = items.length / 2;
        int index = 0;

        while (index < middleIndex) {
            System.out.println(items[index]);
            index++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("hi");
        }
    }

    // Drop the less significant terms O(n + n^2) is O(n^2) 
    public static void printAllNumbersThenAllPairSums(int[] numbers) {

        System.out.println("these are the numbers:");
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("and these are their sums:");
        for (int firstNumber : numbers) {
            for (int secondNumber : numbers) {
                System.out.println(firstNumber + secondNumber);
            }
        }
    }

    // We're usually talking about the "worst case". O(n) and best case O(1) runtime
    public static boolean contains(int[] haystack, int needle) {

        // does the haystack contain the needle?
        for (int n : haystack) {
            if (n == needle) {
                return true;
            }
        }
    
        return false;
    }

    // Space complexity
    
    // O(1) Space 
    public static void sayHiXTimes(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("hi");
        }
    }

    // O(n) Space
    public static String[] arrayOfHiNTimes(int n) {
        String[] hiArray = new String[n];
        for (int i = 0; i < n; i++) {
            hiArray[i] = "hi";
        }
        return hiArray;
    }

    // Space taken up by the inputs
    public static int getLargestItem(int[] items) {
        int largest = Integer.MIN_VALUE;
        for (int item : items) {
            if (item > largest) {
                largest = item;
            }
        }
        return largest;
    }


    public static void main(String args[]) {
        System.out.println(" Big O examples");
    }
}