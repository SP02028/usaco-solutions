# Daisy Chains

**Source:** [USACO 2020 December Contest, Bronze — Problem 2: Daisy Chains](https://usaco.org/index.php?page=viewproblem2&cpid=1060)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N flowers in a row have petal counts. Count the contiguous groups of flowers that contain an 'average flower', meaning a flower whose petal count equals the group's average.

## Approach

- Enumerate every contiguous subarray, compute its sum and check whether the average is an integer that appears in the subarray.

## Complexity

- **Time:** O(N³)
- **Space:** O(N³) (all subarrays are materialized)

## Concepts

Complete Search, Brute Force

## Files

- [`src/Main.java`](src/Main.java)
