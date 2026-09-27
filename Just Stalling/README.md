# Just Stalling

**Source:** [USACO 2021 January Contest, Bronze — Problem 3: Just Stalling](https://usaco.org/index.php?page=viewproblem2&cpid=1085)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

N cows with heights and N stalls with height limits; count the assignments where every cow fits in its stall.

## Approach

- Sort both arrays. Assign cows from tallest to shortest: the i-th tallest cow can use any stall at least as tall as it except those already taken by the i−1 taller cows, and multiply those counts.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Combinatorics, Sorting, Two Pointers

## Files

- [`src/JS.java`](src/JS.java)
