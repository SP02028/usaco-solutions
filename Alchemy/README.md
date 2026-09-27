# Alchemy

**Source:** [USACO 2022 US Open Contest, Bronze — Problem 3: Alchemy](https://usaco.org/index.php?page=viewproblem2&cpid=1229)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Bessie has counts of N metals, and K recipes that each create one unit of a metal by consuming one unit of each of several lower-numbered metals. Find the maximum number of units of metal N she can end up with.

## Approach

- Repeatedly try to make one more unit of metal N: walk metals from N down to 1, keeping a 'need' count.
- If a metal is in stock, use it; otherwise, if it has a recipe, push the missing amount onto its ingredients; if it has no recipe, stop.
- Count how many units succeed.

## Complexity

- **Time:** O(answer · (N + total recipe size))
- **Space:** O(N + K)

## Concepts

Simulation, Greedy

## Files

- [`src/A.java`](src/A.java)
