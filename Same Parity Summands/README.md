# Same Parity Summands

**Source:** [Codeforces 1352B — Same Parity Summands](https://codeforces.com/contest/1352/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Represent n as the sum of k positive integers that all have the same parity, or report NO.

## Approach

- Try k − 1 ones plus the remainder n − (k − 1), which must be positive and odd.
- Otherwise try k − 1 twos plus n − 2(k − 1), which must be positive and even.

## Complexity

- **Time:** O(k) per test case
- **Space:** O(1)

## Concepts

Constructive, Parity

## Files

- [`src/SPS.java`](src/SPS.java)
