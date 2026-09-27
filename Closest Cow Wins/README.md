# Closest Cow Wins

**Source:** [USACO 2021 December Contest, Silver — Problem 1: Closest Cow Wins](https://usaco.org/index.php?page=viewproblem2&cpid=1158)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 21 official USACO test cases.

## Problem

K grass patches (position, tastiness) lie on a line, and Farmer Nhoj already has M cows placed. Farmer John places N cows; each patch belongs to the strictly closest cow. Maximize the total tastiness Farmer John's cows win.

## Approach

- Sort patches and Nhoj's cows. Patches left of Nhoj's first cow (or right of the last) can all be won by one cow.
- In each gap between two of Nhoj's cows, one FJ cow wins a window of patches of width < gap/2 (best found with a sliding window), and two cows win the whole gap. Record the gain of the first cow and the extra gain of the second.
- The gains of a gap's second cow never exceed its first, so sort all gains descending and take the top N.

## Complexity

- **Time:** O((K + M) log(K + M))
- **Space:** O(K + M)

## Concepts

Greedy, Sliding Window, Sorting

## Files

- [`src/CCW.java`](src/CCW.java)
