# Diluc and Kaeya

**Source:** [Codeforces 1536C — Diluc and Kaeya](https://codeforces.com/contest/1536/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

For each prefix of a D/K string, find the maximum number of pieces it can be split into so that every piece has the same D:K ratio.

## Approach

- A prefix can be split into pieces of equal ratio exactly when the whole prefix has that ratio, and the number of pieces equals how many earlier prefixes (including itself) share the reduced ratio.
- Reduce each prefix's (D, K) by their gcd and count occurrences in a HashMap.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

GCD, Hashing, Prefix Counts

## Files

- [`src/DAK.java`](src/DAK.java)
