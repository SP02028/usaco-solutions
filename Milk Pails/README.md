# Milk Pails

**Source:** [USACO 2016 February Contest, Silver — Problem 3: Milk Pails](https://usaco.org/index.php?page=viewproblem2&cpid=620)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Using pails of sizes X and Y and at most K operations (fill, empty, or pour one into the other), get the total milk in both pails as close as possible to M.

## Approach

- BFS over states (milk in pail 1, milk in pail 2) with a step counter, stopping expansion at K operations.
- Track the minimum |a + b − M| over every reachable state.

## Complexity

- **Time:** O(X · Y)
- **Space:** O(X · Y)

## Concepts

BFS over States

## Files

- [`src/MP.java`](src/MP.java)
