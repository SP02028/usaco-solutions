# Cellular Network

**Source:** [Codeforces 702C — Cellular Network](https://codeforces.com/contest/702/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 20 official Codeforces tests that are published in full.

## Problem

Given sorted city and tower positions, find the minimum radius r such that every city is within r of some tower.

## Approach

- For each city, binary search the first tower at or to the right and take the distance to it and to the previous tower. The answer is the maximum, over all cities, of that closest distance.

## Complexity

- **Time:** O(n log m)
- **Space:** O(n + m)

## Concepts

Binary Search, Sorting

## Files

- [`src/CN.java`](src/CN.java)
