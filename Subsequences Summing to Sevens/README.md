# Subsequences Summing to Sevens

**Source:** [USACO 2016 January Contest, Silver — Problem 2: Subsequences Summing to Sevens](https://usaco.org/index.php?page=viewproblem2&cpid=595)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Find the longest contiguous group of cows whose ID sum is divisible by 7.

## Approach

- Compute prefix sums mod 7 and record, for each residue, the first and last index where it occurs. The longest valid group spans the first and last occurrence of the same residue.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Prefix Sums, Modular Arithmetic

## Files

- [`src/SSS.java`](src/SSS.java)
