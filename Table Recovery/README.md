# Table Recovery

**Source:** [USACO 2025 January Contest, Silver — Problem 3: Table Recovery](https://usaco.org/index.php?page=viewproblem2&cpid=1472)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

An N×N addition table (values i + j) had its rows and columns permuted and its values relabelled by an unknown bijection. Recover the lexicographically smallest original table consistent with the given one.

## Approach

- In an addition table the values 2 and 2N each appear exactly once, so the two frequency-1 cells are candidates for the corner.
- For each candidate, recover each row's and column's index from the frequencies of the values in the candidate's column and row, rebuild the table as P[i] + Q[j], and output the lexicographically smaller result.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Frequency Analysis, Constructive

## Files

- [`src/TR.java`](src/TR.java)
