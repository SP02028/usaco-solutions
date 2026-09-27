# Little Girl and Maximum Sum

**Source:** [Codeforces 276C — Little Girl and Maximum Sum](https://codeforces.com/contest/276/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 7 official Codeforces tests that are published in full.

## Problem

Reorder the array to maximize the total of q range-sum queries.

## Approach

- Count how many queries cover each position with a difference array.
- Sort the coverage counts and the array values and pair the largest with the largest.

## Complexity

- **Time:** O(n log n + q)
- **Space:** O(n)

## Concepts

Difference Arrays, Greedy, Sorting

## Files

- [`src/LGAMS.java`](src/LGAMS.java)
