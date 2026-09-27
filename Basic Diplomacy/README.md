# Basic Diplomacy

**Source:** [Codeforces 1482C — Basic Diplomacy](https://codeforces.com/contest/1482/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

Over m days you must pick one available friend each day, and no friend may be chosen more than ceil(m/2) times. Output a valid schedule or NO.

## Approach

- First choose each day's first available friend.
- Only one friend can exceed the limit. For that friend, reassign days where they were chosen to the second available friend until the count drops to ceil(m/2); if not enough days have an alternative, answer NO.

## Complexity

- **Time:** O(Σ k_i)
- **Space:** O(Σ k_i)

## Concepts

Greedy, Pigeonhole Principle

## Files

- [`src/BD.java`](src/BD.java)
