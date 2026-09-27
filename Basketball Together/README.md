# Basketball Together

**Source:** [Codeforces 1725B — Basketball Together](https://codeforces.com/contest/1725/problem/B)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 21 official Codeforces tests that are published in full.

## Problem

n players have powers P_i. A team defeats the enemy of power D if (team size) × (max power in team) > D. Each player joins at most one team. Maximize the number of winning teams.

## Approach

- Sort powers. Greedily let the strongest remaining player lead a team and fill it with the weakest remaining players; the team needs ceil((D + 1) / P) members.
- Stop when there are not enough remaining players.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Sorting

## Files

- [`src/BT.java`](src/BT.java)
