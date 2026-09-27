# Running for Gold

**Source:** [Codeforces 1552B — Running for Gold](https://codeforces.com/contest/1552/problem/B)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

n athletes each have ranks in 5 marathons. An athlete is superior to another if better in at least 3 of them. Find an athlete superior to everyone, or −1.

## Approach

- Keep a candidate: whenever the current candidate is not superior to athlete i, athlete i becomes the new candidate.
- Finally verify the candidate against everyone.

## Complexity

- **Time:** O(5n) per test case
- **Space:** O(5n)

## Concepts

Tournament Elimination, Greedy

## Files

- [`src/RFG.java`](src/RFG.java)
