# Feeding the Cows

**Source:** [USACO 2022 December Contest, Bronze — Problem 2: Feeding the Cows](https://usaco.org/index.php?page=viewproblem2&cpid=1252)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases, checked with a custom validator because more than one answer is accepted.

## Problem

N cows (G or H) stand in a line. Plant grass patches, each of one type, so every cow is within distance K of a patch of her breed. Minimize the number of patches and output a valid placement.

## Approach

- Greedy for each breed separately: when a cow is not yet covered, plant her breed's patch as far right as possible (K cells ahead), which covers the most future cows.
- If a patch would fall off the end, place it in the rightmost free cell instead.

## Complexity

- **Time:** O(N) per test case
- **Space:** O(N)

## Concepts

Greedy

## Files

- [`src/FtC.java`](src/FtC.java)
