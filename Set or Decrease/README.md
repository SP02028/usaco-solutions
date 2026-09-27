# Set or Decrease

**Source:** [Codeforces 1622C — Set or Decrease](https://codeforces.com/contest/1622/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 9 official Codeforces tests that are published in full.

## Problem

Make the array sum ≤ k with the minimum number of operations: decrease an element by 1, or set an element equal to another element.

## Approach

- Sort the array. Optimally you decrease the smallest element by some x and then set the i largest elements equal to it.
- For each i, compute the required x from the remaining sum using floor division, and minimize x + i.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Sorting, Prefix Sums

## Files

- [`src/SoD.java`](src/SoD.java)
