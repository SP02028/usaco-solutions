# Making Mexes

**Source:** [USACO 2025 February Contest, Bronze — Problem 2: Making Mexes](https://usaco.org/index.php?page=viewproblem2&cpid=1492)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

For every i from 0 to N, find the minimum number of element changes needed to make the array's MEX exactly i.

## Approach

- To get MEX i, every value in 0..i−1 must be present and value i must be absent.
- Changes needed = max(count of value i, number of missing values below i): each copy of i must change, and those changes can fill the gaps.
- Sweep i upward, maintaining the number of missing values.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Counting, MEX

## Files

- [`src/MM2.java`](src/MM2.java)
