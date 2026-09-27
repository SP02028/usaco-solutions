# Vanya and Lanterns

**Source:** [Codeforces 492B — Vanya and Lanterns](https://codeforces.com/contest/492/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 18 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Lanterns at given positions on a street of length l. Find the minimum light radius d so the whole street is lit.

## Approach

- Sort the positions. d must cover the first gap (from 0) and the last gap (to l) fully, and half of every interior gap. Take the maximum and print it as a decimal.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Greedy

## Files

- [`src/VAL.java`](src/VAL.java)
