# Factory Machines

**Source:** [CSES Problem Set — Factory Machines](https://cses.fi/problemset/task/1620)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

n machines each take k_i seconds per product and work in parallel. Find the minimum time to make t products.

## Approach

- Binary search on time T: machines produce Σ floor(T / k_i) products, capped early to avoid overflow.

## Complexity

- **Time:** O(n log(t · max k))
- **Space:** O(n)

## Concepts

Binary Search on Answer

## Files

- [`src/FM.java`](src/FM.java)
