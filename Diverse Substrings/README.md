# Diverse Substrings

**Source:** [Codeforces 1748B — Diverse Substrings](https://codeforces.com/contest/1748/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A digit string is diverse if no digit appears more often than the number of distinct digits. Count the diverse substrings.

## Approach

- Any diverse substring has length at most 100 (10 distinct digits × at most 10 occurrences each).
- For each start, extend the end while the current digit's count stays ≤ 10, tracking distinct digits and the maximum frequency, and count valid ends.

## Complexity

- **Time:** O(n · 100)
- **Space:** O(1)

## Concepts

Brute Force with Bounded Length, Counting

## Files

- [`src/DS.java`](src/DS.java)
