# Almost All Multiples

**Source:** [Codeforces 1758C — Almost All Multiples](https://codeforces.com/contest/1758/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 13 official Codeforces tests that are published in full.

## Problem

Build the lexicographically smallest permutation p of 1..n with p_1 = x, p_n = 1, and p_i divisible by i for every 1 < i < n, or report −1.

## Approach

- It is impossible unless x divides n.
- Start with p_1 = x, p_x = n, p_n = 1 and everything else in place.
- Walk i upward and, whenever n's current position can be swapped with position i while keeping both positions valid, swap. This moves n to its latest possible position, making the permutation lexicographically smallest.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive, Permutations, Divisibility

## Files

- [`src/AAM.java`](src/AAM.java)
