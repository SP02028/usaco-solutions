# Why Did the Cow Cross the Road II

**Source:** [USACO 2017 February Contest, Silver — Problem 2: Why Did the Cow Cross the Road II](https://usaco.org/index.php?page=viewproblem2&cpid=715)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

N crossing signals, B of them broken. Find the minimum number of signals to repair so that some block of K consecutive signals all work.

## Approach

- A prefix count of working signals gives, for every window of length K, how many work; the answer is K minus the best window.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Prefix Sums, Sliding Window

## Files

- [`src/WDTCCTRII.java`](src/WDTCCTRII.java)
