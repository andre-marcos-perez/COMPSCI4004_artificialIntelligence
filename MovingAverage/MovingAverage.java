/**
	Program: 		Moving Average
	Author: 		André Perez
	Contact: 		andre_mperez@hotmail.com
	Last Modified: 		10 October 2015
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class MovingAverage {
		
	public static void main(String[] args){
		
		// # INPUT #
		
		int samplingRate = GetSamplingRate();
		int dataCounter = samplingRate * 300;
		double[] originalData = GetDataFile();
		double[] modifiedData = new double[dataCounter];
		
		// # DATA PROCESSING #
		
			// - Moving Average
		
		int k1=5, k2=5;
		while(k1 <= 15){
			
			for(int i=k1*samplingRate ; i<(dataCounter-k1*samplingRate); i++){
				
				modifiedData[i] = 0;
				for(int j=k1*samplingRate ; j>0 ; j--){
				
					modifiedData[i] += originalData[i-j];
				}
				
				for(int j=0 ; j<=k1*samplingRate ; j++){
					
					modifiedData[i] += originalData[i+j];
				}
				
				modifiedData[i] = modifiedData[i] / (double)((k1+k2)*samplingRate + 1);
			}
			
			modifiedData = NormalizeData(modifiedData, originalData,dataCounter);
			PutDataFile(dataCounter, modifiedData, "normalizedModifiedData"+ k1 +".txt");
			
			k1 += 5;
			k2 = k1;
		}
		
		// # OUTPUT #
		
		originalData = NormalizeData(originalData, originalData, dataCounter);
		PutDataFile(dataCounter, originalData, "normalizedOriginalData.txt");
	}
	
	public static int GetSamplingRate(){
		
		//Gets the Sampling Rate in kilo Hertz (kHz).
		Scanner fileInput = null;
		try{
			
			fileInput = new Scanner(new FileInputStream("originalData.txt"));
		}
		catch(FileNotFoundException e){
			
			System.out.println("SR: File not found !");
			System.exit(0);
		}
		
		int dataCounter=0, samplingRate, audioLength=300;
		while(fileInput.hasNextLine()){
			
			fileInput.nextLine();
			dataCounter++;
		}
		
		fileInput.close();
		samplingRate = dataCounter / audioLength;
		return samplingRate;
	}
	
	public static double[] GetDataFile(){
		
		Scanner fileInput = null;
		try{
			
			fileInput = new Scanner(new FileInputStream("originalData.txt"));
		}
		catch(FileNotFoundException e){
			
			System.out.println("GETDATA: File not found !");
			System.exit(0);
		}
			
		int dataCounter=0;		
		while(fileInput.hasNextLine()){
			
			fileInput.nextLine();
			dataCounter++;
		}
		
		fileInput.close();
		fileInput = null;
		try{
			
			fileInput = new Scanner(new FileInputStream("originalData.txt"));
		}
		catch(FileNotFoundException e){
			
			System.out.println("GETDATA: File not found !");
			System.exit(0);
		}
		
		double[] fileData = new double[dataCounter];
		for(int i=0 ; i<dataCounter ; i++){
			
			fileData[i] = fileInput.nextInt();
			if(fileInput.hasNextLine()){
				
				fileInput.nextLine();
			}
		}
		
		fileInput.close();
		return fileData;
	}
	
	public static double[] NormalizeData(double[] modifiedArray, double[] originalArray,int dataCounter){
		
		double max = Double.MIN_VALUE;
		for(int i=0 ; i<dataCounter ; i++){
			
			if(Math.abs(originalArray[i])>max){
				
				max = Math.abs(originalArray[i]);
			}
		}
		
		for(int i=0 ; i<dataCounter ; i++){
			
			modifiedArray[i] = modifiedArray[i] / max;
		}
		
		return modifiedArray;
	}
	
	public static void PutDataFile(int dataCounter, double[] dataArray, String fileName){
		
		PrintWriter fileOutput = null;
		try{
			
			fileOutput = new PrintWriter(new FileOutputStream(fileName));
		}
		catch(FileNotFoundException e){
			
			System.out.println("PUTDATA: File not found !");
			System.exit(0);
		}
		
		for(int i=0 ; i<dataCounter ; i++){
			
			fileOutput.println(dataArray[i]);
		}
		
		fileOutput.close();
	}
}
