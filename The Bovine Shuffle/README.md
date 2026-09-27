# The Bovine Shuffle

**Source:** [USACO 2017 December Contest, Silver — Problem 3: The Bovine Shuffle](https://usaco.org/index.php?page=viewproblem2&cpid=764)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A shuffle moves the cow at position i to position a_i, and it is repeated forever. Count the positions that are always occupied.

## Approach

- Positions that stay occupied are exactly those on cycles of the functional graph i → a_i. For each unprocessed start, walk until a node repeats and mark the cycle it enters.

## Complexity

- **Time:** O(N²) worst case
- **Space:** O(N)

## Concepts

Functional Graphs, Cycle Detection

## Files

- [`src/TBS.java`](src/TBS.java)
