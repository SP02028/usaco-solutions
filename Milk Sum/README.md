# Milk Sum

**Source:** [USACO 2023 US Open Contest, Silver — Problem 1: Milk Sum](https://usaco.org/index.php?page=viewproblem2&cpid=1326)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Farmer John milks cows in an order he chooses, and the i-th cow contributes i·a. For each query that temporarily changes one cow's value, output the maximum total.

## Approach

- Sort values ascending to get T = Σ i·sorted[i].
- For a query, binary search the new position and adjust T using prefix sums for the block of elements that shift by one index.

## Complexity

- **Time:** O((N + Q) log N)
- **Space:** O(N)

## Concepts

Sorting, Prefix Sums, Binary Search

## Files

- [`src/MS.java`](src/MS.java)
