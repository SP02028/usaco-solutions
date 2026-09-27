# 2-Letter Strings

**Source:** [Codeforces 1669E — 2-Letter Strings](https://codeforces.com/contest/1669/problem/E)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Given n strings of length 2 over letters a–k, count pairs of indices i < j whose strings differ in exactly one position.

## Approach

- Keep a 11×11 count table of every string seen so far.
- For each new string, try changing each of its two positions to every other letter and add the count of previously seen strings equal to that variant.
- Then record the current string in the table. Each valid pair is counted exactly once (when its later element is processed).

## Complexity

- **Time:** O(n · 2 · 11) per test case
- **Space:** O(11²)

## Concepts

Counting, Hashing by small alphabet

## Files

- [`src/TLS.java`](src/TLS.java)
