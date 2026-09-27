# Cheap Travel

**Source:** [Codeforces 466A — Cheap Travel](https://codeforces.com/contest/466/problem/A)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 19 official Codeforces tests that are published in full.

## Problem

A single ride costs a rubles and an m-ride ticket costs b. Find the minimum cost of n rides.

## Approach

- If m single rides are cheaper than one m-ticket, buy only singles.
- Otherwise buy floor(n/m) m-tickets and cover the remainder with the cheaper of singles and one more m-ticket.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Concepts

Greedy, Math

## Files

- [`src/CT.java`](src/CT.java)
