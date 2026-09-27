# Paint the Array

**Source:** [Codeforces 1618C — Paint the Array](https://codeforces.com/contest/1618/problem/C)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Choose d so that painting elements divisible by d red and the rest blue makes adjacent elements differ in colour, or print 0.

## Approach

- d must divide all elements at one parity of index and none at the other. Try the divisors of the gcd of the even-indexed elements against the odd-indexed ones, and vice versa.

## Complexity

- **Time:** O(n · d(g) + √g)
- **Space:** O(n)

## Concepts

GCD, Divisors

## Files

- [`src/PTA.java`](src/PTA.java)
