# Studying Algorithms

**Source:** [Codeforces Gym 102951, problem B](https://codeforces.com/gym/102951/problem/B)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Given the time needed to learn each of N algorithms and X total minutes, find the maximum number of algorithms that can be learned.

## Approach

- Sort the times and greedily learn the fastest algorithms first while time remains.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Greedy, Sorting

## Files

- [`src/studalg.java`](src/studalg.java)
