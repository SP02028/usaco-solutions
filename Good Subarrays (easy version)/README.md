# Good Subarrays (Easy Version)

**Source:** [Codeforces 1736C1 — Good Subarrays (Easy Version)](https://codeforces.com/contest/1736/problem/C1)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A subarray b is good if b_i ≥ i for every position i in it. Count the good subarrays.

## Approach

- For each right end r, the subarray starting at l is good iff l ≥ r − a_r + 1 for every element, so keep a running maximum of those lower bounds and add (r − min + 1).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Two Pointers, Counting

## Files

- [`src/GS.java`](src/GS.java)
