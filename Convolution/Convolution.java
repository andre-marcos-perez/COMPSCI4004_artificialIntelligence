/**
	Program: 		Convolution
	Course: 		Artificial Intelligence
	Laboratory:		#1
	@author:		André Perez
	Contact: 		2221166p@student.gla.ac.uk
	Last Modified: 	18 October 2015
*/

public class Convolution {
		
	public static void main(String[] args){
		
		// # INPUT #

		DataProcessing data = new DataProcessing();
		data.GetDataParameters();
		data.GetDataFromFile();
		
		// # DATA PROCESSING #
		
			// - Convolution
		
		int windowLength = 10;
		for(int i=0 ; i<data.GetDataCounter() ; i++){
			
			data.modifiedData[i] = 0;
			for(int k=0 ; k<windowLength*data.GetSamplingRate() ; k++){
				
				if((i-k) >= 0){
					
					data.modifiedData[i] += data.originalData[i-k];
				}
			}
		}
		
		// # OUTPUT #
		
		data.modifiedData = data.NormalizeData(data.modifiedData, data.originalData);
		data.PutDataFile(data.modifiedData, "normalizedModifiedData.txt");
		
		data.originalData = data.NormalizeData(data.originalData, data.originalData);
		data.PutDataFile(data.originalData, "normalizedOriginalData.txt");
	}
}
