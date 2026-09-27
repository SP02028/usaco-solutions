# The BOSS Can Count Pairs

**Source:** [Codeforces 1830B — The BOSS Can Count Pairs](https://codeforces.com/contest/1830/problem/B)  
**Difficulty:** Codeforces rating 2000  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Count pairs i < j with a_i · a_j = b_i + b_j, where 1 ≤ a_i, b_i ≤ n.

## Approach

- b_i + b_j ≤ 2n, so the smaller of a_i, a_j is at most √(2n).
- For each small value x, sweep the elements sorted by a: for an element (a, b), the partner with a-value x must have b' = a·x − b; count them with a frequency array over the b-values of elements whose a equals x.

## Complexity

- **Time:** O(n √n) per test case
- **Space:** O(n)

## Concepts

Math, Square-root Bound, Counting

## Files

- [`src/TBCCP.java`](src/TBCCP.java)
