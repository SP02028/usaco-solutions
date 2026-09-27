# Multiplayer Moo

**Source:** [USACO 2018 US Open Contest, Silver — Problem 3: Multiplayer Moo](https://usaco.org/index.php?page=viewproblem2&cpid=836)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

An N×N grid of cow IDs. Find the largest connected region owned by one cow, and the largest connected region consisting of exactly two cows' cells (a team).

## Approach

- Single cow: flood fill every same-value component and track the maximum.
- Two cows: consider pairs of values sorted by total count, pruning pairs whose combined count cannot beat the current best, and flood fill cells restricted to those two values.

## Complexity

- **Time:** O(N² · pairs) with pruning
- **Space:** O(N² + max value)

## Concepts

Flood Fill, BFS, Pruning

## Files

- [`src/MuM3.java`](src/MuM3.java)

## Notes

Uses USACO file I/O (`multimoo.in` / `multimoo.out`).
