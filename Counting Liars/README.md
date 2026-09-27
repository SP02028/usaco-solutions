# Counting Liars

**Source:** [USACO 2022 US Open Contest, Bronze — Problem 2: Counting Liars](https://usaco.org/index.php?page=viewproblem2&cpid=1228)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

N cows each say Bessie's hiding spot is ≥ p_i ('G') or ≤ p_i ('L'). Find the minimum number of cows that must be lying.

## Approach

- An optimal spot can be taken at one of the given p values; try each.
- For a candidate x, liars are the 'L' cows with p < x plus the 'G' cows with p > x.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Complete Search

## Files

- [`src/CL.java`](src/CL.java)
