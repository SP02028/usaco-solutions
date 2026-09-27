# Rental Service

**Source:** [USACO 2018 January Contest, Silver — Problem 2: Rental Service](https://usaco.org/index.php?page=viewproblem2&cpid=787)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Farmer John can sell milk to M shops (each buys up to q gallons at price p) or rent cows to R neighbours at fixed prices. Maximize the total profit.

## Approach

- Sort cows by milk output. Rent out the lowest producers to the highest-paying renters and milk the rest.
- Precompute the best rental income for the i lowest cows, and the milk revenue for the i highest cows by greedily filling the highest-paying shops first. Try every split point.

## Complexity

- **Time:** O(N log N + M log M + R log R)
- **Space:** O(N + M + R)

## Concepts

Greedy, Prefix Sums, Sorting

## Files

- [`src/RS.java`](src/RS.java)
- [`src/RS3.java`](src/RS3.java)

## Notes

`RS3.java` is the same solution with USACO file I/O (`rental.in` / `rental.out`), originally uploaded as a top-level file.
