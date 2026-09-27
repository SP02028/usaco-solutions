# Circular Barn

**Source:** [USACO 2016 February Contest, Silver — Problem 1: Circular Barn](https://usaco.org/index.php?page=viewproblem2&cpid=618) · [USACO 2016 February Contest, Bronze — Problem 2: Circular Barn](https://usaco.org/index.php?page=viewproblem2&cpid=616)  
**Difficulty:** Silver  
**Verified:**
- `src/CBS.java`: ✅ Passes all 10 official USACO test cases (USACO Silver version).
- `src/CBS3.java`: ✅ Passes all 10 official USACO test cases (USACO Silver version).
- `src/Main.java`: ✅ Passes all 10 official USACO test cases (USACO Bronze version).

## Problem

A circular barn has N rooms, and room i needs c_i cows at the end. Cows enter together through one door, and each walks clockwise to its room, paying (distance)². Minimize the total energy.

## Approach

- Find a starting room where no cow ever has to pass the start: a running 'carry' of cows (max(0, carry + c_i − 1)) is 0 there.
- Rotate the array to that start, then process rooms in order. Each room's arriving cows travel distances c, c+1, …, so their cost is a difference of sum-of-squares formulas.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Greedy, Circular Arrays, Math

## Files

- [`src/CBS.java`](src/CBS.java)
- [`src/CBS3.java`](src/CBS3.java)
- [`src/Main.java`](src/Main.java)

## Notes

`CBS.java` solves the Silver version (stdin) and `CBS3.java` is the same solution with USACO file I/O (`cbarn.in` / `cbarn.out`), originally uploaded as a top-level file labelled "(G)". `Main.java` solves the Bronze version by trying every entry door.
