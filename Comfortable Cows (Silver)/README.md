# Comfortable Cows

**Source:** [USACO 2021 February Contest, Silver — Problem 1: Comfortable Cows](https://usaco.org/index.php?page=viewproblem2&cpid=1110)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows are added one at a time. Whenever a cow has exactly three occupied neighbours, Farmer John must add a cow to the fourth cell, which can cascade. After each original cow, output the minimum number of extra cows added so far.

## Approach

- Offset coordinates by +1000 so added cows can extend past the original range.
- After placing a cow, BFS-propagate: each cell with exactly three neighbours forces a cow in its empty neighbour; enqueue that cell and its neighbours for rechecking.
- A cell that was previously 'forced' and is later placed by the input is no longer extra, so the count is decremented.

## Complexity

- **Time:** O(total cells touched)
- **Space:** O(3000²)

## Concepts

BFS, Simulation, Grid

## Files

- [`src/CC.java`](src/CC.java)
