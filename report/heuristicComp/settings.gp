set terminal pngcairo size 1920, 1200 font "Helvetica,50"
unset key

set boxwidth 0.5
set style fill solid

set xlabel ""
set ylabel "Exekveringstid (ms)"
set grid

set output "~/Desktop/exjobb/report/heuristicComp/plot.png"
plot "~/Desktop/exjobb/report/heuristicComp/results.txt" using 1:3:xtic(2) with boxes ls 3
