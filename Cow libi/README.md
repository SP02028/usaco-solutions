# Cow-libi

**Source:** [USACO 2023 February Contest, Silver — Problem 2: Cow-libi](https://usaco.org/index.php?page=viewproblem2&cpid=1303)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

G grazing events (x, y, t) happened, and C cows each give an alibi (x, y, t). A cow is innocent if she could not have travelled between her alibi and every grazing (speed 1). Count the innocent cows.

## Approach

- Sort grazings by time. If a cow can reach the grazings immediately before and after her alibi time, she can reach all of them (the grazings themselves are mutually reachable).
- Binary search the alibi time and check those two neighbouring grazings with squared distances.

## Complexity

- **Time:** O((G + C) log G)
- **Space:** O(G)

## Concepts

Binary Search, Geometry, Sorting

## Files

- [`src/CL.java`](src/CL.java)
