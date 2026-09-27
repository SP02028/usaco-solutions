# They Are Everywhere

**Source:** [Codeforces 701C — They Are Everywhere](https://codeforces.com/contest/701/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 32 official Codeforces tests that are published in full.

## Problem

Find the shortest contiguous segment of flats that contains every Pokémon type present in the house.

## Approach

- Sliding window: extend the right end, and while every type is present, record the window length and shrink from the left.

## Complexity

- **Time:** O(n)
- **Space:** O(alphabet size)

## Concepts

Sliding Window, Two Pointers

## Files

- [`src/Tae.java`](src/Tae.java)
