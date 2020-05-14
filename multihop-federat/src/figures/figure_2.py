#!/usr/bin/env python3
import matplotlib.pyplot as plt

a=[
    [0,454],
    [1,242.001704],
    [2,142.420662],
    [3,106.572739],
    [4,94.097948],
    [5,71.426776],
    [6,62.26135],
    [7,53.353149],
    [8,45.640638],
    [9,42.006937],
    [10,39.695507],
    [11,35.879006],
    [12,32.29339],
    [13,29.443103],
    [14,28.932276],
    [15,24.223168],
    [16,25.11659],
    [17,22.819003],
    [18,22.545783],
    [19,19.970594],
    [20,21.42351],
    [21,17.412698],
    [22,18.863044],
    [23,22.690502],
    [24,18.167809],
    [25,14.909012],
    [26,16.051246],
    [27,16.6372],
]

plt.plot(*zip(*a), marker='o', color='k', ls='')

plt.xlabel("Dynamic queue block size")
plt.ylabel("Total time spent building graphs (ms)")

plt.show()