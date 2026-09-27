# Preparing for Merge Sort

**Source:** [Codeforces 847B — Preparing for Merge Sort](https://codeforces.com/contest/847/problem/B)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

Ivan's algorithm repeatedly scans the array left to right, pulling out an increasing sequence each pass. Output the sequences it produces.

## Approach

- Process numbers left to right; each number joins the first sequence whose last element is smaller than it.
- Those last elements are decreasing across sequences, so binary search finds the right sequence.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Binary Search, Greedy, Simulation

## Files

- [`src/PFMS.java`](src/PFMS.java)

## Notes

The folder name is missing the final "t" of "Sort".
