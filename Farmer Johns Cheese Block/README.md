# Farmer John's Cheese Block

**Source:** [USACO 2024 December Contest, Bronze — Problem 2: Farmer John's Cheese Block](https://usaco.org/index.php?page=viewproblem2&cpid=1444)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

Same problem as `Farmer John's Cheese Block`: after each removed cell, count the full lines in the three axis directions.

## Approach

- Maintain three 2D counters and increment the running answer whenever a line's count reaches N.

## Complexity

- **Time:** O(N² + Q)
- **Space:** O(N²)

## Concepts

Counting, Simulation

## Files

- [`src/Cheese.java`](src/Cheese.java)
