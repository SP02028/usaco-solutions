# Icy Perimeter

**Source:** [USACO 2019 January Contest, Silver — Problem 2: Icy Perimeter](https://usaco.org/index.php?page=viewproblem2&cpid=895)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

An N×N grid of ice cream '#' cells. Find the largest blob by area and, among blobs of that area, the smallest perimeter.

## Approach

- Flood fill every unvisited '#' cell. The area is the number of cells; the perimeter counts each side that touches a non-'#' cell or the border.
- Track the maximum area and the minimum perimeter for that area.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Flood Fill, DFS

## Files

- [`src/IP.java`](src/IP.java)
