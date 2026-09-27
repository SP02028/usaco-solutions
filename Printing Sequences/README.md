# Printing Sequences

**Source:** [USACO 2025 February Contest, Bronze — Problem 3: Printing Sequences](https://usaco.org/index.php?page=viewproblem2&cpid=1493)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

Bessie's program language has PRINT c and REP o … END (repeat o times) statements. Given a sequence and K, decide whether some program with at most K PRINT statements prints it.

## Approach

- Interval DP: f(i, j) is the minimum number of prints for subarray i..j. A single element needs 1.
- Otherwise split into two parts, or, if the subarray is a repetition of a shorter block of length x, use f(i, i + x − 1). Memoize the results.

## Complexity

- **Time:** O(N³) per test case
- **Space:** O(N²)

## Concepts

Interval Dynamic Programming, Periodicity

## Files

- [`src/PS.java`](src/PS.java)
