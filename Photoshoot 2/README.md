# Photoshoot 2

**Source:** [USACO 2022 February Contest, Bronze — Problem 2: Photoshoot 2](https://usaco.org/index.php?page=viewproblem2&cpid=1204)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 14 official USACO test cases.

## Problem

Cows stand in order a and must be rearranged into order b, where one move takes a cow and moves her to the left. Find the minimum number of moves.

## Approach

- Walk through the target order b with a pointer into a that skips cows already moved. If the next unmoved cow of a matches b_i, it can stay; otherwise b_i must be moved, so count it and mark it.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Greedy, Two Pointers

## Files

- [`src/PS2.java`](src/PS2.java)
