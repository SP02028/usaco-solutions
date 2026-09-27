# Find and Replace

**Source:** [USACO 2023 January Contest, Silver — Problem 1: Find and Replace](https://usaco.org/index.php?page=viewproblem2&cpid=1278)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

Transform string s into t using operations that replace every occurrence of one letter (upper- or lower-case) with another letter. Find the minimum number of operations, or −1.

## Approach

- Each source letter must map to exactly one target letter; otherwise the answer is −1. If all 52 letters appear as targets and s ≠ t, there is no spare letter, so the answer is also −1.
- Count the letters that must change (edges of the functional graph). Every cycle of length > 1 needs one extra operation through a spare letter, unless some node in the cycle has in-degree > 1.

## Complexity

- **Time:** O(|s| + 52)
- **Space:** O(52)

## Concepts

Functional Graphs, Cycle Detection

## Files

- [`src/FaR.java`](src/FaR.java)
