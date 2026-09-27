# Milking Order

**Source:** [USACO 2018 US Open Contest, Bronze — Problem 2: Milking Order](https://usaco.org/index.php?page=viewproblem2&cpid=832)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows must be milked in an order that respects a given hierarchy subsequence and some fixed positions. Find the earliest position for cow 1.

## Approach

- Try each free position for cow 1 in increasing order and check feasibility greedily: place hierarchy cows in order at the earliest free slots, while respecting cows whose positions are already fixed.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Greedy, Complete Search

## Files

- [`src/MO.java`](src/MO.java)
