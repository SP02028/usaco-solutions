# Hacker, pack your bags!

**Source:** [Codeforces 822C — Hacker, pack your bags!](https://codeforces.com/contest/822/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Choose two non-overlapping vouchers whose durations sum exactly to x, minimizing the total cost.

## Approach

- Create a start event and an end event for every voucher and sort all events by time (starts before ends at equal times).
- Sweep: when a voucher ends, record bestCost[duration]. When one starts, pair it with the cheapest already-finished voucher of duration x − d.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n + max duration)

## Concepts

Sweep Line, Sorting, Greedy

## Files

- [`src/HPYB.java`](src/HPYB.java)
