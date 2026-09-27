# Wizard's Tour

**Source:** [Codeforces 860D — Wizard's Tour](https://codeforces.com/contest/860/problem/D)  
**Difficulty:** Codeforces rating 2300  
**Verified:** ✅ Passes all 19 official Codeforces tests that are published in full.

## Problem

Given an undirected graph, the wizard travels episodes x → y → z along two distinct roads, and each road can be used at most once overall. Maximize the number of episodes and list them (Wizard's Tour).

## Approach

- DFS builds a spanning forest. Process vertices bottom-up: at each vertex collect its unused incident edges (back edges seen from the lower endpoint plus tree edges to children that were not consumed below) and pair them up two at a time through that vertex.
- If one edge is left over, pair it with the edge to the parent, which is then consumed. This pairs ⌊m/2⌋ edges per component, the maximum possible.

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m)

## Concepts

DFS, Edge Pairing, Constructive

## Files

- [`src/WT.java`](src/WT.java)

## Notes

This folder was previously named "Test Tubes"; the IntelliJ project was named "Wizards Tour" and the code solves Codeforces "Wizard's Tour", so the folder has been renamed.
