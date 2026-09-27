# Blocks

**Source:** [USACO 2022 February Contest, Bronze — Problem 3: Blocks](https://usaco.org/index.php?page=viewproblem2&cpid=1205)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

Four cube blocks each have 6 letters. For each query word of at most 4 letters, decide whether it can be spelled using each block at most once.

## Approach

- Try every permutation of the 4 blocks (via next-permutation) and check whether the j-th letter of the word appears on the j-th block in that order.

## Complexity

- **Time:** O(4! · 4 · 6) per word
- **Space:** O(1)

## Concepts

Complete Search, Permutations

## Files

- [`src/B.java`](src/B.java)
