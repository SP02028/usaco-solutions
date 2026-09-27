# Milk Measurement

**Source:** [USACO 2017 December Contest, Silver — Problem 2: Milk Measurement](https://usaco.org/index.php?page=viewproblem2&cpid=763) · [USACO 2017 December Contest, Bronze — Problem 3: Milk Measurement](https://usaco.org/index.php?page=viewproblem2&cpid=761)  
**Difficulty:** Silver  
**Verified:**
- `src/MM.java`: ✅ Passes all 11 official USACO test cases (USACO Silver version).
- `src/MM7.java`: ✅ Passes all 11 official USACO test cases (USACO Silver version).
- `src/Main.java`: ✅ Passes all 10 official USACO test cases (USACO Bronze version).

## Problem

Silver version: many cows start at G gallons, and a log of changes (day, cow, delta) is applied in order. Count the days on which the set of top-producing cows changes.

## Approach

- Keep each cow's output in a map, counts per output value in a map, and a max-heap of values (lazy deletion).
- Before and after each change, compare whether the cow was or is at the top and whether the number of cows at the top changed; count a change accordingly.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Priority Queue, Hashing, Simulation

## Files

- [`src/MM.java`](src/MM.java)
- [`src/MM7.java`](src/MM7.java)
- [`src/Main.java`](src/Main.java)

## Notes

`MM.java` solves the Silver version and `MM7.java` is the same solution with USACO file I/O (`measurement.in` / `measurement.out`). `Main.java` solves the Bronze version (three cows, Bessie/Elsie/Mildred, each starting at 7).
