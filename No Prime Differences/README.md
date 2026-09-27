# No Prime Differences

**Source:** [Codeforces 1838C — No Prime Differences](https://codeforces.com/contest/1838/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 21 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Fill an n×m grid with 1..nm so that no two adjacent cells differ by a prime number.

## Approach

- Write numbers row by row (each row is consecutive, so horizontal differences are 1).
- Order the rows as the upper half interleaved with the lower half: vertical neighbours then differ by m·⌊n/2⌋ or a similar multiple of m, which is composite (or 1).

## Complexity

- **Time:** O(n · m)
- **Space:** O(1)

## Concepts

Constructive, Number Theory

## Files

- [`src/NPD.java`](src/NPD.java)
