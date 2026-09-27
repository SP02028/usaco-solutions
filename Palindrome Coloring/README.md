# Palindromes Coloring

**Source:** [Codeforces 1624D — Palindromes Coloring](https://codeforces.com/contest/1624/problem/D)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Colour some letters of a string with k colours (each colour used at least once) so that each colour's letters can form a palindrome. Maximize the length of the shortest colour's palindrome.

## Approach

- Count letter pairs and single letters. Distribute pairs evenly: each colour gets 2 · (pairs / k) letters.
- One extra middle letter is possible if the leftover pairs (counted as 2 letters each) plus the single letters are enough to give every colour a centre.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(26)

## Concepts

Greedy, Counting, Palindromes

## Files

- [`src/PC.java`](src/PC.java)
