# Forest Queries

**Source:** [CSES Problem Set — Forest Queries](https://cses.fi/problemset/task/1652)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

An n×n forest grid marks trees with '*'. Answer q queries for the number of trees inside a rectangle.

## Approach

- Build a 2D prefix sum and answer each query by inclusion–exclusion.

## Complexity

- **Time:** O(n² + q)
- **Space:** O(n²)

## Concepts

2D Prefix Sums

## Files

- [`src/FQ.java`](src/FQ.java)
