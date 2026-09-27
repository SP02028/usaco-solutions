# Haunted House

**Source:** [Codeforces 1884B — Haunted House](https://codeforces.com/contest/1884/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

For a binary number, for every i from 1 to n find the minimum number of adjacent swaps to make it divisible by 2^i (its last i digits zero), or −1.

## Approach

- Scan positions from the right. When position n − i holds a 1, move the nearest 0 to its left into place; the cost is the distance.
- Answers accumulate as i grows. Once no zero is left, every remaining answer is −1.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Two Pointers

## Files

- [`src/HH.java`](src/HH.java)
