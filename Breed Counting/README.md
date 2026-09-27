# Breed Counting

**Source:** [USACO 2015 December Contest, Silver — Problem 3: Breed Counting](https://usaco.org/index.php?page=viewproblem2&cpid=572)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

N cows each have one of three breeds. Answer Q queries asking how many cows of each breed lie in the interval [a, b].

## Approach

- Build one prefix-sum array per breed; each query is answered with three prefix differences.

## Complexity

- **Time:** O(N + Q)
- **Space:** O(N)

## Concepts

Prefix Sums

## Files

- [`src/BCounting.java`](src/BCounting.java)
