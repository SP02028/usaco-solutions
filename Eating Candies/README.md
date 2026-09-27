# Eating Candies

**Source:** [Codeforces 1669F — Eating Candies](https://codeforces.com/contest/1669/problem/F)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

n candies in a row; Alice eats from the left and Bob from the right, and their total weights must be equal. Maximize the total number of candies eaten.

## Approach

- Two pointers: advance whichever side has the smaller running sum, and record the count whenever the sums match and the pointers have not crossed.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Two Pointers

## Files

- [`src/EC.java`](src/EC.java)
