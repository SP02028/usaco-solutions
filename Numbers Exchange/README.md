# Numbers Exchange

**Source:** [Codeforces 746E — Numbers Exchange](https://codeforces.com/contest/746/problem/E)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 9 official Codeforces tests that are published in full.

## Problem

Eugeny has n cards (n even) and Nikolay has cards 1..m. Exchange as few cards as possible so Eugeny's cards are all distinct with exactly n/2 even and n/2 odd values, and print the result, or −1.

## Approach

- Mark duplicates and any excess of one parity (beyond n/2) for replacement.
- Fill the replacements from Nikolay's unused numbers (only the first few hundred thousand are ever needed), choosing the parity that is still short; fail if none remain.

## Complexity

- **Time:** O(n + min(m, 4·10⁵))
- **Space:** O(n + min(m, 4·10⁵))

## Concepts

Greedy, Hashing, Parity

## Files

- [`src/NE.java`](src/NE.java)
