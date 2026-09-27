# AND Sequences

**Source:** [Codeforces 1513B — AND Sequences](https://codeforces.com/contest/1513/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Count permutations of an array such that for every split point, the AND of the prefix equals the AND of the suffix (mod 1e9+7).

## Approach

- Every prefix and suffix AND must equal the AND of the whole array, so the first and last elements must both equal that total AND.
- If c elements equal the total AND, the answer is c · (c − 1) · (n − 2)!, and 0 when c < 2.

## Complexity

- **Time:** O(n) per test case (factorials precomputed)
- **Space:** O(max n)

## Concepts

Bitwise AND, Combinatorics

## Files

- [`src/AS.java`](src/AS.java)
