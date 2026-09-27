# Non-Transitive Dice

**Source:** [USACO 2022 January Contest, Bronze — Problem 2: Non-Transitive Dice](https://usaco.org/index.php?page=viewproblem2&cpid=1180)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Given two 4-sided dice A and B with faces 1..10, decide whether a third die C exists such that A beats B, B beats C and C beats A (or the reverse cycle).

## Approach

- Brute force all 10⁴ possible dice C and check both cycle orientations, where 'X beats Y' means X wins more of the 16 face pairings than it loses.

## Complexity

- **Time:** O(10⁴ · 16) per test case
- **Space:** O(1)

## Concepts

Complete Search

## Files

- [`src/NTD.java`](src/NTD.java)
