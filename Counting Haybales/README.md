# Counting Haybales

**Source:** [USACO 2016 December Contest, Silver — Problem 1: Counting Haybales](https://usaco.org/index.php?page=viewproblem2&cpid=666)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N haybales at distinct positions; each query [A, B] asks how many haybales lie in that range.

## Approach

- Sort the positions; each query is upperBound(B) − upperBound(A − 1) with binary search.

## Complexity

- **Time:** O((N + Q) log N)
- **Space:** O(N)

## Concepts

Binary Search, Sorting

## Files

- [`src/CH.java`](src/CH.java)
