%   Program: 		    Ideal Delay - PLOT
% 	Author: 		    André Perez
% 	Contact: 		    andre_mperez@hotmail.com
% 	Last Modified: 	10 October 2015

close all;
clear all;
clc;

originalData = csvread('normalizedOriginalData.txt');

k = [5 10 15];

plotLenght = 50;
step = 300/2400;
time = 0:step:(300 - step);

for i=1:3

figure(i)

plot(time,originalData,'LineWidth',2);

titleText = strcat('Ideal Delay: ',int2str(k(i)));
titleText = strcat(titleText,'ms');
title(titleText,'FontSize',16,'FontWeight','bold');
xlabel('Time (ms)','FontSize',12,'FontWeight','bold');
axis([0 plotLenght -1 1]);
grid on;
hold on;

dataName = strcat('normalizedModifiedData',int2str(k(i)));
dataName = strcat(dataName,'.txt');
modifiedData = csvread(dataName);
plot(time,modifiedData,'r','LineWidth',2);

legend('Signal (Normalized)','Modified Signal (Normalized)','Location','SouthEast');
hold off;

end
