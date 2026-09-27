# Barnscape Outline

**Source:** [USACO 2005 November Contest, Silver — City Skyline (POJ 3044 mirror)](http://poj.org/problem?id=3044)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

N buildings are given left to right, each with a coordinate and a height. Count the minimum number of rectangles needed to draw the skyline outline, where each rectangle can span consecutive positions at a fixed height.

## Approach

- Maintain a monotonic increasing stack of 'open' heights.
- When the height rises, push it; when it falls, pop every taller height (each popped height closes one rectangle) and push the new height if it is not already on top.
- The answer is the number of closed rectangles plus the heights remaining on the stack at the end; height 0 never needs a rectangle.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Monotonic Stack, Greedy

## Files

- [`src/BO.java`](src/BO.java)

## Notes

This is AlphaStar's reworded version of USACO 2005 November Silver "City Skyline"; the folder keeps the AlphaStar title. That contest predates the problems hosted on usaco.org, so the link points to the POJ mirror and the solution could not be checked against official tests.
