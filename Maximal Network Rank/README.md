# Maximal Network Rank

**Source:** [LeetCode 1615 — Maximal Network Rank](https://leetcode.com/problems/maximal-network-rank/)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

LeetCode 1615: the network rank of two cities is the number of roads touching either of them (a shared road counts once). Return the maximum over all pairs.

## Approach

- Count degrees. For every pair of cities, add their degrees and subtract 1 if they are directly connected.

## Complexity

- **Time:** O(n² · m)
- **Space:** O(n)

## Concepts

Graphs, Degree Counting

## Files

- [`src/MNR.java`](src/MNR.java)

## Notes

Written as a LeetCode-style method with a hard-coded example. It prints a debug line whenever it finds a connected pair.
