# Hoofball

**Source:** [USACO 2018 February Contest, Bronze — Problem 2: Hoofball](https://usaco.org/index.php?page=viewproblem2&cpid=808)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows on a line each pass the ball to their nearest neighbour (the left one on ties). Find the minimum number of balls Farmer John must hand out so that every cow receives a ball.

## Approach

- Every cow that nobody passes to needs its own ball.
- Also, each pair of cows that only pass to each other (and receive from nobody else) forms a closed loop that needs one extra ball.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Simulation, Functional Graphs

## Files

- [`src/H.java`](src/H.java)
