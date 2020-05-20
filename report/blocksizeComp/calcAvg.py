#!/usr/bin/env python3

'''
Testing what size of the blocks is optimal. 
Time was taken from before threads start to right before we disconnect from _hlaWorld.

- BLOCK_SIZE: 1
- threads: 8
- Radio l=0.002
- MAX_HOPS=4
- 39800 requests
- 200 nodes
- distance heur
- randomized radioCom (but same resulting graph)
'''

# results is [[t1],[t2], ... [tn]]
results = [
   
]
    
k = 1
for n in results:
    total_time = 0
    for time in n:
        total_time += time
    
    print("avg for", k, "thread(s) =",  total_time / len(n))
    k = k + 1
