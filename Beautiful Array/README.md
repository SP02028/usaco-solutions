# Beautiful Array

**Source:** [Codeforces 1986E — Beautiful Array](https://codeforces.com/contest/1986/problem/E)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

You may add k to any element any number of times, then reorder the array. Make it a palindrome with the minimum number of operations, or print −1.

## Approach

- Only elements with the same remainder mod k can be paired; if more than one remainder class has odd size, it is impossible.
- Sort each class. An even class pairs adjacent elements, with cost (difference)/k per pair.
- An odd class must leave one element in the middle; use prefix and suffix costs of adjacent pairing to try every choice of the unpaired element in O(size).

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Modular Arithmetic, Prefix/Suffix Sums

## Files

- [`src/BA.java`](src/BA.java)
