# Haybale Stacking

**Source:** [USACO 2012 January Contest, Bronze — Problem 2: Haybale Stacking](https://usaco.org/index.php?page=viewproblem2&cpid=104)  
**Difficulty:** Silver (this contest predates Platinum, so its Bronze division was Silver-level)  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N stacks start empty and K instructions each add one item to every stack in a range [A, B]. Output the median stack height.

## Approach

- Apply the ranges with a difference array, prefix-sum, sort the heights and print the middle one.

## Complexity

- **Time:** O(N log N + K)
- **Space:** O(N)

## Concepts

Difference Arrays, Sorting

## Files

- [`src/RCAST.java`](src/RCAST.java)

## Notes

This is AlphaStar's reworded version of USACO 2012 January Bronze "Haybale Stacking"; the folder keeps the AlphaStar title.
