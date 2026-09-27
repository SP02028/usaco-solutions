# Social Distancing I

**Source:** [USACO 2020 US Open Contest, Bronze — Problem 1: Social Distancing I](https://usaco.org/index.php?page=viewproblem2&cpid=1035)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

A row of N stalls, some occupied ('1'). Place two new cows in empty stalls to maximize the minimum distance D between any two occupied stalls.

## Approach

- D can never exceed the current smallest gap. Binary search on D and count how many new cows fit in the leading gap, the trailing gap and each interior gap while keeping distance D; D is feasible if at least 2 fit.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Greedy

## Files

- [`src/sd1.java`](src/sd1.java)
