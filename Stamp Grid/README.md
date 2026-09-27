# Stamp Grid

**Source:** [USACO 2023 February Contest, Bronze — Problem 2: Stamp Grid](https://usaco.org/index.php?page=viewproblem2&cpid=1300)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 14 official USACO test cases.

## Problem

A K×K stamp can be rotated and stamped (inking only its '*' cells) anywhere fully inside an N×N canvas. Decide whether the target painting can be produced.

## Approach

- For every rotation and position where the stamp never covers a '.' of the target, stamp it (mark its '*' cells as covered).
- The painting is achievable iff every '*' of the target ends up covered.

## Complexity

- **Time:** O(4 · N² · K²) per test case
- **Space:** O(N²)

## Concepts

Simulation, Greedy, Rotation

## Files

- [`src/SG.java`](src/SG.java)
