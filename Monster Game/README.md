# Monster Game

**Source:** [Codeforces 2193D — Monster Game](https://codeforces.com/contest/2193/problem/D)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

You have n swords with strengths and play levels in order, where level i needs b_i swords of strength ≥ the chosen difficulty x. Choose x to maximize x × (levels cleared).

## Approach

- Sort swords. If x equals the i-th smallest sword, n − i swords are usable, so the levels cleared is the largest k with prefix(b, k) ≤ n − i (found by binary search).
- Try each distinct sword strength and keep the best product.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Prefix Sums, Binary Search

## Files

- [`src/MG.java`](src/MG.java)
