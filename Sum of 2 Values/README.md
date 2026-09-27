# Sum of Two Values

**Source:** [CSES Problem Set — Sum of Two Values](https://cses.fi/problemset/task/1640)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Find two positions whose values sum to x, or report IMPOSSIBLE.

## Approach

- Sort (value, index) pairs and move two pointers inward: if the sum is too small move the left pointer, if too large move the right one.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Two Pointers, Sorting

## Files

- [`src/S2V.java`](src/S2V.java)
