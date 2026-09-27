# Sleepy Cow Sorting

**Source:** [USACO 2019 January Contest, Bronze — Problem 2: Sleepy Cow Sorting](https://usaco.org/index.php?page=viewproblem2&cpid=892)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Farmer John repeatedly moves the first cow in line to any later position. Find the minimum number of moves to sort the cows.

## Approach

- The longest sorted suffix never needs to move, and every cow before it must move once. Scan from the end to find where the increasing suffix begins.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Greedy, Observation

## Files

- [`src/Main.java`](src/Main.java)
