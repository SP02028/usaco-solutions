# A Leapfrog in the Array

**Source:** [Codeforces 949B — A Leapfrog in the Array](https://codeforces.com/contest/949/problem/B)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 6 official Codeforces tests that are published in full.

## Problem

Numbers 1..n start at positions 2i − 1 and repeatedly jump into the leftmost free position until they occupy 1..n. Answer queries for the number at position x.

## Approach

- If x is odd, the value is (x + 1)/2. Otherwise the number at x arrived from position n + x/2, so recurse on that position.

## Complexity

- **Time:** O(log n) per query
- **Space:** O(log n) recursion

## Concepts

Recursion, Math

## Files

- [`src/LiA.java`](src/LiA.java)
