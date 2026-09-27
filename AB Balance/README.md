# AB Balance

**Source:** [Codeforces 1606A — AB Balance](https://codeforces.com/contest/1606/problem/A)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

A string of 'a' and 'b' is given. Change the minimum number of characters so that the number of "ab" substrings equals the number of "ba" substrings.

## Approach

- AB(s) = BA(s) exactly when the first and last characters are equal.
- If they already match, print the string unchanged; otherwise replace the first character with the last one (a single change).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Strings, Observation

## Files

- [`src/ABB.java`](src/ABB.java)
