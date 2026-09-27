# Farmer John's Cheese Block

**Source:** [USACO 2024 December Contest, Bronze — Problem 2: Farmer John's Cheese Block](https://usaco.org/index.php?page=viewproblem2&cpid=1444)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

An N×N×N cheese cube loses one unit cell per query. After each query, count the positions where a 1×1×N brick could be inserted along one of the three axes (a full line of removed cells).

## Approach

- Keep three 2D counters: removed cells per (x, y) line, per (x, z) line and per (y, z) line.
- When a cell is removed, increment its three lines; any line reaching N adds one new placement.

## Complexity

- **Time:** O(N² + Q)
- **Space:** O(N²)

## Concepts

Counting, Simulation

## Files

- [`src/FJCB.java`](src/FJCB.java)
