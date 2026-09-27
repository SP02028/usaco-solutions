# Compressed Bracket Sequence

**Source:** [Codeforces 1556C — Compressed Bracket Sequence](https://codeforces.com/contest/1556/problem/C)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

A bracket sequence is given compressed: c_1 '(' then c_2 ')' then c_3 '(' and so on. Count its substrings that are regular bracket sequences.

## Approach

- Fix the opening block i where a substring starts and walk forward through later blocks, tracking the current balance and the minimum balance reached.
- When reaching a closing block k, count how many start positions within block i (lower and upper bounds from the balance constraints) produce a balanced substring that ends inside block k.

## Complexity

- **Time:** O(n²)
- **Space:** O(n)

## Concepts

Bracket Sequences, Counting

## Files

- [`src/CBS.java`](src/CBS.java)
