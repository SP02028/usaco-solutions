# Comfortable Cows

**Source:** [USACO 2021 February Contest, Bronze — Problem 2: Comfortable Cows](https://usaco.org/index.php?page=viewproblem2&cpid=1108)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Cows are added to a grid one at a time. A cow is comfortable if exactly three of its four neighbours are occupied. After each addition, output the number of comfortable cows.

## Approach

- Adding a cow only changes the status of the cow itself and its four neighbours.
- Before placing it, subtract any neighbour that was comfortable; after placing it, re-add neighbours and the new cow if they are now comfortable.

## Complexity

- **Time:** O(N)
- **Space:** O(1000²)

## Concepts

Simulation, Grid

## Files

- [`src/CC.java`](src/CC.java)
