#!/bin/bash

printf '%s' '['

for i in {1..99}; do 
    /home/lukas/Desktop/exjobb/multihop-federat/runner.sh
    printf '%s' ', '
done

/home/lukas/Desktop/exjobb/multihop-federat/runner.sh

printf '%s\n' ']'
