# Absolute Sorting

**Source:** [Codeforces 1772D — Absolute Sorting](https://codeforces.com/contest/1772/problem/D)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Given an array a, find an integer x such that replacing each a_i with |a_i − x| produces a non-decreasing array, or print −1.

## Approach

- For every adjacent pair with a[i−1] > a[i], x must be at least ceil((a[i−1] + a[i]) / 2); take the maximum over such pairs.
- Apply that x to the array and verify it is non-decreasing; print x if it is, otherwise −1.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Math, Greedy

## Files

- [`src/ASp2.java`](src/ASp2.java)
