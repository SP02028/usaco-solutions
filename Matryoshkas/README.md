# Matryoshkas

**Source:** [Codeforces 1790D — Matryoshkas](https://codeforces.com/contest/1790/problem/D)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Split the multiset of doll sizes into the minimum number of sets of consecutive integers.

## Approach

- Iterate distinct sizes in increasing order, including x + 1 for each x to detect gaps. When the count of size x exceeds the count of x − 1, the extra dolls must start new sets.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Counting, TreeSet

## Files

- [`src/M.java`](src/M.java)
