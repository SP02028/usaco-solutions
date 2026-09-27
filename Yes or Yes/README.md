# Yes or Yes

**Source:** [Codeforces 2178A — Yes or Yes](https://codeforces.com/contest/2178/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

A string of Y and N can be shortened by replacing two adjacent characters with their logical OR (Y if either is Y). Combining two Y's is forbidden. Decide whether the string can be reduced to a single character.

## Approach

- Every Y must eventually be merged into another character, and two Y's can never be merged together, so the reduction is possible exactly when the string contains at most one Y.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(1)

## Concepts

Invariants, Counting

## Files

- [`src/YY.java`](src/YY.java)
