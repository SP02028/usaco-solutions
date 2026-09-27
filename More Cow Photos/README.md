# More Cow Photos

**Source:** [USACO 2025 US Open Contest, Bronze — Problem 2: More Cow Photos](https://usaco.org/index.php?page=viewproblem2&cpid=1516)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Choose a subset of cow heights and arrange them symmetrically (a palindrome) that strictly increases to a single peak. Maximize the number of cows.

## Approach

- The tallest cow is always the peak. Every smaller height that appears at least twice can appear once on each side.
- Answer = 1 + 2 · (number of heights below the maximum with frequency ≥ 2).

## Complexity

- **Time:** O(N + max height) per test case
- **Space:** O(max height)

## Concepts

Counting, Greedy

## Files

- [`src/MCP.java`](src/MCP.java)
