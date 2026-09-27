# Cycle Correspondence

**Source:** [USACO 2023 December Contest, Silver — Problem 2: Cycle Correspondence](https://usaco.org/index.php?page=viewproblem2&cpid=1351)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

Two cycles of K cows each are chosen from N cows. Maximize the number of cows that are either in neither cycle or in both cycles at the same position, after optionally rotating and/or reversing the second cycle.

## Approach

- Cows appearing in neither cycle always count: N − |union|.
- For cows in both cycles, compute the rotation offset (i − j) mod K that aligns them, for both the normal and the reversed second cycle; the most frequent offset gives the best alignment.

## Complexity

- **Time:** O(N + K log K)
- **Space:** O(N)

## Concepts

Hashing, Cyclic Shifts, Counting

## Files

- [`src/CC.java`](src/CC.java)
