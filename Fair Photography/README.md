# Fair Photography

**Source:** [USACO 2014 US Open Contest, Bronze — Problem 2: Fair Photography](https://usaco.org/index.php?page=viewproblem2&cpid=431)  
**Difficulty:** Silver (this contest predates Platinum, so its Bronze division was Silver-level)  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows of breed G or H stand at distinct positions. Find the widest photo (a contiguous range of cows) in which the numbers of G's and H's are equal, or in which only one breed appears.

## Approach

- Sort cows by position and encode G = −1, H = +1. A range is balanced iff two prefix sums are equal; store the first position where each prefix sum occurs to get the widest balanced range.
- Separately, scan runs of a single breed and take their widths as well.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Prefix Sums, Hashing, Sorting

## Files

- [`src/FP.java`](src/FP.java)
