# Social Distancing

**Source:** [USACO 2020 US Open Contest, Silver — Problem 1: Social Distancing](https://usaco.org/index.php?page=viewproblem2&cpid=1038)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Place N cows in M grass intervals on a number line to maximize the minimum distance D between cows.

## Approach

- Sort the intervals and binary search on D.
- Check greedily: place cows as early as possible, each at least D after the previous one, inside the intervals, and count whether N fit.

## Complexity

- **Time:** O(M log M + (M + N) log R)
- **Space:** O(M)

## Concepts

Binary Search on Answer, Greedy

## Files

- [`src/SD.java`](src/SD.java)
