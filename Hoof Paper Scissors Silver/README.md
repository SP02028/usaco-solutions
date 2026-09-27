# Hoof, Paper, Scissors

**Source:** [USACO 2017 January Contest, Silver — Problem 2: Hoof, Paper, Scissors](https://usaco.org/index.php?page=viewproblem2&cpid=691)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie plays N rounds of hoof-paper-scissors against Farmer John's known moves and may switch her gesture at most once. Maximize the number of wins.

## Approach

- Prefix counts of FJ's P, H and S moves. For every switch point, the best is (max count in the prefix) + (max count in the suffix).

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Prefix Sums

## Files

- [`src/HPSS.java`](src/HPSS.java)
