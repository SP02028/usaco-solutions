# Difficult Contest

**Source:** [Codeforces 2125A — Difficult Contest](https://codeforces.com/contest/2125/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem), checked with a custom validator because more than one answer is accepted.

## Problem

Rearrange the letters of a string so that it contains neither "FFT" nor "NTT" as a substring.

## Approach

- Put all T's first, then all F's, then all N's, then every other letter. A T never follows an F or an N, so neither forbidden pattern can appear.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Counting

## Files

- [`src/DC.java`](src/DC.java)
