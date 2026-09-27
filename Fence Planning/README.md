# Fence Planning

**Source:** [USACO 2019 US Open Contest, Silver — Problem 3: Fence Planning](https://usaco.org/index.php?page=viewproblem2&cpid=944)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows form moo networks through M connections. Build one axis-aligned rectangular fence enclosing at least one entire network. Minimize the fence's perimeter.

## Approach

- Find connected components with DFS, tracking each component's min/max x and y.
- The perimeter for a component is 2 · (width + height); take the minimum.

## Complexity

- **Time:** O(N + M)
- **Space:** O(N + M)

## Concepts

Connected Components, DFS

## Files

- [`src/FP.java`](src/FP.java)
