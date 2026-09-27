# Sum of Substrings

**Source:** [Codeforces 1691C — Sum of Substrings](https://codeforces.com/contest/1691/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

A binary string's value is the sum of all its 2-digit windows read as decimal numbers. With at most k adjacent swaps, minimize the value.

## Approach

- Each 1 contributes 11, except a 1 at the last position (1) or at the first position (10).
- Spend swaps to move the last 1 to the end first (saving the most), then the first 1 to the front if enough swaps remain.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Strings

## Files

- [`src/SumOfSubstrings.java`](src/SumOfSubstrings.java)
