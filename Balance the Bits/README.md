# Balance the Bits

**Source:** [Codeforces 1503A — Balance the Bits](https://codeforces.com/contest/1503/problem/A)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Given a binary string s of even length, build two balanced bracket sequences a and b such that a_i = b_i exactly where s_i = 1.

## Approach

- It is impossible if the number of 1's is odd or if s starts or ends with 0.
- For positions with 1, put '(' in both strings for the first half of those positions and ')' for the second half.
- For positions with 0, alternate '(' / ')' in a and the opposite in b; both sequences stay balanced.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Bracket Sequences

## Files

- [`src/BB.java`](src/BB.java)
