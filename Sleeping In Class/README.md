# Sleeping in Class

**Source:** [USACO 2022 February Contest, Bronze — Problem 1: Sleeping in Class](https://usaco.org/index.php?page=viewproblem2&cpid=1203)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Merge adjacent classes (summing their sleep counts) so that all remaining values are equal. Minimize the number of merges.

## Approach

- The final equal value must divide the total sum. Try every divisor from small to large and check greedily whether the array splits into segments with exactly that sum; the answer is N − (number of segments).

## Complexity

- **Time:** O(d(S) · N) per test case
- **Space:** O(N)

## Concepts

Divisors, Greedy

## Files

- [`src/Main.java`](src/Main.java)
