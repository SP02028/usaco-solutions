# Balancing Bacteria

**Source:** [USACO 2024 January Contest, Bronze — Problem 3: Balancing Bacteria](https://usaco.org/index.php?page=viewproblem2&cpid=1373)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

N patches in a row have bacteria offsets a_i. One spray, always made from patch N with a chosen power L, adds (or removes) L units at patch N, L−1 at patch N−1, and so on down to 1, leaving earlier patches untouched. Find the minimum number of sprays to bring every patch to 0.

## Approach

- Sweep left to right keeping track of the accumulated linear effect of previous applications (a first-order and a second-order running change).
- At each patch, the remaining level must be cancelled by applications starting exactly there; add |value| applications of the appropriate sign and update the running change.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Difference Arrays, Greedy, Prefix Sums

## Files

- [`src/BB.java`](src/BB.java)
