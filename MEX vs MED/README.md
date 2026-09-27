# MEX vs MED

**Source:** [Codeforces 1744F — MEX vs MED](https://codeforces.com/contest/1744/problem/F)  
**Difficulty:** Codeforces rating 2000  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Given a permutation of 0..n−1, count subsegments whose MEX is greater than their median.

## Approach

- A segment with MEX m must contain 0..m−1, and MEX > median holds iff its length is at most 2m.
- Grow the minimal window containing 0..mex−1 outward. Each time the window must extend to include the next value, count the segments whose length stays within 2·mex.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Two Pointers, Permutations, Counting

## Files

- [`src/MEXvsMED.java`](src/MEXvsMED.java)
