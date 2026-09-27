# Lifeguards

**Source:** [USACO 2018 January Contest, Silver — Problem 1: Lifeguards](https://usaco.org/index.php?page=viewproblem2&cpid=786)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N lifeguards cover time intervals. Fire exactly one to maximize the total covered time.

## Approach

- Sweep over start and end events, tracking who is on duty. Add each segment's length to the total, and credit it to the lifeguard who is alone during it.
- Firing the lifeguard with the least alone time is optimal: answer = total − min(alone).

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sweep Line, Sorting

## Files

- [`Lifeguards.java`](Lifeguards.java)
- [`src/L.java`](src/L.java)

## Notes

`Lifeguards.java` is a commented USACO file-I/O version (`lifeguards.in`); `src/L.java` reads stdin.
