# Do You Know Your ABCs?

**Source:** [USACO 2020 December Contest, Bronze — Problem 1: Do You Know Your ABCs?](https://usaco.org/index.php?page=viewproblem2&cpid=1059)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given the seven numbers A, B, C, A+B, B+C, C+A, A+B+C in some order, recover A, B, C.

## Approach

- After sorting, the two smallest numbers are A and B, and the largest is A+B+C, so C = max − A − B.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Concepts

Sorting, Math

## Files

- [`src/abc.java`](src/abc.java)
