#!/usr/bin/env python3

'''
Testing what size of the blocks is optimal. 
Time was taken from before threads start to right before we disconnect from _hlaWorld.

- BLOCK_SIZE: 1..30
- threads: 8
- Radio l=0.002
- MAX_HOPS=4
- 39800 requests
- 200 nodes
- distance heur
- randomized radioCom (but same resulting graph)

results:
avg for block size 0 = 4708.94
avg for block size 10 = 914.228813559322
avg for block size 20 = 605.1029411764706
avg for block size 30 = 522.12
avg for block size 40 = 441.45
avg for block size 50 = 419.4
avg for block size 60 = 391.72
avg for block size 70 = 376.26
avg for block size 80 = 373.2
avg for block size 90 = 361.29
avg for block size 100 = 356.91
avg for block size 110 = 341.29
(avg for block size 115 = 347.13)
avg for block size 120 = 340.96
(avg for block size 125 = 350.20)
avg for block size 130 = 344.59
avg for block size 140 = 350.55
'''

# results is [[BL=1],[BL=10], ... [BL=..]]
results = [
[366, 345, 342, 330, 378, 340, 353, 353, 367, 350, 313, 352, 302, 347, 360, 406, 315, 341, 330, 332, 365, 323, 332, 336, 334, 339, 358, 346, 342, 342, 338, 357, 344, 324, 340, 328, 314, 346, 337, 327, 342, 348, 334, 362, 339, 395, 349, 352, 362, 338, 341, 363, 332, 343, 342, 341, 342, 360, 348, 350, 363, 635, 355, 332, 342, 352, 337, 348, 331, 348, 341, 332, 335, 348, 343, 362, 334, 344, 342, 353, 356, 334, 351, 343, 342, 337, 345, 348, 345, 354, 355, 325, 396, 349, 335, 348, 357, 359, 334, 364]
]
    
k = 0
for n in results:
    total_time = 0
    for time in n:
        total_time += time
    
    print("avg for block size", k * 10, "=", total_time / len(n))
    k = k + 1
