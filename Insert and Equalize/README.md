# Insert and Equalize

**Source:** [Codeforces 1902C — Insert and Equalize](https://codeforces.com/contest/1902/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Insert one new distinct integer into the array, then choose a positive x and repeatedly add x to elements so that all become equal. Minimize the number of additions.

## Approach

- The best x is g = gcd of all differences, and everything is raised to the maximum.
- Insert the largest value of the form max − k·g that is not already present (scanning down from the max), then the answer is Σ (max − a_i)/g plus the inserted element's steps.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

GCD, Greedy, Sorting

## Files

- [`src/IaE.java`](src/IaE.java)
