# It's Mooin' Time II

**Source:** [USACO 2025 January Contest, Bronze — Problem 2: It's Mooin' Time II](https://usaco.org/index.php?page=viewproblem2&cpid=1468)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Count the distinct 'moo' patterns (a, b, b) with a ≠ b that appear as subsequences of the array.

## Approach

- Scan left to right. The pair (b, b) is formed by the last two occurrences of b, and a can be any distinct value seen before the second-to-last occurrence of b.
- When an element's remaining future count drops to 1 (it is the second-to-last occurrence), add the number of distinct values seen so far, excluding b itself.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Counting, Prefix Distinct Values

## Files

- [`src/mooingII.java`](src/mooingII.java)
