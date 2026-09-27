# Replace and Sum

**Source:** [Codeforces 2193C — Replace and Sum](https://codeforces.com/contest/2193/problem/C)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

For each i you may set a_i to max(a_i, b_i) or to a_{i+1}, repeatedly. Answer range-sum queries of the maximum achievable array.

## Approach

- The best value at i is the maximum of a_i, b_i and the best value at i+1, so compute it right to left (a suffix maximum).
- Answer each query with prefix sums of those best values.

## Complexity

- **Time:** O(n + q)
- **Space:** O(n)

## Concepts

Suffix Maximum, Prefix Sums

## Files

- [`src/RaS.java`](src/RaS.java)
