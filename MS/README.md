# Milk Sum

**Source:** [USACO 2023 US Open Contest, Silver — Problem 1: Milk Sum](https://usaco.org/index.php?page=viewproblem2&cpid=1326)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Farmer John milks N cows in an order he chooses, and the i-th cow milked contributes i·a to the total. Each query temporarily changes one cow's value; report the maximum total after the change (Milk Sum).

## Approach

- The optimum sorts values ascending, giving T = Σ i·sorted[i].
- For a query, find the new position of the changed value by binary search, then adjust T: remove the old term, shift the elements between the old and new positions by one index (a prefix-sum range), and add the new term.

## Complexity

- **Time:** O((N + Q) log N)
- **Space:** O(N)

## Concepts

Sorting, Prefix Sums, Binary Search

## Files

- [`MS.java`](MS.java)

## Notes

The folder name is short for Milk Sum.
