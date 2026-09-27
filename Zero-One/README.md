# Zero-One (Easy Version)

**Source:** [Codeforces 1733D1 — Zero-One (Easy Version)](https://codeforces.com/contest/1733/problem/D1)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Make binary strings a and b equal with operations flipping two positions: adjacent flips cost x and non-adjacent flips cost y (easy version: y ≤ x). Minimize the cost.

## Approach

- An odd number of differing positions is impossible. With exactly two adjacent differences the cost is min(x, 2y); otherwise every difference can be paired non-adjacently, costing (count/2)·y.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Case Analysis

## Files

- [`src/ZO.java`](src/ZO.java)
