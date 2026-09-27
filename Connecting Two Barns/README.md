# Connecting Two Barns

**Source:** [USACO 2021 December Contest, Silver — Problem 2: Connecting Two Barns](https://usaco.org/index.php?page=viewproblem2&cpid=1159)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N fields and M existing roads. You may build at most two new roads, each costing (i − j)², to connect field 1 with field N. Find the minimum cost.

## Approach

- Find connected components with DFS and sort the nodes of each component.
- The answer is either one road between the components of 1 and N, or two roads through an intermediate component.
- The cheapest road between two sorted components is found with a two-pointer merge.

## Complexity

- **Time:** O(N log N + C · N) where C is the number of components
- **Space:** O(N + M)

## Concepts

Connected Components, Two Pointers, DFS

## Files

- [`src/CTB.java`](src/CTB.java)
