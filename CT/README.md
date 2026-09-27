# Concert Tickets

**Source:** [CSES Problem Set — Concert Tickets](https://cses.fi/problemset/task/1091)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

n concert tickets with prices and m customers arriving in order, each with a maximum price. Each customer buys the most expensive remaining ticket they can afford, or gets −1.

## Approach

- Keep the ticket prices in a multiset (TreeMap of counts).
- For each customer, take floorKey(budget); if one exists, print it and remove one copy.

## Complexity

- **Time:** O((n + m) log n)
- **Space:** O(n)

## Concepts

TreeMap, Multiset, Greedy

## Files

- [`CT.java`](CT.java)

## Notes

The folder name is short for Concert Tickets.
