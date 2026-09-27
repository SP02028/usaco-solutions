# Trolley Problem

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

n trolleys (in order) must be routed onto two tracks with capacity lists t1 and t2; a trolley is safe on a track if its weight is at most the next slot's capacity. Maximize the number of trolleys routed.

## Approach

- Sort both capacity lists and process trolleys from last to first, greedily assigning each to a track where it is safe (preferring track 1 when both are). When neither is safe, consume the larger remaining slot.

## Complexity

- **Time:** O(n + a log a + b log b)
- **Space:** O(a + b)

## Concepts

Greedy, Sorting, Two Pointers

## Files

- [`src/Main.java`](src/Main.java)
