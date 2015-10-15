%   Program: 		    Convolution - PLOT
% 	Author: 		    André Perez
% 	Contact: 		    andre_mperez@hotmail.com
% 	Last Modified: 	10 October 2015

close all;
clear all;
clc;

originalData = csvread('normalizedOriginalData.txt');
modifiedData = csvread('normalizedModifiedData.txt');

plotLenghtStart = 0;
plotLenghtEnd = 300;
step = 300/2400;
time = 0:step:(300 - step);

plot(time,originalData,'LineWidth',1);

title('Convolution - Window Function (10ms)','FontSize',16,'FontWeight','bold');
xlabel('Time (ms)','FontSize',12,'FontWeight','bold');
axis([plotLenghtStart plotLenghtEnd -3 3]);
grid on;
hold on;

plot(time,modifiedData,'r','LineWidth',2);

legend('Signal (Normalized)','Modified Signal (Normalized)','Location','SouthEast');
hold off;
