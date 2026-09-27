# Cow Checkups

**Source:** [USACO 2025 January Contest, Bronze — Problem 3: Cow Checkups](https://usaco.org/index.php?page=viewproblem2&cpid=1469)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

Arrays a and b of length N. For each c from 0 to N, count the pairs (l, r) such that reversing a[l..r] makes exactly c positions satisfy a_i = b_i.

## Approach

- Count[i][j] stores the matches that the pair of mirrored positions (i, j) contributes after reversal; accumulating from the centre outward gives the in-segment matches for every (l, r) in O(N²).
- Positions outside the segment are unchanged, so add prefix and suffix match counts, then bucket every (l, r) by its total.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Prefix Sums, Interval DP-style Accumulation

## Files

- [`src/CC.java`](src/CC.java)
