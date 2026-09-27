# No Casino in the Mountains

**Source:** [Codeforces 2126B — No Casino in the Mountains](https://codeforces.com/contest/2126/problem/B)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

A trail of days is marked rainy (1) or clear (0). A hike needs k consecutive clear days, and after each hike you must rest one day. Maximize the number of hikes.

## Approach

- Greedy scan: whenever the next k days are all clear, take the hike and skip k + 1 days; otherwise move forward one day.

## Complexity

- **Time:** O(n · k)
- **Space:** O(n)

## Concepts

Greedy

## Files

- [`src/NCITM.java`](src/NCITM.java)
