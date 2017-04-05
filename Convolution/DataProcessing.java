/**
	Program: 	Data Processing
	@author:	André Perez
	Contact: 	2221166p@student.gla.ac.uk
	Last Modified: 	18 October 2015
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataProcessing {
	
	// Static Fields
	
	private int dataCounter=0;
	private int samplingRate;
	private int audioLength=300;
	
	public double[] originalData;
	public double[] modifiedData;
	
	// Constructors
	
	DataProcessing(){
				
	}
	
	// Setter and Getter Methods
	
	public int GetDataCounter(){
		
		return this.dataCounter;
	}
	
	public int GetSamplingRate(){
		
		return this.samplingRate;
	}
	
	public void GetDataParameters(){
		
		Scanner fileInput = null;
		try{
			
			fileInput = new Scanner(new FileInputStream("originalData.txt"));
		}
		catch(FileNotFoundException e){
			
			System.out.println("SR: File not found !");
			System.exit(0);
		}		
		
		while(fileInput.hasNextLine()){
			
			fileInput.nextLine();
			this.dataCounter++;
		}
		
		fileInput.close();
		this.samplingRate = this.dataCounter / this.audioLength;
	}
	
	public void GetDataFromFile(){
		
		Scanner fileInput = null;
		this.originalData = new double[this.dataCounter];
		this.modifiedData = new double[this.dataCounter];
		try{
			
			fileInput = new Scanner(new FileInputStream("originalData.txt"));
		}
		catch(FileNotFoundException e){
			
			System.out.println("GETDATA: File not found !");
			System.exit(0);
		}
		
		for(int i=0 ; i<dataCounter ; i++){
			
			this.originalData[i] = fileInput.nextInt();
			if(fileInput.hasNextLine()){
				
				fileInput.nextLine();
			}
		}
		
		fileInput.close();
	}
	
	// Methods

	public double[] NormalizeData(double[] modifiedArray, double[] originalArray){
		
		double max = Double.MIN_VALUE;
		for(int i=0 ; i<this.dataCounter ; i++){
			
			if(Math.abs(originalArray[i])>max){
				
				max = Math.abs(originalArray[i]);
			}
		}
		
		for(int i=0 ; i<this.dataCounter ; i++){
			
			modifiedArray[i] = modifiedArray[i] / max;
		}
		
		return modifiedArray;
	}
	
	public void PutDataFile(double[] dataArray, String fileName){
		
		PrintWriter fileOutput = null;
		try{
			
			fileOutput = new PrintWriter(new FileOutputStream(fileName));
		}
		catch(FileNotFoundException e){
			
			System.out.println("PUTDATA: File not found !");
			System.exit(0);
		}
		
		for(int i=0 ; i<this.dataCounter ; i++){
			
			fileOutput.println(dataArray[i]);
		}
		
		fileOutput.close();
	}
}
