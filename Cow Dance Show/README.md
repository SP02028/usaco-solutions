# Cow Dance Show

**Source:** [USACO 2017 January Contest, Silver — Problem 1: Cow Dance Show](https://usaco.org/index.php?page=viewproblem2&cpid=690)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows dance for d_i time units in order, with at most K on stage at once; each finishing cow is immediately replaced by the next. Find the smallest K so the show ends within T_max.

## Approach

- Binary search on K.
- Simulate a given K with a min-heap of finishing times: when the stage is full, the earliest finisher leaves and the next cow starts at that time.

## Complexity

- **Time:** O(N log N · log N)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Priority Queue, Simulation

## Files

- [`src/CDS.java`](src/CDS.java)
