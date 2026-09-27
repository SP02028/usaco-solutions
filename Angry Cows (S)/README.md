# Angry Cows

**Source:** [USACO 2016 January Contest, Silver — Problem 1: Angry Cows](https://usaco.org/index.php?page=viewproblem2&cpid=594)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given N hay bale positions and K cows, each cow launched with power R destroys all bales within distance R of its landing point. Find the minimum R such that K cows destroy all bales.

## Approach

- Sort positions and binary search on R.
- Check a candidate R greedily: start a new cow at the leftmost unexploded bale, covering [x, x + 2R], and count the cows needed.

## Complexity

- **Time:** O(N log N + N log C)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Greedy, Sorting

## Files

- [`src/AC.java`](src/AC.java)
