import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Maulik Pipaliya
 * @desc Find minimum avg waiting time.
 */

class CustomComparator implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> list1, List<Integer> list2) {

        int diff1 = Math.abs(list1.get(0) - list2.get(0));
        int diff2 = Math.abs(list1.get(1) - list2.get(1));

        if (diff1 < diff2) {
            return -1;
        } else {
            return 1;
        }

    }
}

public class PanShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<ArrayList<Integer>> customers = new ArrayList<>();

        while (n-- > 0) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(sc.nextInt());
            al.add(sc.nextInt());

            customers.add(al);

        }

        // System.out.println(customers);
        minimumAverage(customers);
        sc.close();
    }

    public static int minimumAverage(ArrayList<ArrayList<Integer>> customers) {

        TreeMap<Integer, Integer> timeMain = new TreeMap<>();
        TreeMap<Integer, Integer> minMain = new TreeMap<>();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new CustomComparator());

        int n = customers.size();
        int f = 0;
        while (n-- > 0) {
            pq.add(customers.get(f++));
        }

        System.out.println(pq);

        int kitchenCookTime = 0;
        int customerWaitingTime = 0;

        int i = 0;
        kitchenCookTime += customers.get(0).get(1);
        int k = 1;
        n = customers.size();
        while (n-- > 0) {
            int t = customers.get(i).get(0);
            int mins = customers.get(i).get(1);
            timeMain.put(t, mins);
            minMain.put(mins, t);

            i++;
        }
        n = customers.size();

        int x = 0;
        int temp = kitchenCookTime;
        for (Map.Entry<Integer, Integer> e : timeMain.entrySet()) {
            if (x != 0) {
                kitchenCookTime += e.getValue();
            }
            x++;
        }

        int y = 0;
        int customerside = 0;
        int xyz = 0;
        int sumTillNow = temp;
        int mainSum = 0;
        for (Map.Entry<Integer, Integer> e : minMain.entrySet()) {
            if (temp != e.getKey()) {
                sumTillNow += e.getKey();
                customerside += sumTillNow - e.getValue();
                mainSum += customerside;
            }
            // System.out.println("--cc");
            // System.out.println(customerside);
        }

        // System.out.println("---");
        System.out.println(customerside / 3);
        // System.out.println("---");

        /**
         * stn = 3
         * cs = 3
         * 
         * stn = 9
         * cs = 7
         * 
         * stn = 18
         * cs = 18-1
         * 17
         * 
         */

        // System.out.println(kitchenCookTime);

        // System.out.println(timeMain);
        // System.out.println(minMain);
        return 0;
    }
}
