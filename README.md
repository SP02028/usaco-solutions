# USACO & Competitive Programming Solutions

Java solutions to 427 competitive programming problems, mostly from USACO and Codeforces, plus CSES and a few other judges.
Each problem lives in its own folder with a `README.md` that links the original problem, summarizes it,
explains the approach and its complexity, and says how the solution was verified.

## At a glance

| Source | Problems |
| --- | ---: |
| USACO Bronze | 75 |
| USACO Silver | 91 |
| USACO Gold | 3 |
| Codeforces | 209 |
| CSES | 23 |
| Other judges | 13 |
| Practice & unlisted | 13 |
| **Total** | **427** |

**377 of 427** folders contain only solutions that pass the problem's official tests (or its statement samples, for the newest Codeforces problems).
The rest are for judges that don't publish test data (CSES, LeetCode, AtCoder, JOI, …), interactive problems, or practice problems that aren't publicly listed.

## Verification

- **USACO:** every solution was run against the official test data from usaco.org.
- **Codeforces:** solutions were run against the official tests whose full input is published (via the open-r1/codeforces dataset) or, for the newest contests, against the samples in the statement.
- **Problems with several correct answers** (constructive outputs, any valid schedule, …) were checked with custom validators instead of exact comparison.
- Each problem's README states the exact result under **Verified**.

## Running a solution

Most programs read standard input and write standard output:

```bash
cd "Angry Cows/src"
javac AC.java
java AC < input.txt
```

Older USACO problems use file I/O instead: they read `<name>.in` and write `<name>.out` in the working directory (the README notes when a solution does this).
A few solutions use `List.getFirst()` or `Math.ceilDiv()`, so compile with **Java 21** or newer.

## Problem index

### USACO Bronze (75)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [Acowdemia I](Acowdemia%201/) | [USACO 2021 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1131) | ✅ | Sorting, Greedy |
| [Acowdemia II](Acowdemia%20II/) | [USACO 2021 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1132) | ✅ | Simulation, Ordering |
| [Air Cownditioning](Air%20Cownditioning/) | [USACO 2021 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1156) | ✅ | Greedy, Difference Array, Simulation |
| [Alchemy](Alchemy/) | [USACO 2022 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1229) | ✅ | Simulation, Greedy |
| [Back and Forth](Back%20and%20Forth/) | [USACO 2018 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=857) | ✅ | Complete Search, Recursion |
| [Balancing Bacteria](Balancing%20Bacteria/) | [USACO 2024 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1373) | ✅ | Difference Arrays, Greedy, Prefix Sums |
| [Block Game](Block%20Game/) | [USACO 2016 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=664) | ✅ | Counting, Simulation |
| [Blocks](Blocks/) | [USACO 2022 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1205) | ✅ | Complete Search, Permutations |
| [Bovine Genomics](Bovine%20Genomics/) | [USACO 2017 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=736) | ✅ | Complete Search, Strings |
| [Cannonball](Cannonball/) | [USACO 2024 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1372) | ✅ | Simulation |
| [Comfortable Cows](Comfortable%20Cows/) | [USACO 2021 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1108) | ✅ | Simulation, Grid |
| [Contaminated Milk](Contaminated%20Milk/) | [USACO 2015 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=569) | ✅ | Simulation, Set Intersection |
| [Counting Liars](Counting%20Liars/) | [USACO 2022 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1228) | ✅ | Complete Search |
| [Cow Checkups](Cow%20Checkups/) | [USACO 2025 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1469) | ✅ | Prefix Sums, Interval DP-style Accumulation |
| [Cow Evolution](Cow%20Evolution/) | [USACO 2019 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=941) | ✅ | Complete Search, Sets |
| [Cow Tipping](Cow%20Tipping/) | [USACO 2017 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=689) | ✅ | Greedy, Simulation |
| [Cowntact Tracing](Cowtact%20Tracing/) | [USACO 2020 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1037) | ✅ | Complete Search, Simulation |
| [Cowntact Tracing 2](Cowtact%20Tracing%202/) | [USACO 2023 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1348) | ✅ | Greedy, Strings |
| [Daisy Chains](Daisy%20Chains/) | [USACO 2020 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1060) | ✅ | Complete Search, Brute Force |
| [Do You Know Your ABCs?](Do%20you%20know%20your%20ABCS/) | [USACO 2020 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1059) | ✅ | Sorting, Math |
| [Drought](Drought/) | [USACO 2022 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1181) | ✅ | Greedy, Simulation |
| [Even More Odd Photos](Even%20More%20Odd%20Commercials/) | [USACO 2021 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1084) | ✅ | Greedy, Parity |
| [Farmer John Actually Farms](Farmer%20John%20Actually%20Farms/) | [USACO 2023 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1349) | ✅ | Sorting, Inequalities, Math |
| [Farmer John's Cheese Block](Farmer%20John%27s%20Cheese%20Block/) | [USACO 2024 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1444) | ✅ | Counting, Simulation |
| [Farmer John's Cheese Block](Farmer%20Johns%20Cheese%20Block/) | [USACO 2024 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1444) | ✅ | Counting, Simulation |
| [FEB](FEB/) | [USACO 2023 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1323) | ✅ | Case Analysis, Parity, Strings |
| [Feeding the Cows](Feeding%20the%20cows/) | [USACO 2022 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1252) | ✅ | Greedy |
| [Field Reduction](Field%20Reduction/) | [USACO 2016 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=641) | ✅ | Geometry, Greedy |
| [Herdle](Herdle/) | [USACO 2022 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1179) | ✅ | Simulation, Counting |
| [Hoof Paper Scissors Minus One](Hoof%20Paper%20Scissors%20Minus%201/) | [USACO 2025 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1515) | ✅ | Counting, Complement Counting |
| [Hoofball](Hoofball/) | [USACO 2018 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=808) | ✅ | Simulation, Functional Graphs |
| [It's Mooin' Time](It%27s%20mooing%20time/) | [USACO 2024 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1445) | ✅ | Brute Force with Incremental Updates, Hashing |
| [It's Mooin' Time II](It%27s%20mooin%20Time%20II/) | [USACO 2025 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1468) | ✅ | Counting, Prefix Distinct Values |
| [It's Mooin' Time II](Its%20Mooin%20Time%202/) | [USACO 2025 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1468) | ✅ | Counting, Prefix Distinct Values |
| [Just Stalling](Just%20Stalling/) | [USACO 2021 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1085) | ✅ | Combinatorics, Sorting, Two Pointers |
| [Leaders](Leaders/) | [USACO 2023 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1275) | ✅ | Case Analysis, Greedy |
| [Load Balancing](Load%20Balancing/) | [USACO 2016 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=617) | ✅ | Complete Search |
| [Logical Moos](Logical%20Moos/) | [USACO 2024 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1419) | ✅ | Prefix Computation, Expression Evaluation |
| [Lonely Photo](Lonely%20Cow/) | [USACO 2021 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1155) | ✅ | Counting, Two Pointers |
| [Majority Opinion](Majority%20Opinion/) | [USACO 2024 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1371) | ✅ | Observation, Constructive |
| [Making Mexes](Making%20Mexes/) | [USACO 2025 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1492) | ✅ | Counting, MEX |
| [Milk Exchange](Milk%20Exchange/) | [USACO 2024 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1396) | ✅ | Simulation, Circular Arrays |
| [Milk Factory](Milk%20Factory/) | [USACO 2019 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=940) | ✅ | Graphs, Degree Counting |
| [Milking Order](Milking%20Order/) | [USACO 2018 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=832) | ✅ | Greedy, Complete Search |
| [Modern Art](Modern%20Art/) | [USACO 2017 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=737) | ✅ | Bounding Boxes, Complete Search |
| [Moo Language](Moo%20Language/) | [USACO 2023 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1324) | ✅ | Greedy, Constructive, Strings |
| [More Cow Photos](More%20Cow%20Photos/) | [USACO 2025 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1516) | ✅ | Counting, Greedy |
| [Mowing the Field](Mowing%20The%20Field/) | [USACO 2016 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=593) | ✅ | Simulation, Hashing |
| [Non-Transitive Dice](Non%20Transitive%20Dice/) | [USACO 2022 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1180) | ✅ | Complete Search |
| [Palindrome Game](Palindrome%20Game/) | [USACO 2024 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1395) | ✅ | Game Theory, Invariants |
| [Photoshoot](Photoshoot%203/) | [USACO 2020 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=988) | ✅ | Complete Search, Permutations |
| [Photoshoot 2](Photoshoot%202/) | [USACO 2022 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1204) | ✅ | Greedy, Two Pointers |
| [Printing Sequences](Printing%20Sequences/) | [USACO 2025 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1493) | ✅ | Interval Dynamic Programming, Periodicity |
| [Promotion Counting](Promotion%20Counting/) | [USACO 2016 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=591) | ✅ | Math, Implementation |
| [Race](Race/) | [USACO 2020 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=989) | ✅ | Simulation, Math |
| [Reflection](Reflection/) | [USACO 2025 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1491) | ✅ | Symmetry, Incremental Updates |
| [Reverse Engineering](Reverse%20Engineering/) | [USACO 2022 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1253) | ✅ | Greedy, Simulation |
| [Rotate and Shift](Rotate%20and%20Shift/) | [USACO 2023 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1325) | ✅ | Modular Arithmetic, Simulation |
| [Roundabout Rounding](Roundabout%20Rounding2/) | [USACO 2024 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1443) | ✅ | Math, Digits |
| [Sleeping in Class](Sleeping%20In%20Class/) | [USACO 2022 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1203) | ✅ | Divisors, Greedy |
| [Sleepy Cow Sorting](Sleepy%20Cow%20Sorting/) | [USACO 2019 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=892) | ✅ | Greedy, Observation |
| [Social Distancing I](Social%20Distancing%201/) | [USACO 2020 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1035) | ✅ | Binary Search on Answer, Greedy |
| [Social Distancing II](Social%20Distancing%202/) | [USACO 2020 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1036) | ✅ | Greedy, Sweep |
| [Speeding Ticket](Speeding%20Ticket/) | [USACO 2015 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=568) | ✅ | Simulation |
| [Stamp Grid](Stamp%20Grid/) | [USACO 2023 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1300) | ✅ | Simulation, Greedy, Rotation |
| [Stuck in a Rut](Str2/) | [USACO 2020 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1061) | ✅ | Simulation, Sorting |
| [Swapity Swap](Swapity%20Swap/) | [USACO 2020 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1013) | ✅ | Simulation, Cycle Detection |
| [Taming the Herd](Taming%20The%20Herd/) | [USACO 2018 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=809) | ✅ | Simulation, Constraint Propagation |
| [Uddered but not Herd](Uddered%20but%20not%20Herd/) | [USACO 2021 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1083) | ✅ | Greedy, Strings |
| [Walking Along a Fence](Walking%20Along%20a%20Fence/) | [USACO 2024 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1420) | ✅ | Simulation, Prefix Distances |
| [Walking Home](Walking%20Home/) | [USACO 2021 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1157) | ✅ | Complete Search, Case Analysis |
| [Watching Mooloo](Watching%20Mooloo/) | [USACO 2023 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=1301) | ✅ | Greedy |
| [Why Did the Cow Cross the Road](Why%20Did%20the%20Cow%20Cross%20the%20Road/) | [USACO 2017 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=711) | ✅ | Simulation |
| [Why Did the Cow Cross the Road II](Cow%20Cross%20II/) | [USACO 2017 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=712) | ✅ | Intervals, Brute Force |
| [Why Did the Cow Cross the Road III](Cow%20Road%20III/) | [USACO 2017 February Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=713) | ✅ | Sorting, Simulation |

### USACO Silver (91)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [Acowdemia](Acowdemia/) | [USACO 2021 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1136) | ✅ | Binary Search on Answer, Sorting, Greedy |
| [Angry Cows](Angry%20Cows%20(S)/) | [USACO 2016 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=594) | ✅ | Binary Search on Answer, Greedy, Sorting |
| [Barn Tree](Barn%20Tree/) | [USACO 2022 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1254) | ✅ | Trees, DFS, Subtree Sums, Topological Sort |
| [Berry Picking](Berry%20Picking/) | [USACO 2020 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=990) | ✅ | Complete Search, Greedy, Sorting |
| [Bovine Acrobatics](Bovine%20Acrobatics/) | [USACO 2023 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1350) | ✅ | Greedy, Deque, Sorting |
| [Breed Counting](Breed%20Counting/) | [USACO 2015 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=572) | ✅ | Prefix Sums |
| [Build Gates](Build%20Gates/) | [USACO 2016 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=596) | ✅ | Flood Fill, BFS, Coordinate Scaling |
| [Circular Barn](Circular%20Barn/) | [USACO 2016 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=618) | ✅ | Greedy, Circular Arrays, Math |
| [Circular Barn](Circular%20Barn%20(s)/) | [USACO 2016 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=618) | ✅ | Complete Search, Simulation |
| [Cities and States](Cities%20and%20States/) | [USACO 2016 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=667) | ✅ | Hashing, Counting |
| [Closest Cow Wins](Closest%20Cow%20Wins/) | [USACO 2021 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1158) | ✅ | Greedy, Sliding Window, Sorting |
| [Closing the Farm](CTF/) | [USACO 2016 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=644) | ✅ | Graph Connectivity, DFS |
| [Comfortable Cows](Comfortable%20Cows%20(Silver)/) | [USACO 2021 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1110) | ✅ | BFS, Simulation, Grid |
| [Connecting Two Barns](Connecting%20Two%20Barns/) | [USACO 2021 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1159) | ✅ | Connected Components, Two Pointers, DFS |
| [Convention](Convention/) | [USACO 2018 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=858) | ✅ | Binary Search on Answer, Greedy |
| [Convention II](Convention%20II/) | [USACO 2018 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=859) | ✅ | Priority Queue, Simulation |
| [Convoluted Intervals](Convoluted%20Intervals/) | [USACO 2021 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1160) | ✅ | Difference Arrays, Prefix Sums, Counting |
| [Counting Haybales](Counting%20Haybales/) | [USACO 2016 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=666) | ✅ | Binary Search, Sorting |
| [Cow Dance Show](Cow%20Dance%20Show/) | [USACO 2017 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=690) | ✅ | Binary Search on Answer, Priority Queue, Simulation |
| [Cow Frisbee](Cow%20Frisbee/) | [USACO 2022 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1183) | ✅ | Monotonic Stack |
| [Cow-libi](Cow%20libi/) | [USACO 2023 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1303) | ✅ | Binary Search, Geometry, Sorting |
| [Cross Country Skiing](Cross%20Country%20Skiing/) | [USACO 2014 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=380) | ✅ | Binary Search on Answer, Flood Fill |
| [Cycle Correspondence](Cycle%20Correspondence/) | [USACO 2023 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1351) | ✅ | Hashing, Cyclic Shifts, Counting |
| [Dance Mooves](Dance%20Mooves/) | [USACO 2021 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1086) | ✅ | Permutation Cycles, Simulation, Sets |
| [Diamond Collector](DC/) | [USACO 2016 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=643) | ✅ | Two Pointers, Sorting, Suffix Maximum |
| [Diamond Collector](Diamond%20Collector/) | [USACO 2016 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=643) | ✅ | Two Pointers, Prefix/Suffix Maximum |
| [Do You Know Your ABCs?](Do%20You%20Know%20Your%20ABCs%20(Silver)/) | [USACO 2021 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1135) | ✅ | Complete Search, Sets |
| [Email Filing](Email%20Filing/) | [USACO 2022 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1208) | ✅ | Simulation, Priority Queue, Two Windows |
| [Fair Photography](Fair%20Photography/) | [USACO 2014 US Open Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=431) | ✅ | Prefix Sums, Hashing, Sorting |
| [Farmer John's Favorite Operation](Farmer%20Johns%20Favorite%20Operation/) | [USACO 2025 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1471) | ✅ | Sweep Line, Piecewise Linear Functions |
| [Fence Planning](Fence%20Planning/) | [USACO 2019 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=944) | ✅ | Connected Components, DFS |
| [Find and Replace](Find%20and%20Replace/) | [USACO 2023 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1278) | ✅ | Functional Graphs, Cycle Detection |
| [Goldilocks and the N Cows](Plant%20Growth/) | [USACO 2013 November Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=341) | ✅ | Sorting, Binary Search, Candidate Points |
| [Grass Planting](Grass%20Planting/) | [USACO 2019 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=894) | ✅ | Trees, Degree |
| [Haybale Stacking](Haybale%20Stacking/) | [USACO 2012 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=104) | ✅ | Difference Arrays, Sorting |
| [Haybale Stacking](RoboCow%20and%20StackTask/) | [USACO 2012 January Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=104) | ✅ | Difference Arrays, Sorting |
| [High Card Wins](High%20Card%20Wins/) | [USACO 2015 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=571) | ✅ | Greedy, Two Pointers, Sorting |
| [Hoof, Paper, Scissors](Hoof%20Paper%20Scissors%20Silver/) | [USACO 2017 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=691) | ✅ | Prefix Sums |
| [Icy Perimeter](Icy%20Perimeter/) | [USACO 2019 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=895) | ✅ | Flood Fill, DFS |
| [Learning by Example](Learning%20By%20Example/) | [USACO 2014 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=490) | ✅ | Sorting, Intervals, Math |
| [Left Out](Left%20Out/) | [USACO 2019 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=942) | ✅ | Grid, Case Analysis, Invariants |
| [Lemonade Line](Lemonade%20Line/) | [USACO 2018 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=835) | ✅ | Greedy, Priority Queue |
| [Lifeguards](Lifeguards/) | [USACO 2018 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=786) | ✅ | Sweep Line, Sorting |
| [Luxury River Cruise](Luxury%20River%20Cruise2/) | [USACO 2013 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=284) | ✅ | Functional Graphs, Simulation |
| [Maze Tac Toe](Maze%20Tac%20Toe/) | [USACO 2021 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1134) | ✅ | BFS over States, Bitmask/Base-3 Encoding |
| [Meetings](Meetings/) | [USACO 2019 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=967) | ✅ | Sorting, Two Pointers, Physics Trick |
| [Milk Measurement](Milk%20Measurement/) | [USACO 2017 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=763) | ✅ | Priority Queue, Hashing, Simulation |
| [Milk Pails](Milk%20Pails/) | [USACO 2016 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=620) | ✅ | BFS over States |
| [Milk Sum](MS/) | [USACO 2023 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1326) | ✅ | Sorting, Prefix Sums, Binary Search |
| [Milk Sum](Milk%20Sum/) | [USACO 2023 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1326) | ✅ | Sorting, Prefix Sums, Binary Search |
| [Milk Visits](Milk%20Visits/) | [USACO 2019 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=968) | ✅ | Disjoint Set Union, Trees |
| [MooBuzz](MB/) | [USACO 2019 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=966) | ✅ | Math, Periodicity |
| [Moocast](M/) | [USACO 2016 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=668) | ✅ | Graphs, DFS |
| [MooTube](Mootube/) | [USACO 2018 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=788) | ✅ | BFS, Trees |
| [Mooyo Mooyo](Mooyo%20Mooyo/) | [USACO 2018 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=860) | ✅ | Flood Fill, Simulation |
| [Multiplayer Moo](Multiplayer%20Moo/) | [USACO 2018 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=836) | ✅ | Flood Fill, BFS, Pruning |
| [Out of Sorts](Out%20of%20Sorts/) | [USACO 2018 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=834) | ✅ | Sorting, Bubble Sort Analysis |
| [Painting the Barn](Painting%20the%20Barn/) | [USACO 2019 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=919) | ✅ | 2D Difference Arrays, Prefix Sums |
| [Painting the Fence](Pencil%20Shades/) | [USACO 2013 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=226) | ✅ | Sweep Line, Difference Array on a TreeMap |
| [Paired Up](Paired%20Up/) | [USACO 2017 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=738) | ✅ | Greedy, Two Pointers, Sorting |
| [Range Reconstruction](RR/) | [USACO 2022 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1256) | ✅ | Constructive, Verification |
| [Rectangular Pasture](Rectangular%20Pasture/) | [USACO 2020 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1063) | ✅ | 2D Prefix Sums, Coordinate Compression, Counting |
| [Redistributing Gifts](Redistributing%20Gifts/) | [USACO 2022 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1206) | ✅ | Graph Reachability, DFS, Cycles |
| [Rental Service](Rental%20Service/) | [USACO 2018 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=787) | ✅ | Greedy, Prefix Sums, Sorting |
| [Robot Instructions](EV%20Tractor/) | [USACO 2022 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1207) | ✅ | Meet in the Middle, Bitmask Enumeration, Hashing |
| [Scrambled Letters](Mixed%20Up%20Names/) | [USACO 2012 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=206) | ✅ | Sorting, Binary Search, Strings |
| [Searching for Soulmates](Searching%20for%20Soulmates/) | [USACO 2022 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1182) | ✅ | Recursion, Greedy, Bit Manipulation |
| [Secret Cow Code](Secret%20Cow%20Code/) | [USACO 2017 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=692) | ✅ | Recursion, Divide and Conquer |
| [Ski Slope](Ski%20Slope%202/) | [USACO 2025 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1520) | ✅ | DFS, Offline Queries, TreeSet |
| [Sleepy Cow Herding](Sleepy%20Cow%20Herding/) | [USACO 2019 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=918) | ✅ | Sliding Window, Case Analysis |
| [Social Distancing](Social%20Distancing/) | [USACO 2020 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1038) | ✅ | Binary Search on Answer, Greedy |
| [Square Overlap](Tile%20Challenge/) | [USACO 2013 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=227) | ✅ | Sweep Line, TreeSet, Geometry |
| [Stuck in a Rut](Stuck%20in%20a%20Rut/) | [USACO 2020 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1064) | ✅ | Simulation, Sorting |
| [Subsequences Summing to Sevens](Subsequences%20Summing%20to%20Sevens/) | [USACO 2016 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=595) | ✅ | Prefix Sums, Modular Arithmetic |
| [Subset Equality](Subset%20Equality/) | [USACO 2022 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1231) | ✅ | Two Pointers, Strings |
| [Swapity Swapity Swap](Swapity%20Swapity%20Swap/) | [USACO 2020 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1014) | ✅ | Permutation Cycles, Simulation |
| [Switching on the Lights](Switching%20on%20the%20Lights2/) | [USACO 2015 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=570) | ✅ | BFS, Grid, Simulation |
| [Table Recovery](Table%20Recovery/) | [USACO 2025 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1472) | ✅ | Frequency Analysis, Constructive |
| [The Bovine Shuffle](The%20Bovine%20Shuffle/) | [USACO 2017 December Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=764) | ✅ | Functional Graphs, Cycle Detection |
| [The Great Revegetation](The%20Great%20Revegetation/) | [USACO 2019 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=920) | ✅ | Bipartite Checking, DFS, Connected Components |
| [The Lazy Cow](TLC3/) | [USACO 2014 March Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=416) | ✅ | Coordinate Rotation, 2D Prefix Sums |
| [The Lazy Cow](The%20Lazy%20Cow/) | [USACO 2014 March Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=416) | ✅ | Coordinate Rotation, 2D Prefix Sums |
| [Triangles](Triangles/) | [USACO 2020 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1015) | ✅ | Prefix Sums, Sorting, Counting |
| [Typo](Acron%20Bracelet/) | [USACO 2012 November Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=188) | ✅ | Bracket Sequences, Prefix Balance |
| [Visits](Visits/) | [USACO 2022 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1230) | ✅ | Functional Graphs, Cycle Detection |
| [Where's Bessie?](Spot%20the%20Cow/) | [USACO 2017 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=740) | ✅ | Complete Search, Flood Fill |
| [Where's Bessie?](Wheres%20Bessie/) | [USACO 2017 US Open Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=740) | ✅ | Complete Search, Flood Fill |
| [Why Did the Cow Cross the Road II](Why%20did%20the%20cow%20cross%20the%20road%20ii%20silver/) | [USACO 2017 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=715) | ✅ | Prefix Sums, Sliding Window |
| [Wormhole Sort](Wormhole%20Sort/) | [USACO 2020 January Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=992) | ✅ | Binary Search on Answer, Connected Components |
| [Wormholes](Particle%20Physics/) | [USACO 2013 December Contest, Bronze](https://usaco.org/index.php?page=viewproblem2&cpid=360) | ✅ | Backtracking, Complete Search, Cycle Detection |
| [Year of the Cow](Year%20of%20The%20Cow/) | [USACO 2021 February Contest, Silver](https://usaco.org/index.php?page=viewproblem2&cpid=1111) | ✅ | Greedy, Sorting |

### USACO Gold (3)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [Angry Cows](Angry%20Cows/) | [USACO 2016 January Contest, Gold](https://usaco.org/index.php?page=viewproblem2&cpid=597) | ✅ | Binary Search on Answer, Simulation, Sorting |
| [Moocast](Moocast/) | [USACO 2016 December Contest, Gold](https://usaco.org/index.php?page=viewproblem2&cpid=669) | ✅ | Binary Search on Answer, Graph Connectivity, DFS |
| [Splitting the Field](Splitting%20The%20Field/) | [USACO 2016 US Open Contest, Gold](https://usaco.org/index.php?page=viewproblem2&cpid=645) | ✅ | Prefix/Suffix Min/Max, Sorting |

### Codeforces (209)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [2-Letter Strings](2-Letter%20Strings/) | [Codeforces 1669E](https://codeforces.com/contest/1669/problem/E) | ✅ | Counting, Hashing by small alphabet |
| [A and B](A%20and/) | [Codeforces 1278B](https://codeforces.com/contest/1278/problem/B) | ✅ | Math, Parity |
| [A Leapfrog in the Array](Leapfrog%20in%20the%20Array/) | [Codeforces 949B](https://codeforces.com/contest/949/problem/B) | ✅ | Recursion, Math |
| [a-Good String](A-good%20String/) | [Codeforces 1385D](https://codeforces.com/contest/1385/problem/D) | ✅ | Divide and Conquer, Recursion |
| [A/B Matrix](AB%20Matrix/) | [Codeforces 1360G](https://codeforces.com/contest/1360/problem/G) | ✅ | Constructive, Cyclic Shift |
| [AB Balance](AB%20Balance/) | [Codeforces 1606A](https://codeforces.com/contest/1606/problem/A) | ✅ | Strings, Observation |
| [ABBC or BACB](ABBC%20or%20BACB/) | [Codeforces 1873G](https://codeforces.com/contest/1873/problem/G) | ✅ | Greedy, Strings |
| [Absolute Sorting](Absolute%20Sorting/) | [Codeforces 1772D](https://codeforces.com/contest/1772/problem/D) | ✅ | Math, Greedy |
| [Add or XOR](Add%20or%20XOR/) | [Codeforces 2119A](https://codeforces.com/contest/2119/problem/A) | ✅ | Math, Bit Manipulation, Greedy |
| [Add to Neighbour and Remove](Add%20to%20Neighbor%20and%20Remove/) | [Codeforces 1462D](https://codeforces.com/contest/1462/problem/D) | ✅ | Greedy, Divisors, Prefix Sums |
| [All are Same](All%20are%20Same/) | [Codeforces 1593D1](https://codeforces.com/contest/1593/problem/D1) | ✅ | GCD, Number Theory |
| [Almost All Multiples](Almost%20All%20Multiples/) | [Codeforces 1758C](https://codeforces.com/contest/1758/problem/C) | ✅ | Constructive, Permutations, Divisibility |
| [An impassioned circulation of affection](An%20impassioned%20circulation%20of%20affection/) | [Codeforces 814C](https://codeforces.com/contest/814/problem/C) | ✅ | Two Pointers, Sliding Window |
| [AND Sequences](And%20Sequences/) | [Codeforces 1513B](https://codeforces.com/contest/1513/problem/B) | ✅ | Bitwise AND, Combinatorics |
| [Array Craft](Array%20Craft/) | [Codeforces 1990B](https://codeforces.com/contest/1990/problem/B) | ✅ | Constructive, Prefix Sums |
| [Array Destruction](Array%20Destruction/) | [Codeforces 1474C](https://codeforces.com/contest/1474/problem/C) | ✅ | Greedy, Simulation, TreeMap / Multiset |
| [Arrow Path](Arrow%20Path/) | [Codeforces 1948C](https://codeforces.com/contest/1948/problem/C) | ✅ | Graph Search, DFS, Grid |
| [Badge](Badge/) | [Codeforces 1020B](https://codeforces.com/contest/1020/problem/B) | ✅ | Functional Graph, Floyd's Cycle Detection |
| [Balance the Bits](Balance%20the%20Bits/) | [Codeforces 1503A](https://codeforces.com/contest/1503/problem/A) | ✅ | Constructive, Bracket Sequences |
| [Bandit in a City](Bandit%20in%20a%20City/) | [Codeforces 1436D](https://codeforces.com/contest/1436/problem/D) | ✅ | Trees, DFS, Greedy |
| [Basic Diplomacy](Basic%20Diplomacy/) | [Codeforces 1482C](https://codeforces.com/contest/1482/problem/C) | ✅ | Greedy, Pigeonhole Principle |
| [Basketball Together](Basketball%20Together/) | [Codeforces 1725B](https://codeforces.com/contest/1725/problem/B) | ✅ | Greedy, Sorting |
| [Beautiful Array](Beautiful%20Array/) | [Codeforces 1986E](https://codeforces.com/contest/1986/problem/E) | ✅ | Greedy, Modular Arithmetic, Prefix/Suffix Sums |
| [Binary Strings are Fun](Binary%20Strings%20Are%20Fun/) | [Codeforces 1762C](https://codeforces.com/contest/1762/problem/C) | ✅ | Combinatorics, Modular Arithmetic |
| [Black and White Stripe](Black%20and%20White%20Stripe/) | [Codeforces 1690D](https://codeforces.com/contest/1690/problem/D) | ✅ | Prefix Sums, Sliding Window |
| [Black Cells](Black%20Cells/) | [Codeforces 1821D](https://codeforces.com/contest/1821/problem/D) | ✅ | Greedy, Prefix Scan |
| [Books](Books/) | [Codeforces 279B](https://codeforces.com/contest/279/problem/B) | ✅ | Two Pointers, Sliding Window |
| [Card Deck](Card%20deck/) | [Codeforces 1492B](https://codeforces.com/contest/1492/problem/B) | ✅ | Greedy, Permutations |
| [Carousel](Carousel/) | [Codeforces 1328D](https://codeforces.com/contest/1328/problem/D) | ✅ | Constructive, Case Analysis, Cycles |
| [Carrot Cakes](Carrot%20Cakes/) | [Codeforces 799A](https://codeforces.com/contest/799/problem/A) | ✅ | Simulation |
| [Cat Cycle](Cat%20Cycle/) | [Codeforces 1487B](https://codeforces.com/contest/1487/problem/B) | ✅ | Math, Modular Arithmetic |
| [Cellular Network](Cellular%20Network/) | [Codeforces 702C](https://codeforces.com/contest/702/problem/C) | ✅ | Binary Search, Sorting |
| [Challenging Cliffs](Challenging%20Cliffs/) | [Codeforces 1537C](https://codeforces.com/contest/1537/problem/C) | ✅ | Sorting, Constructive |
| [Cheap Travel](Cheap%20Travel/) | [Codeforces 466A](https://codeforces.com/contest/466/problem/A) | ✅ | Greedy, Math |
| [Chip and Ribbon](Chip%20and%20Ribbon/) | [Codeforces 1901B](https://codeforces.com/contest/1901/problem/B) | ✅ | Greedy, Difference Arrays |
| [Chladni Figure](CF/) | [Codeforces 1147B](https://codeforces.com/contest/1147/problem/B) | ✅ | Symmetry, Divisors, Hashing |
| [Clock Conversion](Clock%20Conversion/) | [Codeforces 1950C](https://codeforces.com/contest/1950/problem/C) | ✅ | Implementation, Strings |
| [Cobb](Cobb/) | [Codeforces 1554B](https://codeforces.com/contest/1554/problem/B) | ✅ | Math, Bounding, Brute Force |
| [Collecting Game](Collecting%20Game/) | [Codeforces 1904B](https://codeforces.com/contest/1904/problem/B) | ✅ | Sorting, Prefix Sums, Greedy |
| [Colorful Stamp](Colorful%20Stamp/) | [Codeforces 1669D](https://codeforces.com/contest/1669/problem/D) | ✅ | Strings, Observation |
| [Coloring](Coloring/) | [Codeforces 1774B](https://codeforces.com/contest/1774/problem/B) | ✅ | Pigeonhole Principle, Math |
| [Compressed Bracket Sequence](Compressed%20Bracket%20Sequence/) | [Codeforces 1556C](https://codeforces.com/contest/1556/problem/C) | ✅ | Bracket Sequences, Counting |
| [Computer Game](Computer%20Game/) | [Codeforces 1183C](https://codeforces.com/contest/1183/problem/C) | ✅ | Math, Inequalities |
| [Contrast Value](Contrast%20Value/) | [Codeforces 1832C](https://codeforces.com/contest/1832/problem/C) | ✅ | Greedy, Local Extrema |
| [Coprime](Coprime/) | [Codeforces 1742D](https://codeforces.com/contest/1742/problem/D) | ✅ | GCD, Brute Force over Values |
| [Count Subrectangles](Count%20Subrectangles/) | [Codeforces 1323B](https://codeforces.com/contest/1323/problem/B) | ✅ | 2D Prefix Sums, Divisors |
| [Cover it!](Cover%20it/) | [Codeforces 1176E](https://codeforces.com/contest/1176/problem/E) | ✅ | DFS, Graph Colouring, Spanning Tree |
| [Create The Teams](Create%20the%20Teams/) | [Codeforces 1380C](https://codeforces.com/contest/1380/problem/C) | ✅ | Greedy, Sorting |
| [Cut 'em all!](Cut%20%27em%20all/) | [Codeforces 982C](https://codeforces.com/contest/982/problem/C) | ✅ | Trees, DFS, Subtree Sizes |
| [Cutting Out](Cutting%20Out/) | [Codeforces 1077D](https://codeforces.com/contest/1077/problem/D) | ✅ | Binary Search on Answer, Frequency Counting |
| [Dances (Hard Version)](Dances%20Hard%20Version/) | [Codeforces 1883G2](https://codeforces.com/contest/1883/problem/G2) | ✅ | Binary Search, Greedy Matching, Sorting |
| [DBMB and the Array](DBMB%20and%20the%20Array/) | [Codeforces 2193A](https://codeforces.com/contest/2193/problem/A) | ✅ | Math |
| [Detective Task](Detective%20Task/) | [Codeforces 1675C](https://codeforces.com/contest/1675/problem/C) | ✅ | Observation, Strings |
| [Differential Sorting](Differential%20Sorting/) | [Codeforces 1635C](https://codeforces.com/contest/1635/problem/C) | ✅ | Constructive, Greedy |
| [Difficult Contest](Difficult%20Contest/) | [Codeforces 2125A](https://codeforces.com/contest/2125/problem/A) | ✅ | Constructive, Counting |
| [Diluc and Kaeya](Diluc%20and%20Kaeya/) | [Codeforces 1536C](https://codeforces.com/contest/1536/problem/C) | ✅ | GCD, Hashing, Prefix Counts |
| [Diverse Substrings](Diverse%20Substrings/) | [Codeforces 1748B](https://codeforces.com/contest/1748/problem/B) | ✅ | Brute Force with Bounded Length, Counting |
| [Divide and Equalize](Divide%20and%20Equalize/) | [Codeforces 1881D](https://codeforces.com/contest/1881/problem/D) | ✅ | Prime Factorization, Sieve, Number Theory |
| [Doremy's IQ](Doremys%20IQ/) | [Codeforces 1707A](https://codeforces.com/contest/1707/problem/A) | ✅ | Greedy, Reverse Thinking |
| [Dreamoon Likes Coloring](Dreamoon%20Likes%20Coloring/) | [Codeforces 1329A](https://codeforces.com/contest/1329/problem/A) | ✅ | Constructive, Greedy, Suffix Sums |
| [Dual (Easy Version)](Dual/) | [Codeforces 1854A1](https://codeforces.com/contest/1854/problem/A1) | ✅ | Constructive |
| [Eating Candies](Eating%20Candies/) | [Codeforces 1669F](https://codeforces.com/contest/1669/problem/F) | ✅ | Two Pointers |
| [Equalize](Equalize/) | [Codeforces 1928B](https://codeforces.com/contest/1928/problem/B) | ✅ | Two Pointers, Sorting |
| [Factorial Divisibility](Factorial%20Divisibility/) | [Codeforces 1753B](https://codeforces.com/contest/1753/problem/B) | ✅ | Math, Carrying |
| [Fight with Monsters](Fight%20With%20Monsters/) | [Codeforces 1296D](https://codeforces.com/contest/1296/problem/D) | ✅ | Greedy, Sorting, Math |
| [Floor and Mod](Floor%20Mod/) | [Codeforces 1485C](https://codeforces.com/contest/1485/problem/C) | ✅ | Number Theory, Math |
| [Game with Marbles (Hard Version)](Game%20with%20Marbles/) | [Codeforces 1914E2](https://codeforces.com/contest/1914/problem/E2) | ✅ | Game Theory, Greedy, Sorting |
| [Game with Multiset](Game%20with%20multiset/) | [Codeforces 1913C](https://codeforces.com/contest/1913/problem/C) | ✅ | Greedy, Bit Manipulation |
| [GCD Length](GCD%20Length/) | [Codeforces 1511B](https://codeforces.com/contest/1511/problem/B) | ✅ | Constructive, GCD |
| [GCD Partition](GCD%20Partition/) | [Codeforces 1780B](https://codeforces.com/contest/1780/problem/B) | ✅ | GCD, Prefix Sums |
| [Getting Zero](Getting%20Zero/) | [Codeforces 1661B](https://codeforces.com/contest/1661/problem/B) | ✅ | Brute Force, Bit Manipulation |
| [Good Subarrays](Good%20Subarrays/) | [Codeforces 1398C](https://codeforces.com/contest/1398/problem/C) | ✅ | Prefix Sums, Hashing |
| [Good Subarrays (Easy Version)](Good%20Subarrays%20(easy%20version)/) | [Codeforces 1736C1](https://codeforces.com/contest/1736/problem/C1) | ✅ | Two Pointers, Counting |
| [Grandma Capa Knits a Scarf](Grandma%20Capa%20Knits%20a%20Scarf/) | [Codeforces 1582C](https://codeforces.com/contest/1582/problem/C) | ✅ | Two Pointers, Palindromes, Strings |
| [Graph Composition](Graph%20Composition/) | [Codeforces 2060E](https://codeforces.com/contest/2060/problem/E) | ✅ | Disjoint Set Union, Connectivity |
| [Greg and Array](Greg%20and%20Array/) | [Codeforces 295A](https://codeforces.com/contest/295/problem/A) | ✅ | Difference Arrays, Prefix Sums |
| [Guess the K-th Zero (Easy version)](Guess%20the%20Kth%20Zero/) | [Codeforces 1520F1](https://codeforces.com/contest/1520/problem/F1) | ⚪ | Binary Search, Interactive |
| [Hacker, pack your bags!](Hacker%20Pack%20Your%20Bags/) | [Codeforces 822C](https://codeforces.com/contest/822/problem/C) | ✅ | Sweep Line, Sorting, Greedy |
| [Haunted House](Haunted%20House/) | [Codeforces 1884B](https://codeforces.com/contest/1884/problem/B) | ✅ | Greedy, Two Pointers |
| [Helpful Maths](Helpful%20maths/) | [Codeforces 339A](https://codeforces.com/contest/339/problem/A) | ✅ | Sorting, Strings |
| [Hills And Valleys](Hills%20and%20Valleys/) | [Codeforces 1467B](https://codeforces.com/contest/1467/problem/B) | ✅ | Greedy, Local Analysis |
| [Inhabitant of the Deep Sea](Inhabitant%20of%20the%20Deep%20Sea/) | [Codeforces 1955C](https://codeforces.com/contest/1955/problem/C) | ✅ | Two Pointers, Simulation |
| [Insert and Equalize](Insert%20and%20Equalize/) | [Codeforces 1902C](https://codeforces.com/contest/1902/problem/C) | ✅ | GCD, Greedy, Sorting |
| [Interesting Story](Interesting%20Storu/) | [Codeforces 1551C](https://codeforces.com/contest/1551/problem/C) | ✅ | Greedy, Sorting |
| [Irreducible Anagrams](Irreduicible%20Anagrams/) | [Codeforces 1291D](https://codeforces.com/contest/1291/problem/D) | ✅ | Prefix Sums, Strings, Case Analysis |
| [Johnny and Contribution](Johnny%20and%20Contribution/) | [Codeforces 1361A](https://codeforces.com/contest/1361/problem/A) | ✅ | Greedy, Graphs, Sorting |
| [Jumps](Jumps/) | [Codeforces 1455B](https://codeforces.com/contest/1455/problem/B) | ✅ | Math, Greedy |
| [k-LCM (hard version)](K-LCM%20(Hard%20Version)/) | [Codeforces 1497C2](https://codeforces.com/contest/1497/problem/C2) | ✅ | Constructive, Number Theory |
| [Karen and Coffee](Karen%20and%20Coffee/) | [Codeforces 816B](https://codeforces.com/contest/816/problem/B) | ✅ | Difference Arrays, Prefix Sums |
| [Kevin and Combination Lock](Kevin%20and%20combination%20Lock/) | [Codeforces 2048A](https://codeforces.com/contest/2048/problem/A) | ✅ | Math, Modular Arithmetic |
| [Koxia and Number Theory](Koxia%20and%20NT/) | [Codeforces 1770C](https://codeforces.com/contest/1770/problem/C) | ✅ | Number Theory, Pigeonhole Principle |
| [Labyrinth](Labyrinth/) | [Codeforces 1063B](https://codeforces.com/contest/1063/problem/B) | ✅ | 0-1 BFS, Grid Graphs |
| [Large Addition](Large%20Addition/) | [Codeforces 1984B](https://codeforces.com/contest/1984/problem/B) | ✅ | Math, Digits |
| [Left and Down](Left%20and%20Down/) | [Codeforces 2125B](https://codeforces.com/contest/2125/problem/B) | ✅ | GCD, Divisors |
| [Little Girl and Maximum Sum](Little%20Girl%20and%20Max%20Sum/) | [Codeforces 276C](https://codeforces.com/contest/276/problem/C) | ✅ | Difference Arrays, Greedy, Sorting |
| [Long Legs](Long%20Legs/) | [Codeforces 1814B](https://codeforces.com/contest/1814/problem/B) | ✅ | Brute Force, Math |
| [Luntik and Subsequences](Lutnik%20and%20Subsequences/) | [Codeforces 1582B](https://codeforces.com/contest/1582/problem/B) | ✅ | Combinatorics, Counting |
| [Mad MAD Sum](Mad%20Sum/) | [Codeforces 1990C](https://codeforces.com/contest/1990/problem/C) | ✅ | Observation, Simulation |
| [Magic Ship](Magic%20Ship/) | [Codeforces 1117C](https://codeforces.com/contest/1117/problem/C) | ✅ | Binary Search on Answer, Prefix Sums |
| [Magic Triples (Easy Version)](Magic%20Triples/) | [Codeforces 1822G1](https://codeforces.com/contest/1822/problem/G1) | ✅ | Counting, Frequency Arrays, Math |
| [Mahmoud and Ehab and the bipartiteness](Bipartiteness/) | [Codeforces 862B](https://codeforces.com/contest/862/problem/B) | ✅ | Trees, Bipartite Graphs, DFS |
| [Mahmoud and Ehab and the function](Mahmoud%20and%20Ehab%20and%20Function/) | [Codeforces 862E](https://codeforces.com/contest/862/problem/E) | ✅ | Alternating Sums, TreeSet, Binary Search |
| [Make It Equal](Make%20it%20Equal/) | [Codeforces 1065C](https://codeforces.com/contest/1065/problem/C) | ✅ | Suffix Sums, Greedy |
| [Manipulating History](Manipulating%20History/) | [Codeforces 1688C](https://codeforces.com/contest/1688/problem/C) | ✅ | Parity, Counting |
| [Matryoshkas](Matryoshkas/) | [Codeforces 1790D](https://codeforces.com/contest/1790/problem/D) | ✅ | Greedy, Counting, TreeSet |
| [Max Median](Max%20Median/) | [Codeforces 1486D](https://codeforces.com/contest/1486/problem/D) | ✅ | Binary Search on Answer, Prefix Sums |
| [Maximal Binary Matrix](Maximal%20Binary%20Matrix/) | [Codeforces 803A](https://codeforces.com/contest/803/problem/A) | ✅ | Greedy, Constructive |
| [Maximum Median](Maximum%20Median/) | [Codeforces 1201C](https://codeforces.com/contest/1201/problem/C) | ✅ | Binary Search on Answer, Sorting, Greedy |
| [MEX vs MED](MEX%20vs%20MED/) | [Codeforces 1744F](https://codeforces.com/contest/1744/problem/F) | ✅ | Two Pointers, Permutations, Counting |
| [Micro-World](Micro%20World/) | [Codeforces 990B](https://codeforces.com/contest/990/problem/B) | ✅ | Greedy, Sorting |
| [Min Max MEX](min%20max%20mex/) | [Codeforces 2093E](https://codeforces.com/contest/2093/problem/E) | ✅ | Binary Search on Answer, Greedy, MEX |
| [Minimize Inversions](Minimize%20Inversions/) | [Codeforces 1918B](https://codeforces.com/contest/1918/problem/B) | ✅ | Sorting, Greedy |
| [Minimum LCM](Min%20LCM/) | [Codeforces 1765M](https://codeforces.com/contest/1765/problem/M) | ✅ | Number Theory, Divisors |
| [Monoblock](Monoblock/) | [Codeforces 1715C](https://codeforces.com/contest/1715/problem/C) | ✅ | Contribution Technique, Counting |
| [Monster Game](Monster%20Game/) | [Codeforces 2193D](https://codeforces.com/contest/2193/problem/D) | ✅ | Sorting, Prefix Sums, Binary Search |
| [Most Similar Words](Most%20Similar%20Words/) | [Codeforces 1676C](https://codeforces.com/contest/1676/problem/C) | ✅ | Brute Force, Strings |
| [Mr. Kitayuta's Colorful Graph](Mr.Kitayuta%27s%20Colorful%20Graph/) | [Codeforces 505B](https://codeforces.com/contest/505/problem/B) | ✅ | DFS, Graph Connectivity |
| [New Building for SIS](New%20Building%20for%20SIS/) | [Codeforces 1020A](https://codeforces.com/contest/1020/problem/A) | ✅ | Math, Case Analysis |
| [NIT Destroys the Universe](NIT%20Destroys%20the%20Universe/) | [Codeforces 1696B](https://codeforces.com/contest/1696/problem/B) | ✅ | MEX, Case Analysis |
| [No Casino in the Mountains](No%20Casino%20in%20the%20Mountains/) | [Codeforces 2126B](https://codeforces.com/contest/2126/problem/B) | ✅ | Greedy |
| [No Prime Differences](No%20Prime%20Differences/) | [Codeforces 1838C](https://codeforces.com/contest/1838/problem/C) | ✅ | Constructive, Number Theory |
| [Number Factorization](Number%20Factorization/) | [Codeforces 1787B](https://codeforces.com/contest/1787/problem/B) | ✅ | Prime Factorization, Greedy |
| [Number Game](Number%20Game/) | [Codeforces 1370C](https://codeforces.com/contest/1370/problem/C) | ✅ | Game Theory, Number Theory |
| [Numbers Exchange](Numbers%20Exchange/) | [Codeforces 746E](https://codeforces.com/contest/746/problem/E) | ✅ | Greedy, Hashing, Parity |
| [Odd/Even Increments](Odd%20and%20Even%20Increments/) | [Codeforces 1669C](https://codeforces.com/contest/1669/problem/C) | ✅ | Parity, Observation |
| [Only One Digit](Only%20One%20Digit/) | [Codeforces 2126A](https://codeforces.com/contest/2126/problem/A) | ✅ | Implementation |
| [OutOfMemoryError](Out%20of%20Memory%20Error/) | [Codeforces 2185D](https://codeforces.com/contest/2185/problem/D) | ✅ | Lazy Reset, Timestamps |
| [Paint the Array](Paint%20the%20Array/) | [Codeforces 1618C](https://codeforces.com/contest/1618/problem/C) | ✅ | GCD, Divisors |
| [Painting the Fence](Painting%20the%20Fence/) | [Codeforces 1132C](https://codeforces.com/contest/1132/problem/C) | ✅ | Difference Arrays, Prefix Sums |
| [Palindromes Coloring](Palindrome%20Coloring/) | [Codeforces 1624D](https://codeforces.com/contest/1624/problem/D) | ✅ | Greedy, Counting, Palindromes |
| [Palindromic Paths](Palindromic%20Paths/) | [Codeforces 1366C](https://codeforces.com/contest/1366/problem/C) | ✅ | Grid, Palindromes, Greedy |
| [Perfect Root](Perfect%20Root/) | [Codeforces 2185A](https://codeforces.com/contest/2185/problem/A) | ✅ | Observation, Constructive |
| [Perform Operations to Maximize Score](Perform%20Operations%20to%20Maximize%20Score/) | [Codeforces 1998C](https://codeforces.com/contest/1998/problem/C) | ✅ | Binary Search on Answer, Greedy, Case Analysis |
| [Perform the Combo](Perform%20the%20Combo/) | [Codeforces 1311C](https://codeforces.com/contest/1311/problem/C) | ✅ | Sorting, Prefix Counting |
| [Permutation Operations](Permutation%20Operations/) | [Codeforces 1746C](https://codeforces.com/contest/1746/problem/C) | ✅ | Constructive, Permutations |
| [Permutation Sort](Permutation%20sort/) | [Codeforces 1525B](https://codeforces.com/contest/1525/problem/B) | ✅ | Case Analysis, Permutations |
| [Playing in a Casino](Playing%20in%20a%20Casino/) | [Codeforces 1808B](https://codeforces.com/contest/1808/problem/B) | ✅ | Sorting, Prefix Sums, Contribution Technique |
| [Playing with GCD](Playing%20with%20GCD/) | [Codeforces 1736B](https://codeforces.com/contest/1736/problem/B) | ✅ | GCD, LCM |
| [Power of Points](Power%20of%20Points/) | [Codeforces 1857E](https://codeforces.com/contest/1857/problem/E) | ✅ | Sorting, Prefix Sums, Sweep |
| [Powered Addition](Powered%20Addition/) | [Codeforces 1338A](https://codeforces.com/contest/1338/problem/A) | ✅ | Bit Manipulation, Greedy |
| [Prefix Max](Prefix%20Max/) | [Codeforces 2185B](https://codeforces.com/contest/2185/problem/B) | ✅ | Observation, Greedy |
| [Preparing for Merge Sort](Preparing%20for%20Merge%20Sor/) | [Codeforces 847B](https://codeforces.com/contest/847/problem/B) | ✅ | Binary Search, Greedy, Simulation |
| [Product of Binary Decimals](Binary%20Decimals/) | [Codeforces 1950D](https://codeforces.com/contest/1950/problem/D) | ✅ | Math, Number Theory |
| [Product of Three Numbers](Product%20of%203%20Numbers/) | [Codeforces 1294C](https://codeforces.com/contest/1294/problem/C) | ✅ | Number Theory, Divisors |
| [QED's Favorite Permutation](QED%27s%20Favorite%20Permutation/) | [Codeforces 2030D](https://codeforces.com/contest/2030/problem/D) | ✅ | Difference Arrays, Sets |
| [Quiz Master](Quiz%20Master/) | [Codeforces 1777C](https://codeforces.com/contest/1777/problem/C) | ✅ | Two Pointers, Divisors, Sliding Window |
| [Range and Partition](Range%20and%20Partition/) | [Codeforces 1630B](https://codeforces.com/contest/1630/problem/B) | ✅ | Sorting, Sliding Window, Greedy |
| [Range Sorting (Easy Version)](Range%20Sorting%20Easy%20Version/) | [Codeforces 1827B1](https://codeforces.com/contest/1827/problem/B1) | ✅ | Monotonic Stack, Brute Force over Subarrays |
| [Range Update Point Query](Range%20Update%20Point%20Query/) | [Codeforces 1791F](https://codeforces.com/contest/1791/problem/F) | ✅ | TreeSet, Amortized Analysis |
| [RationalLee](RationalLee/) | [Codeforces 1369C](https://codeforces.com/contest/1369/problem/C) | ✅ | Greedy, Sorting |
| [Recommendations](Recommendations/) | [Codeforces 1310A](https://codeforces.com/contest/1310/problem/A) | ✅ | Greedy, Priority Queue, Sweep |
| [Recursive Queries](Recursive%20Queries/) | [Codeforces 932B](https://codeforces.com/contest/932/problem/B) | ✅ | Prefix Sums, Digit Manipulation |
| [Red and Blue](Red%20and%20Blue/) | [Codeforces 1469B](https://codeforces.com/contest/1469/problem/B) | ✅ | Prefix Sums, Greedy |
| [Replace and Sum](Replace%20and%20Sum/) | [Codeforces 2193C](https://codeforces.com/contest/2193/problem/C) | ✅ | Suffix Maximum, Prefix Sums |
| [Reverse a Permutation](Reverse%20a%20Permutation/) | [Codeforces 2193B](https://codeforces.com/contest/2193/problem/B) | ✅ | Greedy, Permutations |
| [Robot on the Board 1](Robot%20on%20the%20Board%201/) | [Codeforces 1607E](https://codeforces.com/contest/1607/problem/E) | ✅ | Simulation, Bounding Box |
| [Round Dance](Round%20Dance/) | [Codeforces 1833E](https://codeforces.com/contest/1833/problem/E) | ✅ | Connected Components, DFS |
| [Running for Gold](Running%20for%20Gold/) | [Codeforces 1552B](https://codeforces.com/contest/1552/problem/B) | ✅ | Tournament Elimination, Greedy |
| [Running Miles](Running%20Miles/) | [Codeforces 1826D](https://codeforces.com/contest/1826/problem/D) | ✅ | Prefix/Suffix Maximum |
| [Same Parity Summands](Same%20Parity%20Summands/) | [Codeforces 1352B](https://codeforces.com/contest/1352/problem/B) | ✅ | Constructive, Parity |
| [Save More Mice](Save%20More%20Mice/) | [Codeforces 1593C](https://codeforces.com/contest/1593/problem/C) | ✅ | Greedy, Sorting |
| [Scenes From a Memory](Scenes%20from%20a%20Memory/) | [Codeforces 1562B](https://codeforces.com/contest/1562/problem/B) | ✅ | Number Theory, Brute Force |
| [Scoring Subsequences](Scoring%20Subsequences/) | [Codeforces 1794C](https://codeforces.com/contest/1794/problem/C) | ✅ | Two Pointers, Monotonicity |
| [Sequence Master](Sequence%20Master/) | [Codeforces 1806C](https://codeforces.com/contest/1806/problem/C) | ✅ | Math, Case Analysis |
| [Sequence Pair Weight](Sequence%20Pair%20Weight/) | [Codeforces 1527C](https://codeforces.com/contest/1527/problem/C) | ✅ | Contribution Technique, Hashing |
| [Sequence with Digits](Sequence%20with%20Digits/) | [Codeforces 1355A](https://codeforces.com/contest/1355/problem/A) | ✅ | Simulation, Observation |
| [Set or Decrease](Set%20or%20Decrease/) | [Codeforces 1622C](https://codeforces.com/contest/1622/problem/C) | ✅ | Greedy, Sorting, Prefix Sums |
| [Shifted MEX](Shifted%20Mex/) | [Codeforces 2185C](https://codeforces.com/contest/2185/problem/C) | ✅ | Sorting, Observation |
| [SlavicG's Favorite Problem](Slavic%20G%27s%20Fav%20Problem/) | [Codeforces 1760G](https://codeforces.com/contest/1760/problem/G) | ✅ | DFS, XOR, Hashing |
| [Solve The Maze](Solve%20the%20Maze/) | [Codeforces 1365D](https://codeforces.com/contest/1365/problem/D) | ✅ | Flood Fill, Greedy, Grid |
| [Squares and Cubes](Squares%20and%20Cubes/) | [Codeforces 1619B](https://codeforces.com/contest/1619/problem/B) | ✅ | Math, Hashing |
| [Stone Age Problem](Stone%20Age%20Problem/) | [Codeforces 1679B](https://codeforces.com/contest/1679/problem/B) | ✅ | Lazy Updates, Timestamps |
| [Strange Partition](Strange%20Partition/) | [Codeforces 1471A](https://codeforces.com/contest/1471/problem/A) | ✅ | Math, Ceiling Division |
| [String Transformation 1](String%20Transformation%201/) | [Codeforces 1383A](https://codeforces.com/contest/1383/problem/A) | ✅ | Graphs, Connected Components, Greedy |
| [Suit and Tie](Suit%20%26%20Tie/) | [Codeforces 995B](https://codeforces.com/contest/995/problem/B) | ✅ | Greedy, Adjacent Swaps |
| [Sum of Nestings](Sum%20of%20Nestings/) | [Codeforces 847C](https://codeforces.com/contest/847/problem/C) | ✅ | Constructive, Bracket Sequences |
| [Sum of Substrings](Sum%20of%20Substrings/) | [Codeforces 1691C](https://codeforces.com/contest/1691/problem/C) | ✅ | Greedy, Strings |
| [Summarize to the Power of Two](Summarize%20to%20the%20Power%20of%20Two/) | [Codeforces 1005C](https://codeforces.com/contest/1005/problem/C) | ✅ | Hashing, Powers of Two |
| [Super-Permutation](Super%20Permutation/) | [Codeforces 1822D](https://codeforces.com/contest/1822/problem/D) | ✅ | Constructive, Modular Arithmetic |
| [Swap and Delete](Swap%20and%20Delete/) | [Codeforces 1913B](https://codeforces.com/contest/1913/problem/B) | ✅ | Greedy, Counting |
| [T-shirt buying](Tshirt%20buying/) | [Codeforces 799B](https://codeforces.com/contest/799/problem/B) | ✅ | Sorting, Pointers, Hashing |
| [The BOSS Can Count Pairs](The%20Boss%20can%20Count%20Pairs/) | [Codeforces 1830B](https://codeforces.com/contest/1830/problem/B) | ✅ | Math, Square-root Bound, Counting |
| [The Enchanted Forest](The%20Enchanted%20Forest/) | [Codeforces 1687A](https://codeforces.com/contest/1687/problem/A) | ✅ | Prefix Sums, Sliding Window, Math |
| [The Party and Sweets](The%20Party%20%26%20Sweets/) | [Codeforces 1158A](https://codeforces.com/contest/1158/problem/A) | ✅ | Greedy, Math |
| [The Party and Sweets](The%20Party%20and%20Sweets/) | [Codeforces 1158A](https://codeforces.com/contest/1158/problem/A) | ✅ | Greedy, Math |
| [The Third Letter](The%20Third%20Letter/) | [Codeforces 1850H](https://codeforces.com/contest/1850/problem/H) | ✅ | Weighted Graphs, DFS, Consistency Checking |
| [The Tower is Going Home](The%20Tower%20is%20Going%20Home/) | [Codeforces 1044A](https://codeforces.com/contest/1044/problem/A) | ✅ | Sorting, Two Pointers, Greedy |
| [They Are Everywhere](They%20are%20everywhere/) | [Codeforces 701C](https://codeforces.com/contest/701/problem/C) | ✅ | Sliding Window, Two Pointers |
| [This Is the Last Time](This%20Is%20the%20Last%20Time/) | [Codeforces 2126D](https://codeforces.com/contest/2126/problem/D) | ✅ | Greedy, Simulation |
| [Three Activities](Three%20Activities/) | [Codeforces 1914D](https://codeforces.com/contest/1914/problem/D) | ✅ | Greedy, Brute Force over Candidates |
| [Trailing Loves (or L'oeufs?)](Trailing%20Loves/) | [Codeforces 1114C](https://codeforces.com/contest/1114/problem/C) | ✅ | Legendre's Formula, Prime Factorization |
| [Tree Infection](Tree%20Infection/) | [Codeforces 1665C](https://codeforces.com/contest/1665/problem/C) | ✅ | Greedy, Simulation, Sorting |
| [Unique Palindromes](Unique%20Palindromes/) | [Codeforces 1823D](https://codeforces.com/contest/1823/problem/D) | ✅ | Constructive, Palindromes, Strings |
| [Update Queries](Update%20Queries/) | [Codeforces 1986C](https://codeforces.com/contest/1986/problem/C) | ✅ | Greedy, Sorting |
| [USB vs. PS/2](USB%20vs%20PS2/) | [Codeforces 762B](https://codeforces.com/contest/762/problem/B) | ✅ | Greedy, Sorting |
| [Valid BFS?](Valid%20BFS/) | [Codeforces 1037D](https://codeforces.com/contest/1037/problem/D) | ✅ | BFS, Simulation |
| [Vanya and Lanterns](Vanya%20and%20Lanterns/) | [Codeforces 492B](https://codeforces.com/contest/492/problem/B) | ✅ | Sorting, Greedy |
| [Vasya and Robot](Vasya%20and%20Robot/) | [Codeforces 1073C](https://codeforces.com/contest/1073/problem/C) | ✅ | Binary Search on Answer, Sliding Window |
| [Vertical Paths](Vertical%20Paths/) | [Codeforces 1675D](https://codeforces.com/contest/1675/problem/D) | ✅ | Trees, Greedy |
| [Vus the Cossack and Strings](Vus%20the%20Cossack%20And%20Strings/) | [Codeforces 1186C](https://codeforces.com/contest/1186/problem/C) | ✅ | Prefix Sums, Parity |
| [Wizard's Tour](Wizards%20Tour/) | [Codeforces 860D](https://codeforces.com/contest/860/problem/D) | ✅ | DFS, Edge Pairing, Constructive |
| [Wrong Addition](Wrong%20Addition/) | [Codeforces 1619C](https://codeforces.com/contest/1619/problem/C) | ✅ | Digits, Simulation |
| [X-Sum](X-Sum/) | [Codeforces 1676D](https://codeforces.com/contest/1676/problem/D) | ✅ | Brute Force, Grid |
| [XOR Specia-LIS-t](XOR%20Specia-LISt/) | [Codeforces 1604B](https://codeforces.com/contest/1604/problem/B) | ✅ | Constructive, Parity, XOR |
| [Yes or Yes](Yes%20or%20Yes/) | [Codeforces 2178A](https://codeforces.com/contest/2178/problem/A) | ✅ | Invariants, Counting |
| [Yet Another Card Deck](Yet%20Another%20Card%20Deck/) | [Codeforces 1511C](https://codeforces.com/contest/1511/problem/C) | ✅ | Simulation |
| [Yet Another Tournament](Yet%20another%20tournament/) | [Codeforces 1783C](https://codeforces.com/contest/1783/problem/C) | ✅ | Greedy, Sorting |
| [Zero-One (Easy Version)](Zero-One/) | [Codeforces 1733D1](https://codeforces.com/contest/1733/problem/D1) | ✅ | Greedy, Case Analysis |
| [Zigzags](Zigzags/) | [Codeforces 1400D](https://codeforces.com/contest/1400/problem/D) | ✅ | Counting, Prefix Frequencies |

### CSES (23)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [Array Division](Array%20Division/) | [CSES Problem Set](https://cses.fi/problemset/task/1085) | ⚪ | Binary Search on Answer, Greedy |
| [Bit Inversions](Bit%20Inversions/) | [CSES Problem Set](https://cses.fi/problemset/task/1188) | ⚪ | TreeSet, Ordered Multiset |
| [Chessboard and Queens](Chessboard%20And%20Queens/) | [CSES Problem Set](https://cses.fi/problemset/task/1624) | ⚪ | Complete Search, Permutations, Backtracking |
| [Concert Tickets](CT/) | [CSES Problem Set](https://cses.fi/problemset/task/1091) | ⚪ | TreeMap, Multiset, Greedy |
| [Concert Tickets](Concert%20Tickets/) | [CSES Problem Set](https://cses.fi/problemset/task/1091) | ⚪ | TreeMap, Multiset, Greedy |
| [Counting Rooms](Counting%20Rooms/) | [CSES Problem Set](https://cses.fi/problemset/task/1192) | ⚪ | Flood Fill, DFS |
| [Distinct Numbers](Distinct%20Numbers/) | [CSES Problem Set](https://cses.fi/problemset/task/1621) | ⚪ | Hashing, Sets |
| [Factory Machines](Factory%20Machines/) | [CSES Problem Set](https://cses.fi/problemset/task/1620) | ⚪ | Binary Search on Answer |
| [Flight Routes Check](Flight%20Routes%20Check/) | [CSES Problem Set](https://cses.fi/problemset/task/1682) | ⚪ | Strong Connectivity, DFS, Reverse Graph |
| [Forest Queries](Forest%20Queries/) | [CSES Problem Set](https://cses.fi/problemset/task/1652) | ⚪ | 2D Prefix Sums |
| [Maximum Subarray Sum](Maximum%20Subarray/) | [CSES Problem Set](https://cses.fi/problemset/task/1643) | ⚪ | Kadane's Algorithm, Dynamic Programming |
| [Message Route](Message%20Route/) | [CSES Problem Set](https://cses.fi/problemset/task/1667) | ⚪ | BFS, Path Reconstruction |
| [Movie Festival II](Movie%20Festival%20II/) | [CSES Problem Set](https://cses.fi/problemset/task/1632) | ⚪ | Greedy, Sorting, TreeMap Multiset |
| [Room Allocation](Room%20Allocation/) | [CSES Problem Set](https://cses.fi/problemset/task/1164) | ⚪ | Greedy, Priority Queue, Interval Scheduling |
| [Stick Divisions](Stick%20Division/) | [CSES Problem Set](https://cses.fi/problemset/task/1161) | ⚪ | Greedy, Priority Queue, Huffman Coding |
| [Subarray Divisibility](Subarray%20Divisibilty/) | [CSES Problem Set](https://cses.fi/problemset/task/1662) | ⚪ | Prefix Sums, Modular Arithmetic, Counting |
| [Subarray Sums I](Subarray%20Sums%20I/) | [CSES Problem Set](https://cses.fi/problemset/task/1660) | ⚪ | Two Pointers, Sliding Window |
| [Subarray Sums II](Subarray%20Sums%20II/) | [CSES Problem Set](https://cses.fi/problemset/task/1661) | ⚪ | Prefix Sums, Hashing |
| [Subordinates](Subordinates/) | [CSES Problem Set](https://cses.fi/problemset/task/1674) | ⚪ | Trees, DFS, Subtree Size |
| [Sum of Three Values](Sum%20of%203%20Values/) | [CSES Problem Set](https://cses.fi/problemset/task/1641) | ⚪ | Two Pointers, Sorting |
| [Sum of Two Values](Sum%20of%202%20Values/) | [CSES Problem Set](https://cses.fi/problemset/task/1640) | ⚪ | Two Pointers, Sorting |
| [Tree Distances I](Tree%20Distances%201/) | [CSES Problem Set](https://cses.fi/problemset/task/1132) | ⚪ | Tree Diameter, DFS |
| [Tree Distances II](Tree%20Distances%202/) | [CSES Problem Set](https://cses.fi/problemset/task/1133) | ⚪ | Rerooting DP, Subtree Sizes |

### Other judges (13)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [A Huge Tower](A%20Huge%20Tower/) | [CEOI 2010](https://oj.uz/problem/view/CEOI10_tower) | ⚪ | Sorting, Two Pointers, Combinatorics |
| [Art Exhibition](Art%20Exhibition/) | [JOI 2018 Final Round (Japanese Olympiad in Informatics)](https://oj.uz/problem/view/JOI18_art) | ⚪ | Sorting, Two Pointers |
| [Barnscape Outline](Barnscape%20Outline/) | [USACO 2005 November Contest, Silver](http://poj.org/problem?id=3044) | ⚪ | Monotonic Stack, Greedy |
| [Count Descendants](Count%20Descendants/) | [AtCoder ABC202 E](https://atcoder.jp/contests/abc202/tasks/abc202_e) | ⚪ | Euler Tour, Binary Search, Trees |
| [Find Center of Star Graph](Find%20Center%20of%20Star%20Graph/) | [LeetCode 1791](https://leetcode.com/problems/find-center-of-star-graph/) | ⚪ | Graphs, Degree Counting |
| [GCD on a Blackboard](GCD%20on%20a%20Blackboard/) | [AtCoder ABC125 C](https://atcoder.jp/contests/abc125/tasks/abc125_c) | ⚪ | Prefix/Suffix GCD |
| [Growing Vegetables is Fun](Growing%20Vegetables%20is%20Fun/) | [JOI 2021 Final Round (Japanese Olympiad in Informatics), Problem 1](https://oj.uz/problem/view/JOI21_ho_t1) | ⚪ | Prefix Sums, Greedy |
| [Map of Sweeden](Map%20of%20Sweeden/) | [Kattis](https://open.kattis.com/problems/sverigekartan) | ⚪ | Flood Fill, Incremental Connectivity |
| [Maximal Network Rank](Maximal%20Network%20Rank/) | [LeetCode 1615](https://leetcode.com/problems/maximal-network-rank/) | ⚪ | Graphs, Degree Counting |
| [Minimize the Diameter](Minimize%20the%20Diameter/) | [Codeforces Gym 104536, problem F](https://codeforces.com/gym/104536/problem/F) | ⚪ | Tree Diameter, DFS |
| [Nusret Gokce](Nusret%20Gokce/) | [Codeforces Gym 104114, problem N](https://codeforces.com/gym/104114/problem/N) | ⚪ | Greedy, Two-Pass Relaxation |
| [Studying Algorithms](Studying%20Algorithms/) | [Codeforces Gym 102951, problem B](https://codeforces.com/gym/102951/problem/B) | ⚪ | Greedy, Sorting |
| [Twenty Four](Twenty%20Four/) | [Canadian Computing Competition 2008 Senior, Problem 4 (Twenty Four)](https://dmoj.ca/problem/ccc08s4) | ⚪ | Complete Search, Recursion, Permutations |

### Practice & unlisted (13)

| Problem | Source | Verified | Topics |
| --- | --- | :---: | --- |
| [3D Acorn Counting](3D%20Acorn%20Counting/) | Not publicly listed (practice / course problem) | ⚪ | Flood Fill, BFS, 3D Grid |
| [BFS](BFS/) | Practice program (not a judge problem) | ⚪ | BFS |
| [BFS Shortest Path](BFS%20Shortest%20Path/) | Practice program (not a judge problem) | ⚪ | BFS, Shortest Path |
| [DFS code](DFS%20code/) | Practice program (not a judge problem) | ⚪ | DFS |
| [Dividing the Pasture](Dividing%20the%20Pasture/) | Not publicly listed (practice / course problem) | ⚪ | Geometry, Hashing |
| [Fixing the Roads](Fixing%20the%20Roads/) | Not publicly listed (practice / course problem) | ⚪ | 0-1 BFS, Shortest Paths |
| [hellow](hellow/) | Practice program (not a judge problem) | ⚪ | Brute Force |
| [Max Binary Tree Width](Max%20Binary%20Tree%20Width/) | Not publicly listed (practice / course problem) | ⚪ | Binary Search on Answer |
| [Squares](Squares/) | Not publicly listed (practice / course problem) | ⚪ | Monotonic Stack, MEX |
| [Sure Bet](Sure%20Bet/) | Not publicly listed (practice / course problem) | ⚪ | Greedy, Two Pointers, Sorting |
| [Sweep Line 1](Sweep%20Line%201/) | Not publicly listed (practice / course problem) | ⚪ | Sweep Line, Sorting |
| [Triangular Barns 1](Triangular%20Barns%201/) | Not publicly listed (practice / course problem) | ⚪ | Interval Merging, Sorting |
| [Trolley Problem](Trolley%20Problem/) | Not publicly listed (practice / course problem) | ⚪ | Greedy, Sorting, Two Pointers |

---

Problems belong to their respective organizations (USACO, Codeforces, CSES, AtCoder, JOI, LeetCode, …). These solutions are for learning; try each problem yourself before reading the solution.
