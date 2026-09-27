# Array Craft

**Source:** [Codeforces 1990B — Array Craft](https://codeforces.com/contest/1990/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 10 official Codeforces tests that are published in full.

## Problem

Construct an array of 1's and −1's of length n whose maximum prefix position is x and maximum suffix position is y (x > y).

## Approach

- Fill positions y..x with 1 (these must all be positive to peak there).
- Outside that segment, alternate −1, 1, −1, … moving away from the segment on both sides, so no prefix sum beyond x and no suffix sum before y ever exceeds the peak.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Prefix Sums

## Files

- [`src/AC.java`](src/AC.java)
