# Meetings

**Source:** [USACO 2019 December Contest, Silver — Problem 2: Meetings](https://usaco.org/index.php?page=viewproblem2&cpid=967)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

N cows on a line of length L walk left or right with weights and bounce off each other. Find the time T when the cows that have reached the barns weigh at least half the total, and count the meetings (collisions) before T.

## Approach

- Bouncing is equivalent to passing through, so the exit times are the same multiset. Left-exits belong to the leftmost cows in order and right-exits to the rightmost.
- Sort the exit times with their weights and accumulate weight until reaching half, which gives T.
- Count pairs of a right-mover and a later left-mover whose starting distance is ≤ 2T with a sliding window.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Two Pointers, Physics Trick

## Files

- [`src/M.java`](src/M.java)
