# Micro-World

**Source:** [Codeforces 990B — Micro-World](https://codeforces.com/contest/990/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 18 official Codeforces tests that are published in full.

## Problem

A bacterium of size a_i can swallow a bacterium of size a_j if a_j < a_i ≤ a_j + K. Minimize the number of bacteria remaining.

## Approach

- Sort the distinct sizes. Every bacterium of size x can be swallowed if the next larger distinct size is ≤ x + K; count those and subtract from n.

## Complexity

- **Time:** O(n log n)
- **Space:** O(max a)

## Concepts

Greedy, Sorting

## Files

- [`src/MW.java`](src/MW.java)
