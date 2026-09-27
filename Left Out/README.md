# Left Out

**Source:** [USACO 2019 US Open Contest, Silver — Problem 1: Left Out](https://usaco.org/index.php?page=viewproblem2&cpid=942)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

An N×N grid of cows faces left or right. Flipping a whole row or column is allowed. Find the single cow whose flip would make all cows face the same way, or −1.

## Approach

- Normalize the grid by flipping columns so row 0 is all R, then rows so column 0 is all R.
- In the remaining (N−1)×(N−1) block: if it is all R, cow (1,1) is the answer; if a full row or column of that block is L, the answer is on the border; if exactly one cell is L, that cell is the answer; otherwise −1.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Grid, Case Analysis, Invariants

## Files

- [`src/LO.java`](src/LO.java)
- [`src/LO3.java`](src/LO3.java)

## Notes

`LO.java` reads stdin; `LO3.java` is the USACO file-I/O version (`leftout.in` / `leftout.out`).
