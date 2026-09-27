# Quiz Master

**Source:** [Codeforces 1777C — Quiz Master](https://codeforces.com/contest/1777/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Choose students (smartness a_i) so that every topic 1..m is covered, where a student is proficient in topic t iff t divides a_i. Minimize the maximum minus minimum smartness in the team.

## Approach

- Sort by smartness and precompute each student's divisors up to m.
- A sliding window over the sorted students keeps per-topic counts and the number of covered topics; shrink from the left while all m topics are covered and track the smallest spread.

## Complexity

- **Time:** O(n √A + n log n)
- **Space:** O(n √A)

## Concepts

Two Pointers, Divisors, Sliding Window

## Files

- [`src/QM.java`](src/QM.java)
