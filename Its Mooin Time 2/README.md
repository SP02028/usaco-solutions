# It's Mooin' Time II

**Source:** [USACO 2025 January Contest, Bronze — Problem 2: It's Mooin' Time II](https://usaco.org/index.php?page=viewproblem2&cpid=1468)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Same problem as `It's mooin Time II`: count the distinct (a, b, b) subsequence patterns with a ≠ b.

## Approach

- Track how many times each value still appears to the right. At the second-to-last occurrence of b, add the number of distinct values seen so far other than b.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Counting, Prefix Distinct Values

## Files

- [`src/IMT2.java`](src/IMT2.java)
