# Logical Moos

**Source:** [USACO 2024 US Open Contest, Bronze — Problem 1: Logical Moos](https://usaco.org/index.php?page=viewproblem2&cpid=1419)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 26 official USACO test cases.

## Problem

A boolean expression of true/false with 'and'/'or' (and binds tighter). Each query asks whether replacing the subexpression l..r with one literal can make the whole expression evaluate to a given value.

## Approach

- Split the expression into AND-blocks separated by ORs. Precompute prefix and suffix evaluations of the OR of complete blocks, the nearest OR on each side, and the nearest 'false'.
- If a complete block outside the query's block is already true, the result is forced true. Otherwise the answer depends on whether the remaining parts of the query's block contain a 'false'.

## Complexity

- **Time:** O(N + Q)
- **Space:** O(N)

## Concepts

Prefix Computation, Expression Evaluation

## Files

- [`src/LM.java`](src/LM.java)
