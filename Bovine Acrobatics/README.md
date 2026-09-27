# Bovine Acrobatics

**Source:** [USACO 2023 December Contest, Silver — Problem 1: Bovine Acrobatics](https://usaco.org/index.php?page=viewproblem2&cpid=1350)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 17 official USACO test cases.

## Problem

N groups of cows (weight w_i, count a_i) build at most M towers. In a tower, each cow must be at least K lighter than the cow below it. Maximize the number of cows used.

## Approach

- Sort groups by weight and keep a deque of tower tops (top weight, number of towers with that top), starting with M empty towers.
- For each group, greedily stack cows onto the lightest-topped towers whose top is ≤ w − K, consuming towers until the group is exhausted; the used cows become new tops with weight w.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Greedy, Deque, Sorting

## Files

- [`src/BA.java`](src/BA.java)
