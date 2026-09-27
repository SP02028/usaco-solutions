# Perform the Combo

**Source:** [Codeforces 1311C — Perform the Combo](https://codeforces.com/contest/1311/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

You try to perform a combo string s, failing after p_i characters on each wrong try and then succeeding once. Count how many times each letter is pressed in total.

## Approach

- Character i is pressed once in the final successful try plus once in every wrong try with p_j > i. Sort the p values and sweep with a pointer to count them.

## Complexity

- **Time:** O(n + m log m)
- **Space:** O(26 + m)

## Concepts

Sorting, Prefix Counting

## Files

- [`src/PtC.java`](src/PtC.java)
