# Coprime

**Source:** [Codeforces 1742D — Coprime](https://codeforces.com/contest/1742/problem/D)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 16 official Codeforces tests that are published in full.

## Problem

Find the maximum i + j such that a_i and a_j are coprime (i may equal j), or −1. Values are at most 1000.

## Approach

- Only the last index of each distinct value matters, and there are at most 1000 distinct values.
- Try every pair of distinct values, check gcd = 1, and maximize the sum of their last indices.

## Complexity

- **Time:** O(1000² · log 1000) per test case
- **Space:** O(n)

## Concepts

GCD, Brute Force over Values

## Files

- [`src/C.java`](src/C.java)
