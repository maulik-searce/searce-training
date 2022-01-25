import java.util.*;
import java.util.Scanner;

/**
 * Q1_Garden
 * 
 * @author Maulik Pipaliya
 * 
 */
public class Q1_Garden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int in = 0;

        for (int i = 0; i < n; i++) {
            in = sc.nextInt();
            arr[i] = in;
        }
        solve(arr, n);
        sc.close();
    }

    public static void solve(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i])
                // stack.push(arr[i + 1]);
        }
        System.out.println(stack);
    }
}