# Grandma Capa Knits a Scarf

**Source:** [Codeforces 1582C — Grandma Capa Knits a Scarf](https://codeforces.com/contest/1582/problem/C)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Delete every occurrence of at most one chosen letter (you may delete only some of them) so that the string becomes a palindrome, minimizing the deletions.

## Approach

- For each letter c, run two pointers from both ends: matching characters move inward, a mismatch is fixed by deleting c on whichever side has it, and otherwise c fails.
- Take the minimum over all 26 letters, or −1.

## Complexity

- **Time:** O(26 · n)
- **Space:** O(n)

## Concepts

Two Pointers, Palindromes, Strings

## Files

- [`src/GCKaS.java`](src/GCKaS.java)
