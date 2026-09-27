# T-shirt buying

**Source:** [Codeforces 799B — T-shirt buying](https://codeforces.com/contest/799/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full.

## Problem

Each t-shirt has a price, a front colour and a back colour (1–3). Buyers arrive in order with a favourite colour and buy the cheapest remaining shirt that has that colour on either side. Output the prices paid (or −1).

## Approach

- Keep one list per colour sorted by price and a pointer into each list, plus a set of sold shirts. For each buyer, advance that colour's pointer past sold shirts and take the next one.

## Complexity

- **Time:** O(n log n + m)
- **Space:** O(n)

## Concepts

Sorting, Pointers, Hashing

## Files

- [`src/TSB.java`](src/TSB.java)
