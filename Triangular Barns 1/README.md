# Triangular Barns 1

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

Given N intervals on a line, output the total length of their union multiplied by √2, printed to 3 decimals.

## Approach

- Sort intervals by start and merge overlapping ones, summing the merged lengths; then scale by √2.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Interval Merging, Sorting

## Files

- [`src/TB1.java`](src/TB1.java)
