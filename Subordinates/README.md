# Subordinates

**Source:** [CSES Problem Set — Subordinates](https://cses.fi/problemset/task/1674)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Given each employee's direct boss in a company tree rooted at 1, output how many subordinates every employee has.

## Approach

- DFS from the root computing subtree sizes; each employee's subordinate count is their subtree size − 1.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Trees, DFS, Subtree Size

## Files

- [`src/S.java`](src/S.java)
