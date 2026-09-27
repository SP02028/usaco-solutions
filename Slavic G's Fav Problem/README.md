# SlavicG's Favorite Problem

**Source:** [Codeforces 1760G — SlavicG's Favorite Problem](https://codeforces.com/contest/1760/problem/G)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Travel on a weighted tree from a to b, where the running XOR of edge weights must be 0 exactly when you arrive at b. You may teleport once to any node except b. Decide whether this is possible.

## Approach

- Collect all XOR values reachable from a without passing through b.
- Collect all XOR values of paths that start at b's neighbours and go away from b.
- A common value means you can teleport between the two sets and finish at b with XOR 0.

## Complexity

- **Time:** O(n) per test case (hash sets)
- **Space:** O(n)

## Concepts

DFS, XOR, Hashing

## Files

- [`src/SGFP.java`](src/SGFP.java)

## Notes

The problem's official name is "SlavicG's Favorite Problem".
