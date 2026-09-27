# Subset Equality

**Source:** [USACO 2022 US Open Contest, Silver — Problem 2: Subset Equality](https://usaco.org/index.php?page=viewproblem2&cpid=1231)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

For each query set of letters (from a–r), decide whether strings s and t become equal after deleting every letter not in the set.

## Approach

- Walk both strings with two pointers, skipping letters outside the query set, and compare the remaining characters. Answer Y if both are exhausted together, otherwise N.

## Complexity

- **Time:** O(Q · (|s| + |t|))
- **Space:** O(1) per query

## Concepts

Two Pointers, Strings

## Files

- [`SubsetEquality.java`](SubsetEquality.java)
- [`src/SE.java`](src/SE.java)

## Notes

`SubsetEquality.java` is a commented copy of `src/SE.java`.
