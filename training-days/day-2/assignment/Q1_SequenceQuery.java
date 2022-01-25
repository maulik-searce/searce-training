import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Q1_SequenceQuery
 * 
 * @author Maulik Pipaliya
 */
public class Q1_SequenceQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nQueries = sc.nextInt();
        String[] operations = new String[nQueries];

        sc.nextLine(); // Consume newline left-over

        for (int i = 0; i < nQueries; i++)
            operations[i] = sc.nextLine();

        getMax(operations);

        sc.close();
    }

    public static void getMax(String[] operations) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> maxValues = new Stack<>();

        int n = operations.length;
        // System.out.println(Arrays.deepToString(operations));

        int maxTillNow = Integer.MIN_VALUE;
        maxValues.push(maxTillNow);

        int i = 0, op;
        while (n-- > 0) {
            String[] splitValue = operations[i].split(" ");
            op = Integer.parseInt(splitValue[0]);

            switch (op) {
                case 1:

                    int value = Integer.parseInt(splitValue[1]);
                    st.push(value);

                    maxTillNow = maxValues.peek();

                    maxValues.push((value > maxTillNow) ? value : maxTillNow);

                    // System.out.println("stack:" + st);
                    // System.out.println("maxvl:" + maxValues);
                    break;
                case 2:

                    maxValues.pop();
                    st.pop();
                    // System.out.println("stack:" + st);
                    // System.out.println("maxvl:" + maxValues);
                    break;
                case 3:
                    System.out.println(maxValues.peek());
                    // System.out.println(maxValues);
                    break;

                default:
                    break;
            }

            i++;

        }
    }

}