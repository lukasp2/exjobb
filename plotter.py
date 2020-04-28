#!/usr/bin/env python3
import matplotlib.pyplot as plt

a=[
[0.0, 15.0],
[73.0, 59.0],
[34.0, 69.0],
[77.0, 51.0],
[3.0, 17.0],
[29.0, 82.0],
[52.0, 30.0],
[57.0, 81.0],
[22.0, 22.0],
[55.0, 45.0],
[42.0, 16.0],
[66.0, 2.0],
[55.0, 25.0],
[5.0, 50.0],
[4.0, 68.0],
[96.0, 95.0],
[27.0, 25.0],
[67.0, 7.0],
[8.0, 12.0],
[42.0, 98.0],
[82.0, 70.0],
[6.0, 86.0],
[90.0, 14.0],
[36.0, 4.0],
[85.0, 72.0],
[69.0, 90.0],
[48.0, 33.0],
[12.0, 48.0],
[92.0, 85.0],
[83.0, 73.0],
[3.0, 72.0],
[90.0, 4.0],
[4.0, 57.0],
[66.0, 83.0],
[26.0, 80.0],
[13.0, 63.0],
[27.0, 89.0],
[3.0, 34.0],
[68.0, 28.0],
[64.0, 70.0],
[26.0, 8.0],
[57.0, 59.0],
[40.0, 33.0],
[65.0, 84.0],
[64.0, 33.0],
[77.0, 83.0],
[76.0, 93.0],
[0.0, 99.0],
[18.0, 79.0],
[9.0, 93.0],
[48.0, 67.0],
[77.0, 15.0],
[44.0, 83.0],
[75.0, 90.0],
[49.0, 45.0],
[87.0, 57.0],
[6.0, 42.0],
[29.0, 94.0],
[84.0, 74.0],
[8.0, 28.0],
[13.0, 7.0],
[11.0, 9.0],
[99.0, 95.0],
[10.0, 39.0],
[51.0, 38.0],
[18.0, 23.0],
[76.0, 22.0],
[45.0, 32.0],
[21.0, 46.0],
[65.0, 52.0],
[38.0, 60.0],
[90.0, 94.0],
[76.0, 47.0],
[50.0, 13.0],
[7.0, 17.0],
[66.0, 79.0],
[80.0, 20.0],
[13.0, 38.0],
[74.0, 27.0],
[47.0, 71.0],
[17.0, 23.0],
[78.0, 33.0],
[25.0, 66.0],
[20.0, 46.0],
[94.0, 12.0],
[26.0, 95.0],
[6.0, 44.0],
[61.0, 83.0],
[43.0, 35.0],
[83.0, 54.0],
[50.0, 75.0],
[44.0, 19.0],
[61.0, 84.0],
[48.0, 41.0],
[1.0, 37.0],
[78.0, 25.0],
[27.0, 45.0],
[97.0, 74.0],
[66.0, 21.0],
[78.0, 82.0],
]

plt.plot(*zip(*a), marker='o', color='k', ls='')

plt.text(1.0, 16.0, 0, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(74.0, 60.0, 1, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(35.0, 70.0, 2, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(78.0, 52.0, 3, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(4.0, 18.0, 4, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(30.0, 83.0, 5, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(53.0, 31.0, 6, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(58.0, 82.0, 7, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(23.0, 23.0, 8, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(56.0, 46.0, 9, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(43.0, 17.0, 10, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(67.0, 3.0, 11, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(56.0, 26.0, 12, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(6.0, 51.0, 13, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(5.0, 69.0, 14, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(97.0, 96.0, 15, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(28.0, 26.0, 16, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(68.0, 8.0, 17, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(9.0, 13.0, 18, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(43.0, 99.0, 19, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(83.0, 71.0, 20, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(7.0, 87.0, 21, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(91.0, 15.0, 22, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(37.0, 5.0, 23, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(86.0, 73.0, 24, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(70.0, 91.0, 25, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(49.0, 34.0, 26, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(13.0, 49.0, 27, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(93.0, 86.0, 28, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(84.0, 74.0, 29, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(4.0, 73.0, 30, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(91.0, 5.0, 31, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(5.0, 58.0, 32, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(67.0, 84.0, 33, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(27.0, 81.0, 34, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(14.0, 64.0, 35, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(28.0, 90.0, 36, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(4.0, 35.0, 37, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(69.0, 29.0, 38, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(65.0, 71.0, 39, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(27.0, 9.0, 40, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(58.0, 60.0, 41, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(41.0, 34.0, 42, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(66.0, 85.0, 43, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(65.0, 34.0, 44, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(78.0, 84.0, 45, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(77.0, 94.0, 46, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(1.0, 100.0, 47, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(19.0, 80.0, 48, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(10.0, 94.0, 49, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(49.0, 68.0, 50, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(78.0, 16.0, 51, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(45.0, 84.0, 52, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(76.0, 91.0, 53, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(50.0, 46.0, 54, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(88.0, 58.0, 55, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(7.0, 43.0, 56, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(30.0, 95.0, 57, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(85.0, 75.0, 58, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(9.0, 29.0, 59, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(14.0, 8.0, 60, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(12.0, 10.0, 61, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(100.0, 96.0, 62, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(11.0, 40.0, 63, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(52.0, 39.0, 64, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(19.0, 24.0, 65, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(77.0, 23.0, 66, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(46.0, 33.0, 67, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(22.0, 47.0, 68, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(66.0, 53.0, 69, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(39.0, 61.0, 70, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(91.0, 95.0, 71, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(77.0, 48.0, 72, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(51.0, 14.0, 73, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(8.0, 18.0, 74, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(67.0, 80.0, 75, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(81.0, 21.0, 76, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(14.0, 39.0, 77, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(75.0, 28.0, 78, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(48.0, 72.0, 79, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(18.0, 24.0, 80, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(79.0, 34.0, 81, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(26.0, 67.0, 82, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(21.0, 47.0, 83, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(95.0, 13.0, 84, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(27.0, 96.0, 85, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(7.0, 45.0, 86, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(62.0, 84.0, 87, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(44.0, 36.0, 88, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(84.0, 55.0, 89, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(51.0, 76.0, 90, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(45.0, 20.0, 91, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(62.0, 85.0, 92, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(49.0, 42.0, 93, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(2.0, 38.0, 94, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(79.0, 26.0, 95, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(28.0, 46.0, 96, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(98.0, 75.0, 97, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(67.0, 22.0, 98, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)
plt.text(79.0, 83.0, 99, bbox=dict(facecolor='red', alpha=0.1), fontsize=10)

plt.plot([0.0, 77.0], [15.0, 15.0], 'y' )
plt.text(38.5, 15.0, 77, fontsize=6)
plt.plot([0.0, 25.0], [15.0, 66.0], 'y' )
plt.text(12.5, 40.5, 57, fontsize=6)
plt.plot([73.0, 8.0], [59.0, 12.0], 'y' )
plt.text(40.5, 35.5, 80, fontsize=6)
plt.plot([73.0, 40.0], [59.0, 33.0], 'y' )
plt.text(56.5, 46.0, 42, fontsize=6)
plt.plot([34.0, 77.0], [69.0, 83.0], 'y' )
plt.text(55.5, 76.0, 45, fontsize=6)
plt.plot([34.0, 49.0], [69.0, 45.0], 'y' )
plt.text(41.5, 57.0, 28, fontsize=6)
plt.plot([34.0, 76.0], [69.0, 22.0], 'y' )
plt.text(55.0, 45.5, 63, fontsize=6)
plt.plot([77.0, 67.0], [51.0, 7.0], 'y' )
plt.text(72.0, 29.0, 45, fontsize=6)
plt.plot([77.0, 82.0], [51.0, 70.0], 'y' )
plt.text(79.5, 60.5, 20, fontsize=6)
plt.plot([3.0, 21.0], [17.0, 46.0], 'y' )
plt.text(12.0, 31.5, 34, fontsize=6)
plt.plot([29.0, 77.0], [82.0, 15.0], 'y' )
plt.text(53.0, 48.5, 82, fontsize=6)
plt.plot([29.0, 7.0], [82.0, 17.0], 'y' )
plt.text(18.0, 49.5, 69, fontsize=6)
plt.plot([29.0, 78.0], [82.0, 33.0], 'y' )
plt.text(53.5, 57.5, 69, fontsize=6)
plt.plot([52.0, 29.0], [30.0, 82.0], 'y' )
plt.text(40.5, 56.0, 57, fontsize=6)
plt.plot([52.0, 90.0], [30.0, 4.0], 'y' )
plt.text(71.0, 17.0, 46, fontsize=6)
plt.plot([52.0, 45.0], [30.0, 32.0], 'y' )
plt.text(48.5, 31.0, 7, fontsize=6)
plt.plot([57.0, 42.0], [81.0, 16.0], 'y' )
plt.text(49.5, 48.5, 67, fontsize=6)
plt.plot([55.0, 76.0], [45.0, 22.0], 'y' )
plt.text(65.5, 33.5, 31, fontsize=6)
plt.plot([66.0, 66.0], [2.0, 79.0], 'y' )
plt.text(66.0, 40.5, 77, fontsize=6)
plt.plot([55.0, 6.0], [25.0, 86.0], 'y' )
plt.text(30.5, 55.5, 78, fontsize=6)
plt.plot([55.0, 45.0], [25.0, 32.0], 'y' )
plt.text(50.0, 28.5, 12, fontsize=6)
plt.plot([55.0, 90.0], [25.0, 94.0], 'y' )
plt.text(72.5, 59.5, 77, fontsize=6)
plt.plot([4.0, 61.0], [68.0, 84.0], 'y' )
plt.text(32.5, 76.0, 59, fontsize=6)
plt.plot([96.0, 8.0], [95.0, 28.0], 'y' )
plt.text(52.0, 61.5, 111, fontsize=6)
plt.plot([67.0, 27.0], [7.0, 25.0], 'y' )
plt.text(47.0, 16.0, 44, fontsize=6)
plt.plot([67.0, 85.0], [7.0, 72.0], 'y' )
plt.text(76.0, 39.5, 67, fontsize=6)
plt.plot([8.0, 26.0], [12.0, 95.0], 'y' )
plt.text(17.0, 53.5, 85, fontsize=6)
plt.plot([42.0, 3.0], [98.0, 34.0], 'y' )
plt.text(22.5, 66.0, 75, fontsize=6)
plt.plot([42.0, 9.0], [98.0, 93.0], 'y' )
plt.text(25.5, 95.5, 33, fontsize=6)
plt.plot([42.0, 7.0], [98.0, 17.0], 'y' )
plt.text(24.5, 57.5, 88, fontsize=6)
plt.plot([82.0, 85.0], [70.0, 72.0], 'y' )
plt.text(83.5, 71.0, 4, fontsize=6)
plt.plot([82.0, 80.0], [70.0, 20.0], 'y' )
plt.text(81.0, 45.0, 50, fontsize=6)
plt.plot([6.0, 4.0], [86.0, 57.0], 'y' )
plt.text(5.0, 71.5, 29, fontsize=6)
plt.plot([90.0, 20.0], [14.0, 46.0], 'y' )
plt.text(55.0, 30.0, 77, fontsize=6)
plt.plot([36.0, 10.0], [4.0, 39.0], 'y' )
plt.text(23.0, 21.5, 44, fontsize=6)
plt.plot([85.0, 26.0], [72.0, 8.0], 'y' )
plt.text(55.5, 40.0, 87, fontsize=6)
plt.plot([85.0, 65.0], [72.0, 84.0], 'y' )
plt.text(75.0, 78.0, 23, fontsize=6)
plt.plot([85.0, 45.0], [72.0, 32.0], 'y' )
plt.text(65.0, 52.0, 57, fontsize=6)
plt.plot([69.0, 22.0], [90.0, 22.0], 'y' )
plt.text(45.5, 56.0, 83, fontsize=6)
plt.plot([69.0, 3.0], [90.0, 34.0], 'y' )
plt.text(36.0, 62.0, 87, fontsize=6)
plt.plot([69.0, 65.0], [90.0, 52.0], 'y' )
plt.text(67.0, 71.0, 38, fontsize=6)
plt.plot([69.0, 50.0], [90.0, 75.0], 'y' )
plt.text(59.5, 82.5, 24, fontsize=6)
plt.plot([48.0, 44.0], [33.0, 83.0], 'y' )
plt.text(46.0, 58.0, 50, fontsize=6)
plt.plot([48.0, 80.0], [33.0, 20.0], 'y' )
plt.text(64.0, 26.5, 35, fontsize=6)
plt.plot([83.0, 45.0], [73.0, 32.0], 'y' )
plt.text(64.0, 52.5, 56, fontsize=6)
plt.plot([83.0, 50.0], [73.0, 13.0], 'y' )
plt.text(66.5, 43.0, 68, fontsize=6)
plt.plot([3.0, 45.0], [72.0, 32.0], 'y' )
plt.text(24.0, 52.0, 58, fontsize=6)
plt.plot([90.0, 42.0], [4.0, 98.0], 'y' )
plt.text(66.0, 51.0, 106, fontsize=6)
plt.plot([90.0, 26.0], [4.0, 80.0], 'y' )
plt.text(58.0, 42.0, 99, fontsize=6)
plt.plot([90.0, 87.0], [4.0, 57.0], 'y' )
plt.text(88.5, 30.5, 53, fontsize=6)
plt.plot([66.0, 7.0], [83.0, 17.0], 'y' )
plt.text(36.5, 50.0, 89, fontsize=6)
plt.plot([26.0, 4.0], [80.0, 68.0], 'y' )
plt.text(15.0, 74.0, 25, fontsize=6)
plt.plot([13.0, 29.0], [63.0, 82.0], 'y' )
plt.text(21.0, 72.5, 25, fontsize=6)
plt.plot([13.0, 55.0], [63.0, 45.0], 'y' )
plt.text(34.0, 54.0, 46, fontsize=6)
plt.plot([68.0, 82.0], [28.0, 70.0], 'y' )
plt.text(75.0, 49.0, 44, fontsize=6)
plt.plot([68.0, 6.0], [28.0, 42.0], 'y' )
plt.text(37.0, 35.0, 64, fontsize=6)
plt.plot([68.0, 25.0], [28.0, 66.0], 'y' )
plt.text(46.5, 47.0, 57, fontsize=6)
plt.plot([64.0, 0.0], [70.0, 99.0], 'y' )
plt.text(32.0, 84.5, 70, fontsize=6)
plt.plot([64.0, 38.0], [70.0, 60.0], 'y' )
plt.text(51.0, 65.0, 28, fontsize=6)
plt.plot([64.0, 7.0], [70.0, 17.0], 'y' )
plt.text(35.5, 43.5, 78, fontsize=6)
plt.plot([64.0, 78.0], [70.0, 25.0], 'y' )
plt.text(71.0, 47.5, 47, fontsize=6)
plt.plot([26.0, 17.0], [8.0, 23.0], 'y' )
plt.text(21.5, 15.5, 17, fontsize=6)
plt.plot([26.0, 94.0], [8.0, 12.0], 'y' )
plt.text(60.0, 10.0, 68, fontsize=6)
plt.plot([57.0, 94.0], [59.0, 12.0], 'y' )
plt.text(75.5, 35.5, 60, fontsize=6)
plt.plot([57.0, 6.0], [59.0, 44.0], 'y' )
plt.text(31.5, 51.5, 53, fontsize=6)
plt.plot([40.0, 13.0], [33.0, 38.0], 'y' )
plt.text(26.5, 35.5, 27, fontsize=6)
plt.plot([64.0, 0.0], [33.0, 15.0], 'y' )
plt.text(32.0, 24.0, 66, fontsize=6)
plt.plot([64.0, 57.0], [33.0, 81.0], 'y' )
plt.text(60.5, 57.0, 49, fontsize=6)
plt.plot([64.0, 27.0], [33.0, 89.0], 'y' )
plt.text(45.5, 61.0, 67, fontsize=6)
plt.plot([64.0, 6.0], [33.0, 42.0], 'y' )
plt.text(35.0, 37.5, 59, fontsize=6)
plt.plot([64.0, 26.0], [33.0, 95.0], 'y' )
plt.text(45.0, 64.0, 73, fontsize=6)
plt.plot([77.0, 8.0], [83.0, 12.0], 'y' )
plt.text(42.5, 47.5, 99, fontsize=6)
plt.plot([76.0, 55.0], [93.0, 25.0], 'y' )
plt.text(65.5, 59.0, 71, fontsize=6)
plt.plot([76.0, 10.0], [93.0, 39.0], 'y' )
plt.text(43.0, 66.0, 85, fontsize=6)
plt.plot([0.0, 26.0], [99.0, 80.0], 'y' )
plt.text(13.0, 89.5, 32, fontsize=6)
plt.plot([0.0, 77.0], [99.0, 83.0], 'y' )
plt.text(38.5, 91.0, 79, fontsize=6)
plt.plot([0.0, 51.0], [99.0, 38.0], 'y' )
plt.text(25.5, 68.5, 80, fontsize=6)
plt.plot([18.0, 6.0], [79.0, 86.0], 'y' )
plt.text(12.0, 82.5, 14, fontsize=6)
plt.plot([18.0, 40.0], [79.0, 33.0], 'y' )
plt.text(29.0, 56.0, 51, fontsize=6)
plt.plot([18.0, 17.0], [79.0, 23.0], 'y' )
plt.text(17.5, 51.0, 56, fontsize=6)
plt.plot([18.0, 27.0], [79.0, 45.0], 'y' )
plt.text(22.5, 62.0, 35, fontsize=6)
plt.plot([9.0, 13.0], [93.0, 63.0], 'y' )
plt.text(11.0, 78.0, 30, fontsize=6)
plt.plot([9.0, 18.0], [93.0, 23.0], 'y' )
plt.text(13.5, 58.0, 71, fontsize=6)
plt.plot([44.0, 74.0], [83.0, 27.0], 'y' )
plt.text(59.0, 55.0, 64, fontsize=6)
plt.plot([75.0, 66.0], [90.0, 79.0], 'y' )
plt.text(70.5, 84.5, 14, fontsize=6)
plt.plot([49.0, 42.0], [45.0, 98.0], 'y' )
plt.text(45.5, 71.5, 53, fontsize=6)
plt.plot([49.0, 8.0], [45.0, 28.0], 'y' )
plt.text(28.5, 36.5, 44, fontsize=6)
plt.plot([49.0, 65.0], [45.0, 52.0], 'y' )
plt.text(57.0, 48.5, 17, fontsize=6)
plt.plot([87.0, 50.0], [57.0, 13.0], 'y' )
plt.text(68.5, 35.0, 57, fontsize=6)
plt.plot([29.0, 0.0], [94.0, 99.0], 'y' )
plt.text(14.5, 96.5, 29, fontsize=6)
plt.plot([29.0, 21.0], [94.0, 46.0], 'y' )
plt.text(25.0, 70.0, 49, fontsize=6)
plt.plot([84.0, 4.0], [74.0, 57.0], 'y' )
plt.text(44.0, 65.5, 82, fontsize=6)
plt.plot([84.0, 76.0], [74.0, 47.0], 'y' )
plt.text(80.0, 60.5, 28, fontsize=6)
plt.plot([8.0, 76.0], [28.0, 47.0], 'y' )
plt.text(42.0, 37.5, 71, fontsize=6)
plt.plot([8.0, 78.0], [28.0, 33.0], 'y' )
plt.text(43.0, 30.5, 70, fontsize=6)
plt.plot([8.0, 94.0], [28.0, 12.0], 'y' )
plt.text(51.0, 20.0, 87, fontsize=6)
plt.plot([13.0, 64.0], [7.0, 70.0], 'y' )
plt.text(38.5, 38.5, 81, fontsize=6)
plt.plot([13.0, 78.0], [7.0, 82.0], 'y' )
plt.text(45.5, 44.5, 99, fontsize=6)
plt.plot([11.0, 55.0], [9.0, 45.0], 'y' )
plt.text(33.0, 27.0, 57, fontsize=6)
plt.plot([10.0, 22.0], [39.0, 22.0], 'y' )
plt.text(16.0, 30.5, 21, fontsize=6)
plt.plot([10.0, 80.0], [39.0, 20.0], 'y' )
plt.text(45.0, 29.5, 73, fontsize=6)
plt.plot([51.0, 44.0], [38.0, 83.0], 'y' )
plt.text(47.5, 60.5, 46, fontsize=6)
plt.plot([51.0, 25.0], [38.0, 66.0], 'y' )
plt.text(38.0, 52.0, 38, fontsize=6)
plt.plot([51.0, 43.0], [38.0, 35.0], 'y' )
plt.text(47.0, 36.5, 9, fontsize=6)
plt.plot([18.0, 97.0], [23.0, 74.0], 'y' )
plt.text(57.5, 48.5, 94, fontsize=6)
plt.plot([76.0, 43.0], [22.0, 35.0], 'y' )
plt.text(59.5, 28.5, 35, fontsize=6)
plt.plot([45.0, 57.0], [32.0, 81.0], 'y' )
plt.text(51.0, 56.5, 50, fontsize=6)
plt.plot([45.0, 5.0], [32.0, 50.0], 'y' )
plt.text(25.0, 41.0, 44, fontsize=6)
plt.plot([45.0, 36.0], [32.0, 4.0], 'y' )
plt.text(40.5, 18.0, 29, fontsize=6)
plt.plot([21.0, 77.0], [46.0, 83.0], 'y' )
plt.text(49.0, 64.5, 67, fontsize=6)
plt.plot([65.0, 0.0], [52.0, 99.0], 'y' )
plt.text(32.5, 75.5, 80, fontsize=6)
plt.plot([38.0, 68.0], [60.0, 28.0], 'y' )
plt.text(53.0, 44.0, 44, fontsize=6)
plt.plot([76.0, 5.0], [47.0, 50.0], 'y' )
plt.text(40.5, 48.5, 71, fontsize=6)
plt.plot([50.0, 83.0], [13.0, 73.0], 'y' )
plt.text(66.5, 43.0, 68, fontsize=6)
plt.plot([50.0, 4.0], [13.0, 57.0], 'y' )
plt.text(27.0, 35.0, 64, fontsize=6)
plt.plot([50.0, 80.0], [13.0, 20.0], 'y' )
plt.text(65.0, 16.5, 31, fontsize=6)
plt.plot([7.0, 68.0], [17.0, 28.0], 'y' )
plt.text(37.5, 22.5, 62, fontsize=6)
plt.plot([7.0, 87.0], [17.0, 57.0], 'y' )
plt.text(47.0, 37.0, 89, fontsize=6)
plt.plot([7.0, 38.0], [17.0, 60.0], 'y' )
plt.text(22.5, 38.5, 53, fontsize=6)
plt.plot([66.0, 6.0], [79.0, 86.0], 'y' )
plt.text(36.0, 82.5, 60, fontsize=6)
plt.plot([66.0, 18.0], [79.0, 79.0], 'y' )
plt.text(42.0, 79.0, 48, fontsize=6)
plt.plot([80.0, 48.0], [20.0, 67.0], 'y' )
plt.text(64.0, 43.5, 57, fontsize=6)
plt.plot([80.0, 13.0], [20.0, 7.0], 'y' )
plt.text(46.5, 13.5, 68, fontsize=6)
plt.plot([13.0, 29.0], [38.0, 94.0], 'y' )
plt.text(21.0, 66.0, 58, fontsize=6)
plt.plot([13.0, 7.0], [38.0, 17.0], 'y' )
plt.text(10.0, 27.5, 22, fontsize=6)
plt.plot([13.0, 27.0], [38.0, 45.0], 'y' )
plt.text(20.0, 41.5, 16, fontsize=6)
plt.plot([74.0, 78.0], [27.0, 82.0], 'y' )
plt.text(76.0, 54.5, 55, fontsize=6)
plt.plot([47.0, 42.0], [71.0, 98.0], 'y' )
plt.text(44.5, 84.5, 27, fontsize=6)
plt.plot([47.0, 69.0], [71.0, 90.0], 'y' )
plt.text(58.0, 80.5, 29, fontsize=6)
plt.plot([47.0, 65.0], [71.0, 52.0], 'y' )
plt.text(56.0, 61.5, 26, fontsize=6)
plt.plot([17.0, 97.0], [23.0, 74.0], 'y' )
plt.text(57.0, 48.5, 95, fontsize=6)
plt.plot([25.0, 27.0], [66.0, 89.0], 'y' )
plt.text(26.0, 77.5, 23, fontsize=6)
plt.plot([25.0, 40.0], [66.0, 33.0], 'y' )
plt.text(32.5, 49.5, 36, fontsize=6)
plt.plot([20.0, 5.0], [46.0, 50.0], 'y' )
plt.text(12.5, 48.0, 16, fontsize=6)
plt.plot([20.0, 78.0], [46.0, 33.0], 'y' )
plt.text(49.0, 39.5, 59, fontsize=6)
plt.plot([20.0, 66.0], [46.0, 21.0], 'y' )
plt.text(43.0, 33.5, 52, fontsize=6)
plt.plot([94.0, 90.0], [12.0, 14.0], 'y' )
plt.text(92.0, 13.0, 4, fontsize=6)
plt.plot([26.0, 27.0], [95.0, 89.0], 'y' )
plt.text(26.5, 92.0, 6, fontsize=6)
plt.plot([26.0, 44.0], [95.0, 83.0], 'y' )
plt.text(35.0, 89.0, 22, fontsize=6)
plt.plot([26.0, 51.0], [95.0, 38.0], 'y' )
plt.text(38.5, 66.5, 62, fontsize=6)
plt.plot([26.0, 1.0], [95.0, 37.0], 'y' )
plt.text(13.5, 66.0, 63, fontsize=6)
plt.plot([6.0, 34.0], [44.0, 69.0], 'y' )
plt.text(20.0, 56.5, 38, fontsize=6)
plt.plot([6.0, 6.0], [44.0, 86.0], 'y' )
plt.text(6.0, 65.0, 42, fontsize=6)
plt.plot([6.0, 66.0], [44.0, 83.0], 'y' )
plt.text(36.0, 63.5, 72, fontsize=6)
plt.plot([61.0, 49.0], [83.0, 45.0], 'y' )
plt.text(55.0, 64.0, 40, fontsize=6)
plt.plot([43.0, 67.0], [35.0, 7.0], 'y' )
plt.text(55.0, 21.0, 37, fontsize=6)
plt.plot([43.0, 92.0], [35.0, 85.0], 'y' )
plt.text(67.5, 60.0, 70, fontsize=6)
plt.plot([43.0, 65.0], [35.0, 52.0], 'y' )
plt.text(54.0, 43.5, 28, fontsize=6)
plt.plot([43.0, 74.0], [35.0, 27.0], 'y' )
plt.text(58.5, 31.0, 32, fontsize=6)
plt.plot([83.0, 0.0], [54.0, 99.0], 'y' )
plt.text(41.5, 76.5, 94, fontsize=6)
plt.plot([83.0, 44.0], [54.0, 19.0], 'y' )
plt.text(63.5, 36.5, 52, fontsize=6)
plt.plot([44.0, 42.0], [19.0, 98.0], 'y' )
plt.text(43.0, 58.5, 79, fontsize=6)
plt.plot([44.0, 1.0], [19.0, 37.0], 'y' )
plt.text(22.5, 28.0, 47, fontsize=6)
plt.plot([1.0, 42.0], [37.0, 98.0], 'y' )
plt.text(21.5, 67.5, 73, fontsize=6)
plt.plot([1.0, 75.0], [37.0, 90.0], 'y' )
plt.text(38.0, 63.5, 91, fontsize=6)
plt.plot([1.0, 90.0], [37.0, 94.0], 'y' )
plt.text(45.5, 65.5, 106, fontsize=6)
plt.plot([1.0, 50.0], [37.0, 13.0], 'y' )
plt.text(25.5, 25.0, 55, fontsize=6)
plt.plot([78.0, 90.0], [25.0, 14.0], 'y' )
plt.text(84.0, 19.5, 16, fontsize=6)
plt.plot([78.0, 99.0], [25.0, 95.0], 'y' )
plt.text(88.5, 60.0, 73, fontsize=6)
plt.plot([78.0, 27.0], [25.0, 45.0], 'y' )
plt.text(52.5, 35.0, 55, fontsize=6)
plt.plot([27.0, 42.0], [45.0, 98.0], 'y' )
plt.text(34.5, 71.5, 55, fontsize=6)
plt.plot([27.0, 51.0], [45.0, 38.0], 'y' )
plt.text(39.0, 41.5, 25, fontsize=6)
plt.plot([97.0, 4.0], [74.0, 57.0], 'y' )
plt.text(50.5, 65.5, 95, fontsize=6)
plt.plot([97.0, 90.0], [74.0, 94.0], 'y' )
plt.text(93.5, 84.0, 21, fontsize=6)
plt.plot([97.0, 66.0], [74.0, 21.0], 'y' )
plt.text(81.5, 47.5, 61, fontsize=6)
plt.plot([66.0, 85.0], [21.0, 72.0], 'y' )
plt.text(75.5, 46.5, 54, fontsize=6)
plt.plot([66.0, 45.0], [21.0, 32.0], 'y' )
plt.text(55.5, 26.5, 24, fontsize=6)
plt.plot([66.0, 50.0], [21.0, 75.0], 'y' )
plt.text(58.0, 48.0, 56, fontsize=6)
plt.plot([78.0, 5.0], [82.0, 50.0], 'y' )
plt.text(41.5, 66.0, 80, fontsize=6)
plt.plot([78.0, 47.0], [82.0, 71.0], 'y' )
plt.text(62.5, 76.5, 33, fontsize=6)
plt.plot([48.0, 48.0], [33.0, 33.0], 'g' )
plt.text(48.0, 33.0, 0, fontsize=6)
plt.plot([80.0, 48.0], [20.0, 33.0], 'g' )
plt.text(64.0, 26.5, 35, fontsize=6)
plt.plot([44.0, 48.0], [83.0, 33.0], 'g' )
plt.text(46.0, 58.0, 50, fontsize=6)
plt.plot([74.0, 44.0], [27.0, 83.0], 'g' )
plt.text(59.0, 55.0, 64, fontsize=6)
plt.plot([78.0, 74.0], [82.0, 27.0], 'g' )
plt.text(76.0, 54.5, 55, fontsize=6)
plt.plot([47.0, 78.0], [71.0, 82.0], 'g' )
plt.text(62.5, 76.5, 33, fontsize=6)
plt.plot([42.0, 47.0], [98.0, 71.0], 'g' )
plt.text(44.5, 84.5, 27, fontsize=6)
plt.plot([3.0, 42.0], [34.0, 98.0], 'g' )
plt.text(22.5, 66.0, 75, fontsize=6)
plt.plot([65.0, 47.0], [52.0, 71.0], 'g' )
plt.text(56.0, 61.5, 26, fontsize=6)
plt.plot([0.0, 65.0], [99.0, 52.0], 'g' )
plt.text(32.5, 75.5, 80, fontsize=6)
plt.plot([48.0, 80.0], [67.0, 20.0], 'g' )
plt.text(64.0, 43.5, 57, fontsize=6)
plt.plot([69.0, 47.0], [90.0, 71.0], 'g' )
plt.text(58.0, 80.5, 29, fontsize=6)
plt.plot([22.0, 69.0], [22.0, 90.0], 'g' )
plt.text(45.5, 56.0, 83, fontsize=6)
plt.plot([50.0, 69.0], [75.0, 90.0], 'g' )
plt.text(59.5, 82.5, 24, fontsize=6)
plt.plot([9.0, 42.0], [93.0, 98.0], 'g' )
plt.text(25.5, 95.5, 33, fontsize=6)
plt.plot([7.0, 42.0], [17.0, 98.0], 'g' )
plt.text(24.5, 57.5, 88, fontsize=6)
plt.plot([5.0, 78.0], [50.0, 82.0], 'g' )
plt.text(41.5, 66.0, 80, fontsize=6)
plt.plot([13.0, 80.0], [7.0, 20.0], 'g' )
plt.text(46.5, 13.5, 68, fontsize=6)
plt.plot([64.0, 13.0], [70.0, 7.0], 'g' )
plt.text(38.5, 38.5, 81, fontsize=6)
plt.plot([78.0, 64.0], [25.0, 70.0], 'g' )
plt.text(71.0, 47.5, 47, fontsize=6)
plt.plot([90.0, 78.0], [14.0, 25.0], 'g' )
plt.text(84.0, 19.5, 16, fontsize=6)
plt.plot([99.0, 78.0], [95.0, 25.0], 'g' )
plt.text(88.5, 60.0, 73, fontsize=6)
plt.plot([38.0, 64.0], [60.0, 70.0], 'g' )
plt.text(51.0, 65.0, 28, fontsize=6)
plt.plot([68.0, 38.0], [28.0, 60.0], 'g' )
plt.text(53.0, 44.0, 44, fontsize=6)
plt.plot([82.0, 68.0], [70.0, 28.0], 'g' )
plt.text(75.0, 49.0, 44, fontsize=6)
plt.plot([25.0, 68.0], [66.0, 28.0], 'g' )
plt.text(46.5, 47.0, 57, fontsize=6)
plt.plot([6.0, 68.0], [42.0, 28.0], 'g' )
plt.text(37.0, 35.0, 64, fontsize=6)
plt.plot([20.0, 90.0], [46.0, 14.0], 'g' )
plt.text(55.0, 30.0, 77, fontsize=6)
plt.plot([27.0, 78.0], [45.0, 25.0], 'g' )
plt.text(52.5, 35.0, 55, fontsize=6)
plt.plot([51.0, 27.0], [38.0, 45.0], 'g' )
plt.text(39.0, 41.5, 25, fontsize=6)
plt.show()
