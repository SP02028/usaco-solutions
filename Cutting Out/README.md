# Cutting Out

**Source:** [Codeforces 1077D — Cutting Out](https://codeforces.com/contest/1077/problem/D)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 13 official Codeforces tests that are published in full.

## Problem

Choose an array t of length k so that it can be cut out of array s (remove one copy of t) as many times as possible, and output t.

## Approach

- Binary search on the number of copies c: c copies are possible iff Σ floor(freq[v] / c) ≥ k.
- Build t by taking each value floor(freq[v]/c) times until k elements are chosen.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Binary Search on Answer, Frequency Counting

## Files

- [`src/CO.java`](src/CO.java)
