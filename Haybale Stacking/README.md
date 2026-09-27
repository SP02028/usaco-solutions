# Haybale Stacking

**Source:** [SPOJ — HAYBALE (Haybale Stacking)](https://www.spoj.com/problems/HAYBALE/)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

N initially empty stacks receive K instructions, each adding one haybale to every stack in a range [A, B]. Output the median stack height.

## Approach

- Apply all ranges with a difference array, take prefix sums, sort the heights and print the middle one.

## Complexity

- **Time:** O(N log N + K)
- **Space:** O(N)

## Concepts

Difference Arrays, Sorting

## Files

- [`src/HS.java`](src/HS.java)
