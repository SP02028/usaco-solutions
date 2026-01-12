/**
 * Problem: Concert Tickets (Creating Teams)
 * 
 * This solution matches customers with the highest priced ticket they can afford.
 * Uses a TreeMap-based MultiSet to efficiently find and remove tickets.
 * 
 * Approach:
 * - Store all ticket prices in a MultiSet (TreeMap with counts)
 * - For each customer, find the largest ticket price <= their budget using floor()
 * - Remove that ticket from the set once sold
 * - Output -1 if no valid ticket exists
 * 
 * Time Complexity: O((n + m) log n) where n is tickets and m is customers
 * Space Complexity: O(n) for storing tickets
 */
import java.util.*;
import java.io.*;

public class CT {
    static int[] a;
    static int n;
    static int m;

    /**
     * Main method that processes ticket sales for customers.
     */
    public static void main(String[] args) {
        Kattio io = new Kattio();
        MultiSet tickets = new MultiSet();
        n = io.nextInt();
        m = io.nextInt();

        // Read all ticket prices
        for (int i = 0; i < n; i++) {
            tickets.add(io.nextInt());
        }

        // Read customer budgets
        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = io.nextInt();
        }

        // Add sentinel value for easier handling of "no ticket found" case
        tickets.add(Integer.MAX_VALUE);

        // Process each customer
        for (int j = 0; j < m; j++) {
            // Find the highest priced ticket <= customer's budget
            int ans = tickets.floor(a[j]);
            if (ans == Integer.MAX_VALUE) {
                io.println(-1);
            } else {
                io.println(ans);
                tickets.remove(ans);
            }
        }
        io.close();
    }

    /**
     * MultiSet implementation using TreeMap.
     * Allows duplicate elements and provides efficient operations for
     * finding ceiling, floor, and other range queries.
     */
    public static class MultiSet {
        public TreeMap<Integer, Integer> map;
        public int size = 0;

        // Constructor for empty multiset
        public MultiSet() {
            map = new TreeMap<>();
            size = 0;
        }

        // Constructor to create a multiset from an array
        public MultiSet(int[] a) {
            map = new TreeMap<>();
            size = a.length;
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
        }

        // Add element to multiset
        void add(int a) {
            size++;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Remove one occurrence of element from multiset
        void remove(int a) {
            if (map.get(a) > 1) {
                map.put(a, map.get(a) - 1);
            } else {
                map.remove(a);
            }
            size -= 1;
        }

        // Count occurrences of element a
        int count(int a) {
            return map.getOrDefault(a, 0);
        }

        // Find smallest element greater than or equal to a
        int ceiling(int a) {
            if (map.ceilingKey(a) != null) {
                int find = map.ceilingKey(a);
                return find;
            } else
                return Integer.MIN_VALUE;
        }

        // Find largest element less than or equal to a
        int floor(int a) {
            if (map.floorKey(a) != null) {
                int find = map.floorKey(a);
                return find;
            } else
                return Integer.MAX_VALUE;
        }

        // Find largest element smaller than a
        int lower(int a) {
            if (map.lowerKey(a) != null) {
                int find = map.lowerKey(a);
                return find;
            } else
                return Integer.MAX_VALUE;
        }

        // Find smallest element greater than a
        int higher(int a) {
            if (map.higherKey(a) != null) {
                int find = map.higherKey(a);
                return find;
            } else
                return Integer.MIN_VALUE;
        }

        // Return smallest element in multiset
        int first() {
            return map.firstKey();
        }

        // Return largest element in multiset
        int last() {
            return map.lastKey();
        }

        // Check if element exists in multiset
        boolean contains(int a) {
            if (map.containsKey(a))
                return true;
            return false;
        }

        int size() {
            return size;
        }

        void clear() {
            map.clear();
        }
    }
    /**
     * Custom I/O class for competitive programming.
     * Extends PrintWriter for output and uses BufferedReader for fast input.
     */
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input/output
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input/output
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
