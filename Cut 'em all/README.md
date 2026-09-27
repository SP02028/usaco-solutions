# Cut 'em all!

**Source:** [Codeforces 982C — Cut 'em all!](https://codeforces.com/contest/982/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 6 official Codeforces tests that are published in full.

## Problem

In a tree with n vertices, remove the maximum number of edges so that every remaining component has an even number of vertices, or print −1.

## Approach

- If n is odd, it is impossible.
- DFS computes subtree sizes; every subtree of even size can be cut from its parent, so count those subtrees (excluding the root).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Trees, DFS, Subtree Sizes

## Files

- [`src/CEA.java`](src/CEA.java)
