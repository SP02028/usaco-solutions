# Cowntact Tracing 2

**Source:** [USACO 2023 December Contest, Bronze — Problem 2: Cowntact Tracing 2](https://usaco.org/index.php?page=viewproblem2&cpid=1348)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

A binary string shows which cows are sick after an unknown number of nights; each night infection spreads to both neighbours. Find the minimum number of initially sick cows.

## Approach

- Split into runs of 1s. A run of length L can have lasted at most (L − 1)/2 nights, or L − 1 nights if it touches an end of the line. The number of nights D is the minimum of these limits.
- Each run then needs ceil(L / (2D + 1)) initial cows.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Greedy, Strings

## Files

- [`src/CT2.java`](src/CT2.java)
