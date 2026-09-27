# Subarray Sums I

**Source:** [CSES Problem Set — Subarray Sums I](https://cses.fi/problemset/task/1660)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Count subarrays of positive integers whose sum equals x.

## Approach

- All values are positive, so use a sliding window: extend the right end, shrink from the left while the sum exceeds x, and count windows whose sum equals x.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Two Pointers, Sliding Window

## Files

- [`src/SSI.java`](src/SSI.java)
