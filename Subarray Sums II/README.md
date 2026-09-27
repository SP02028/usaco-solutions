# Subarray Sums II

**Source:** [CSES Problem Set — Subarray Sums II](https://cses.fi/problemset/task/1661)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Count subarrays whose sum equals x, where values may be negative.

## Approach

- Keep a HashMap of prefix-sum frequencies; each prefix sum P adds the number of earlier prefixes equal to P − x.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Prefix Sums, Hashing

## Files

- [`src/SSII.java`](src/SSII.java)
