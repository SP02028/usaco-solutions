# Wormhole Sort

**Source:** [USACO 2020 January Contest, Silver — Problem 3: Wormhole Sort](https://usaco.org/index.php?page=viewproblem2&cpid=992)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows must be sorted by swapping along wormholes, where each wormhole has a width. Maximize the minimum width among the wormholes used (or −1 if already sorted).

## Approach

- Binary search the width w. Using only wormholes of width ≥ w, find connected components (iterative DFS); sorting is possible iff every cow shares a component with its target position.

## Complexity

- **Time:** O((N + M) log W)
- **Space:** O(N + M)

## Concepts

Binary Search on Answer, Connected Components

## Files

- [`src/WS.java`](src/WS.java)

## Notes

Uses USACO file I/O (`wormsort.in` / `wormsort.out`).
