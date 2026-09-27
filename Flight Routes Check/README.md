# Flight Routes Check

**Source:** [CSES Problem Set — Flight Routes Check](https://cses.fi/problemset/task/1682)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Given a directed flight network, decide whether every city can reach every other city; if not, output a pair (a, b) such that b cannot be reached from a.

## Approach

- DFS from city 1 on the original graph; any unreached city i gives the pair (1, i).
- DFS from city 1 on the reversed graph; any unreached city i means i cannot reach 1, giving (i, 1).

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m)

## Concepts

Strong Connectivity, DFS, Reverse Graph

## Files

- [`src/FRC.java`](src/FRC.java)
