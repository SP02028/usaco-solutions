# The Party and Sweets

**Source:** [Codeforces 1158A — The Party and Sweets](https://codeforces.com/contest/1158/problem/A)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 15 official Codeforces tests that are published in full.

## Problem

n boys and m girls; boy i gives each girl at least b_i sweets (the minimum over girls he gives to is exactly b_i), and girl j receives at most g_j from any boy (the maximum is exactly g_j). Minimize the total sweets, or −1.

## Approach

- It is impossible if the largest b exceeds the smallest g.
- Otherwise every boy gives b_i to every girl, and the boy with the largest b gives each girl her g_j. If no girl has g_j equal to that largest b, one girl's maximum must come from the second-largest boy instead, which adds (largest − second largest).

## Complexity

- **Time:** O(n + m)
- **Space:** O(1)

## Concepts

Greedy, Math

## Files

- [`src/TPAS.java`](src/TPAS.java)
