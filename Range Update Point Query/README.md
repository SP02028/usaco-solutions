# Range Update Point Query

**Source:** [Codeforces 1791F — Range Update Point Query](https://codeforces.com/contest/1791/problem/F)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 10 official Codeforces tests that are published in full.

## Problem

Support two operations: replace each a_i in [l, r] with its digit sum, and query a single value.

## Approach

- A value becomes single-digit after at most three digit-sum updates, after which updates do nothing.
- Keep a TreeSet of indices whose values are still ≥ 10; an update only visits those indices inside [l, r] (ceiling lookups) and removes them once they drop below 10.

## Complexity

- **Time:** O((n + q) log n) amortized
- **Space:** O(n)

## Concepts

TreeSet, Amortized Analysis

## Files

- [`src/RUPQ.java`](src/RUPQ.java)
