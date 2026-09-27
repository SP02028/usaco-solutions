# Sum of Nestings

**Source:** [Codeforces 847C — Sum of Nestings](https://codeforces.com/contest/847/problem/C)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Build a regular bracket sequence with n pairs whose total nesting (sum of each pair's depth) equals exactly k, or print Impossible.

## Approach

- The maximum is n(n−1)/2 (fully nested). Otherwise find the deepest full nest m with m(m−1)/2 ≤ k and place the remaining pairs as siblings at depths chosen so the leftover sum is matched exactly.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Bracket Sequences

## Files

- [`src/SoN.java`](src/SoN.java)
