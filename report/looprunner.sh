#!/bin/bash

printf '%s' '['

for i in {1..100}; do 
    /home/lukas/Desktop/exjobb/multihop-federat/runner.sh
done

printf '%s\n' ']'
