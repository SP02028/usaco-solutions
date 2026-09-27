# Hoof Paper Scissors Minus One

**Source:** [USACO 2025 US Open Contest, Bronze — Problem 1: Hoof Paper Scissors Minus One](https://usaco.org/index.php?page=viewproblem2&cpid=1515)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

N hoof symbols with a pairwise win/lose/draw table. In each of M games Elsie reveals her two symbols (s1, s2); Bessie picks two symbols and then keeps one, while Elsie keeps one of hers. Count Bessie's choices that win regardless of Elsie's pick.

## Approach

- Bessie guarantees a win iff one of her two symbols beats both s1 and s2. Let w be the number of symbols that beat both.
- The number of ordered pairs containing at least one such symbol is N² − (N − w)².

## Complexity

- **Time:** O(N² + M · N)
- **Space:** O(N²)

## Concepts

Counting, Complement Counting

## Files

- [`src/HPSMO.java`](src/HPSMO.java)
