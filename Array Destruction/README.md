# Array Destruction

**Source:** [Codeforces 1474C — Array Destruction](https://codeforces.com/contest/1474/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Given 2n numbers, choose an initial x; repeatedly remove two numbers summing to x and then set x to the larger of the two. Decide whether the whole array can be removed and output the operations.

## Approach

- The largest element must be removed in the first operation, so try every partner for it (this fixes the initial x).
- Simulate with a multiset (TreeMap): at each step the current maximum must be removed together with x − max; if that partner is missing, the choice fails.

## Complexity

- **Time:** O(n² log n)
- **Space:** O(n)

## Concepts

Greedy, Simulation, TreeMap / Multiset

## Files

- [`src/AD.java`](src/AD.java)
