# Mahmoud and Ehab and the function

**Source:** [Codeforces 862E — Mahmoud and Ehab and the function](https://codeforces.com/contest/862/problem/E)  
**Difficulty:** Codeforces rating 2100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

f(j) = |Σ (−1)^i (a_i − b_{i+j})|. Output the minimum of f over all valid j, both initially and after each range-add update to a.

## Approach

- The alternating sum of a is one number A. Each window of b contributes a fixed alternating sum B_j, so precompute all B_j in a sorted set.
- A range update only changes A (when the range length is odd). The answer is the distance from A to the closest B_j, found with floor/ceiling.

## Complexity

- **Time:** O((n + m + q) log m)
- **Space:** O(m)

## Concepts

Alternating Sums, TreeSet, Binary Search

## Files

- [`src/MEF.java`](src/MEF.java)
