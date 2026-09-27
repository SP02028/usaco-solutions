# Badge

**Source:** [Codeforces 1020B — Badge](https://codeforces.com/contest/1020/problem/B)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 16 official Codeforces tests that are published in full.

## Problem

Each student i points to student p_i. Starting the chain of 'blame' at student a, the teacher follows pointers until reaching someone already visited, who receives a second hole in their badge. Print that student for every starting a.

## Approach

- For each start, run Floyd's cycle detection (tortoise and hare) on the functional graph to find a meeting point.
- Restart one pointer at the start and advance both one step at a time; they meet at the first repeated vertex, which is the answer.

## Complexity

- **Time:** O(n²) overall (O(n) per start)
- **Space:** O(n)

## Concepts

Functional Graph, Floyd's Cycle Detection

## Files

- [`src/B.java`](src/B.java)
