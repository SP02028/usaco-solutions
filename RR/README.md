# Range Reconstruction

**Source:** [USACO 2022 December Contest, Silver — Problem 3: Range Reconstruction](https://usaco.org/index.php?page=viewproblem2&cpid=1256)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 14 official USACO test cases.

## Problem

For a hidden array a, you are given r[i][j] = max(a_i..a_j) − min(a_i..a_j) for all i ≤ j. Output any array consistent with these values (Range Reconstruction).

## Approach

- Build the array from right to left. |a_i − a_{i+1}| = r[i][i+1], so a_i is a_{i+1} ± r[i][i+1].
- Try the plus sign and verify every range starting at i; if any check fails, use the minus sign (the problem guarantees one of them works).

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Constructive, Verification

## Files

- [`RR.java`](RR.java)

## Notes

The folder name is short for Range Reconstruction.
