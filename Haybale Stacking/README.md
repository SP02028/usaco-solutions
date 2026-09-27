# Haybale Stacking

**Source:** [USACO 2012 January Contest, Bronze — Problem 2: Haybale Stacking](https://usaco.org/index.php?page=viewproblem2&cpid=104)  
**Difficulty:** Silver (this contest predates Platinum, so its Bronze division was Silver-level)  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N initially empty stacks receive K instructions, each adding one haybale to every stack in a range [A, B]. Output the median stack height.

## Approach

- Apply all ranges with a difference array, take prefix sums, sort the heights and print the middle one.

## Complexity

- **Time:** O(N log N + K)
- **Space:** O(N)

## Concepts

Difference Arrays, Sorting

## Files

- [`src/HS.java`](src/HS.java)
