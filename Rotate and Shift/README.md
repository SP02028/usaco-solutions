# Rotate and Shift

**Source:** [USACO 2023 US Open Contest, Bronze — Problem 3: Rotate and Shift](https://usaco.org/index.php?page=viewproblem2&cpid=1325)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

N cows in positions 0..N−1 and K active positions. Each minute the cows at active positions rotate (each moves to the next active position), then the active positions all shift forward by 1. Output the arrangement after T minutes.

## Approach

- In the frame that moves with the shifting positions, each cow just cycles within its gap between consecutive active positions.
- For each cow, compute its offset after T steps modulo its gap length, then shift the result by T to get its final position.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Modular Arithmetic, Simulation

## Files

- [`src/RaS.java`](src/RaS.java)
