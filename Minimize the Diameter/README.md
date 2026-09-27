# Minimize the Diameter

**Source:** [Codeforces Gym 104536, problem F](https://codeforces.com/gym/104536/problem/F)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Connect two trees with one new edge so the resulting tree's diameter is as small as possible, and output that diameter.

## Approach

- Find each tree's diameter with two DFS passes (farthest node, then farthest from it).
- Joining the trees at their centres gives diameter max(d1, d2, ceil(d1/2) + ceil(d2/2) + 1).

## Complexity

- **Time:** O(N + M)
- **Space:** O(N + M)

## Concepts

Tree Diameter, DFS

## Files

- [`src/MTD.java`](src/MTD.java)
