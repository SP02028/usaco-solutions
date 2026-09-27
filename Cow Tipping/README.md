# Cow Tipping

**Source:** [USACO 2017 January Contest, Bronze — Problem 3: Cow Tipping](https://usaco.org/index.php?page=viewproblem2&cpid=689)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

An N×N grid of cows is either upright (0) or tipped (1). A machine flips every cow in the rectangle from (0,0) to any chosen (i,j). Find the minimum number of uses to make every cow upright.

## Approach

- Process cells from the bottom-right corner toward the top-left. The bottom-right-most cell can only be fixed by a flip anchored exactly there, so whenever a processed cell is 1, flip the rectangle ending at it.

## Complexity

- **Time:** O(N⁴)
- **Space:** O(N²)

## Concepts

Greedy, Simulation

## Files

- [`src/cowtipping.java`](src/cowtipping.java)

## Notes

Uses USACO file I/O (`cowtip.in` / `cowtip.out`).
