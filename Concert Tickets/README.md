# Concert Tickets

**Source:** [CSES Problem Set — Concert Tickets](https://cses.fi/problemset/task/1091)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

n tickets with prices and m customers, each buying the most expensive remaining ticket at or below their budget (or −1).

## Approach

- Keep ticket prices in a multiset implemented with a TreeMap of counts; for each customer use floorKey and decrement that price.

## Complexity

- **Time:** O((n + m) log n)
- **Space:** O(n)

## Concepts

TreeMap, Multiset, Greedy

## Files

- [`src/CT.java`](src/CT.java)
