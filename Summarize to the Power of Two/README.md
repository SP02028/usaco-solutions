# Summarize to the Power of Two

**Source:** [Codeforces 1005C — Summarize to the Power of Two](https://codeforces.com/contest/1005/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 19 official Codeforces tests that are published in full.

## Problem

Remove the minimum number of elements so that every remaining element has a partner (another remaining element) with which it sums to a power of two.

## Approach

- An element can be kept iff some other element (a different copy if equal) sums with it to a power of two. Check all 31 powers with a frequency map and count the elements that have no partner.

## Complexity

- **Time:** O(31 · n)
- **Space:** O(n)

## Concepts

Hashing, Powers of Two

## Files

- [`src/STTPOT.java`](src/STTPOT.java)
