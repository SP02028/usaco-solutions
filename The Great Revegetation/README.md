# The Great Revegetation

**Source:** [USACO 2019 February Contest, Silver — Problem 3: The Great Revegetation](https://usaco.org/index.php?page=viewproblem2&cpid=920)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

N pastures and M pairs of cows that require the same ('S') or different ('D') grass types, with two types available. Count the valid assignments as a binary number, or 0 if none exist.

## Approach

- Two-colour each connected component with DFS, propagating the same colour along 'S' edges and the opposite colour along 'D' edges; a conflict means the answer is 0.
- Otherwise each component has 2 colourings, so the answer is 2^(components), printed in binary as 1 followed by that many zeros.

## Complexity

- **Time:** O(N + M)
- **Space:** O(N + M)

## Concepts

Bipartite Checking, DFS, Connected Components

## Files

- [`src/TGR.java`](src/TGR.java)
