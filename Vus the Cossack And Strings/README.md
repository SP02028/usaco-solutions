# Vus the Cossack and Strings

**Source:** [Codeforces 1186C — Vus the Cossack and Strings](https://codeforces.com/contest/1186/problem/C)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full.

## Problem

Count the substrings c of a (with |c| = |b|) whose Hamming distance to b is even.

## Approach

- The parity of the Hamming distance equals the parity of (number of 1s in c) + (number of 1s in b). Compare window 1-counts from a prefix sum with b's 1-count.

## Complexity

- **Time:** O(|a|)
- **Space:** O(|a|)

## Concepts

Prefix Sums, Parity

## Files

- [`src/VtCAS.java`](src/VtCAS.java)
