# Walking Home

**Source:** [USACO 2021 December Contest, Bronze — Problem 3: Walking Home](https://usaco.org/index.php?page=viewproblem2&cpid=1157)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie walks from the top-left to the bottom-right of an N×N grid, moving only right or down, avoiding haybales, and changing direction at most K times (K ≤ 3). Count her routes.

## Approach

- With at most 3 turns the routes are few: the two L-shaped routes (1 turn), routes turning at a specific column or row (2 turns), and routes with an interior turning cell (3 turns).
- For each candidate shape, check the straight segments it uses for haybales.

## Complexity

- **Time:** O(N³) per test case
- **Space:** O(N²)

## Concepts

Complete Search, Case Analysis

## Files

- [`src/WH.java`](src/WH.java)
