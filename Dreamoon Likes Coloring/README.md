# Dreamoon Likes Coloring

**Source:** [Codeforces 1329A — Dreamoon Likes Coloring](https://codeforces.com/contest/1329/problem/A)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 18 official Codeforces tests that are published in full.

## Problem

Paint m segments of lengths l_i on n cells (later operations overwrite earlier ones) so that every colour remains visible and every cell is painted. Output the starting positions p_i, or −1.

## Approach

- It is impossible if some l_i + i − 1 > n (colour i could not stay visible) or if the total length is less than n.
- Otherwise start segment i at max(i, n − suffixSum(i) + 1): as early as needed to stay visible, as late as needed to still cover the right end.

## Complexity

- **Time:** O(m)
- **Space:** O(m)

## Concepts

Constructive, Greedy, Suffix Sums

## Files

- [`src/DLC.java`](src/DLC.java)
