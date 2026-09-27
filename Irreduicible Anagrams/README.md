# Irreducible Anagrams

**Source:** [Codeforces 1291D — Irreducible Anagrams](https://codeforces.com/contest/1291/problem/D)  
**Verified:** ✅ Passes the sample tests from the problem statement (full official tests are not published for this problem).

## Problem

For each substring query, decide whether the substring has at least one irreducible anagram (an anagram that cannot be split into pairs of anagrams of each other).

## Approach

- With per-letter prefix counts, the answer is Yes when the substring has length 1, when its first and last characters differ, or when it contains at least 3 distinct letters; otherwise No.

## Complexity

- **Time:** O(26 · (n + q))
- **Space:** O(26 · n)

## Concepts

Prefix Sums, Strings, Case Analysis

## Files

- [`src/IA.java`](src/IA.java)

## Notes

The folder name is a misspelling of "Irreducible Anagrams".
