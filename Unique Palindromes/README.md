# Unique Palindromes

**Source:** [Codeforces 1823D — Unique Palindromes](https://codeforces.com/contest/1823/problem/D)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 14 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Build a string of length n where the prefix of length x_i contains exactly c_i distinct palindromic substrings for every given condition, or report NO.

## Approach

- Filler text repeating "abc" adds exactly one new palindrome per character only through the single letters it has already seen, so it adds nothing after the first three characters.
- Start with c_1 − 3 copies of 'a' (each adds one new palindrome) and fill the rest with the abc cycle. For each later condition, append (c_j − c_{j−1}) copies of a fresh letter, which adds that many palindromes, and fill the remaining length with the abc cycle. It is impossible when a required increase exceeds the added length.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive, Palindromes, Strings

## Files

- [`src/UP.java`](src/UP.java)
