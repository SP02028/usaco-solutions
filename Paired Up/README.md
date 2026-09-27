# Paired Up

**Source:** [USACO 2017 US Open Contest, Silver — Problem 1: Paired Up](https://usaco.org/index.php?page=viewproblem2&cpid=738)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

M distinct milk output values each have a count of cows (N total, even). Pair up the cows so the maximum pair sum (milking time) is minimized.

## Approach

- Sort by output and greedily pair the smallest remaining with the largest remaining using two pointers over the value groups, decrementing counts. Track the maximum pair sum.

## Complexity

- **Time:** O(M log M)
- **Space:** O(M)

## Concepts

Greedy, Two Pointers, Sorting

## Files

- [`src/PU.java`](src/PU.java)
