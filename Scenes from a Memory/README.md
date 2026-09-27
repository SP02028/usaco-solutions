# Scenes From a Memory

**Source:** [Codeforces 1562B — Scenes From a Memory](https://codeforces.com/contest/1562/problem/B)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Delete as many digits as possible from a number (whose digits contain no zeros) so that what remains is not prime (composite, or 1). Output the remaining digits.

## Approach

- If any single digit is 1, 4, 6, 8 or 9, keep just that digit.
- Otherwise every two-digit subsequence of the remaining digits (2, 3, 5, 7) is checked, and a composite one always exists within the first few digits.

## Complexity

- **Time:** O(n²) worst case (effectively constant)
- **Space:** O(n)

## Concepts

Number Theory, Brute Force

## Files

- [`src/SFAM.java`](src/SFAM.java)
