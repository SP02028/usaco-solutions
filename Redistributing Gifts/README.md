# Redistributing Gifts

**Source:** [USACO 2022 February Contest, Silver — Problem 1: Redistributing Gifts](https://usaco.org/index.php?page=viewproblem2&cpid=1206)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Each cow ranks the gifts, and cow i currently holds gift i. Cows may redistribute gifts if nobody ends up worse off. Output the best gift each cow can guarantee in some valid redistribution.

## Approach

- Draw an edge from cow i to every gift she prefers over (or equal to) her own. Cow i can get gift j iff i and j lie on a common cycle, meaning j can reach i.
- Run a DFS from every cow for reachability, then give each cow the first gift in her list that can reach her.

## Complexity

- **Time:** O(N³)
- **Space:** O(N²)

## Concepts

Graph Reachability, DFS, Cycles

## Files

- [`src/RG.java`](src/RG.java)
