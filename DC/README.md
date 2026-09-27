# Diamond Collector

**Source:** [USACO 2016 US Open Contest, Silver — Problem 2: Diamond Collector](https://usaco.org/index.php?page=viewproblem2&cpid=643)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie has N diamonds and two display cases; in each case all diamond sizes must differ by at most K. Maximize the number of diamonds displayed.

## Approach

- Sort sizes; with two pointers compute len[i], the size of the best case starting at diamond i.
- Build a suffix maximum of len[] and, for each i, combine len[i] with the best case starting after it.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Two Pointers, Sorting, Suffix Maximum

## Files

- [`DC.java`](DC.java)

## Notes

The folder name is short for Diamond Collector. Uses USACO file I/O (`diamond.in` / `diamond.out`).
