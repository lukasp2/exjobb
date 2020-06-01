#!/usr/bin/env python3

import statistics


'''
Testing what heuristic is optimal. Time was taken every time astar was running.

- BLOCK_SIZE: 1
- trådar: 1
- Radio l=0.002
- MAX_HOPS=100
- 39800 requests
- 200 nodes
- radioCom was always distCom

results:
avg in distComp = 27.91
avg in signalComp = 30.66
avg in rndComp = 33.24
'''

distComp = [25, 30, 33, 31, 30, 22, 27, 42, 32, 24, 30, 33, 26, 35, 26, 28, 28, 30, 23, 28, 27, 29, 28, 24, 36, 25, 31, 27, 30, 25, 40, 35, 28, 24, 27, 24, 24, 25, 28, 26, 28, 29, 29, 25, 27, 26, 24, 26, 30, 26, 26, 27, 29, 25, 37, 31, 26, 24, 23, 25, 29, 24, 26, 31, 27, 32, 23, 27, 26, 28, 24, 28, 26, 28, 26, 23, 24, 31, 24, 39, 27, 25, 30, 28, 27, 23, 35, 25, 24, 27, 23, 27, 28, 26, 26, 28, 30, 38, 33, 26]

signalComp = [28, 34, 29, 30, 29, 25, 29, 35, 26, 29, 35, 31, 29, 26, 31, 32, 30, 36, 29, 35, 34, 35, 31, 36, 25, 27, 34, 32, 23, 32, 35, 28, 33, 25, 28, 34, 31, 27, 29, 30, 27, 32, 29, 33, 27, 33, 30, 37, 30, 28, 36, 32, 44, 36, 32, 38, 35, 27, 36, 24, 34, 32, 36, 26, 26, 27, 26, 32, 30, 33, 27, 36, 29, 28, 27, 25, 32, 32, 30, 27, 26, 29, 31, 34, 30, 35, 24, 35, 29, 32, 30, 28, 34, 31, 30, 32, 30, 26, 31, 31]

rndComp = [42, 59, 27, 31, 35, 29, 24, 31, 38, 37, 38, 42, 29, 30, 33, 45, 33, 37, 30, 30, 28, 26, 30, 42, 35, 35, 25, 26, 36, 25, 25, 29, 34, 44, 32, 37, 47, 38, 42, 25, 28, 32, 31, 46, 30, 29, 36, 38, 29, 31, 27, 27, 37, 38, 28, 46, 31, 25, 32, 43, 29, 24, 29, 31, 37, 31, 37, 27, 40, 37, 35, 27, 40, 36, 28, 26, 23, 35, 24, 28, 38, 32, 38, 25, 30, 50, 32, 31, 34, 24, 39, 38, 34, 28, 37, 30, 33, 29, 47, 26]

tot = 0
for i in distComp:
    tot += i
    
print(" distComp: avg =",  tot / len(distComp), " median =", statistics.median(distComp), " st.av =", statistics.stdev(distComp))

tot = 0
for i in signalComp:
    tot += i
    
print("avg signalComp =",  tot / len(signalComp), " median =",statistics.median(signalComp) , " st.av =", statistics.stdev(signalComp))

tot = 0
for i in rndComp:
    tot += i
    
print("avg rndComp =",  tot / len(rndComp), " median =", statistics.median(rndComp), " st.av =", statistics.stdev(rndComp))
