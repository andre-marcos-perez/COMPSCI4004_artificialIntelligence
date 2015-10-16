% Program: 		    Moving Average - PLOT
% Author: 		    André Perez
% Contact: 		    andre_mperez@hotmail.com
% Last Modified: 	    10 October 2015

close all;
clear all;
clc;

originalData = csvread('normalizedOriginalData.txt');

k = [5 10 15];

plotLenghtStart = 100;
plotLenghtEnd = 200;
step = 300/2400;
time = 0:step:(300 - step);

for i=1:3

figure(i)

plot(time,originalData,'LineWidth',1);

titleText = strcat('Moving Average: ',int2str(k(i)));
titleText = strcat(titleText,'ms');
title(titleText,'FontSize',16,'FontWeight','bold');
xlabel('Time (ms)','FontSize',12,'FontWeight','bold');
axis([plotLenghtStart plotLenghtEnd -0.5 0.5]);
grid on;
hold on;

dataName = strcat('normalizedModifiedData',int2str(k(i)));
dataName = strcat(dataName,'.txt');
modifiedData = csvread(dataName);
plot(time,modifiedData,'r','LineWidth',2);

legend('Signal (Normalized)','Modified Signal (Normalized)','Location','SouthEast');
hold off;

end
