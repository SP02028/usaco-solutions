# Room Allocation

**Source:** [CSES Problem Set — Room Allocation](https://cses.fi/problemset/task/1164)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

n customers with arrival and departure days each need a hotel room. Minimize the number of rooms and output an assignment.

## Approach

- Sort customers by arrival and keep a min-heap of (departure day, room). If the earliest-free room frees up strictly before the arrival, reuse it; otherwise open a new room. The answer is the heap's maximum size.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Priority Queue, Interval Scheduling

## Files

- [`src/RA.java`](src/RA.java)
