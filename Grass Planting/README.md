# Grass Planting

**Source:** [USACO 2019 January Contest, Silver — Problem 1: Grass Planting](https://usaco.org/index.php?page=viewproblem2&cpid=894)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A tree of N fields; adjacent fields and fields sharing a common neighbour need different grass types. Find the minimum number of types.

## Approach

- A vertex and all of its neighbours must be pairwise different, so the answer is the maximum degree + 1, which is always achievable in a tree.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Trees, Degree

## Files

- [`src/GP.java`](src/GP.java)
