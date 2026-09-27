# Sum of Three Values

**Source:** [CSES Problem Set — Sum of Three Values](https://cses.fi/problemset/task/1641)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Find three distinct positions whose values sum to x, or report IMPOSSIBLE.

## Approach

- Sort (value, index) pairs. For each fixed element, run the two-pointer two-sum on the remaining target and accept a pair that does not reuse the fixed index.

## Complexity

- **Time:** O(n²)
- **Space:** O(n)

## Concepts

Two Pointers, Sorting

## Files

- [`src/S3V.java`](src/S3V.java)
