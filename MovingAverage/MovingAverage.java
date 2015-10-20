/**
	Program: 		Moving Average
	Author: 		André Perez
	Contact: 		andre_mperez@hotmail.com
	Last Modified: 		18 October 2015
*/

public class MovingAverage {
		
	public static void main(String[] args){
		
		// # INPUT #
		
		DataProcessing data = new DataProcessing();
		data.GetDataParameters();
		data.GetDataFromFile();
		
		// # DATA PROCESSING #
		
			// - Moving Average
		
		int k1=5, k2=5;
		while(k1 <= 15){
			
			for(int i=k1*data.GetSamplingRate() ; i<(data.GetDataCounter()-k1*data.GetSamplingRate()); i++){
				
				data.modifiedData[i] = 0;
				for(int j=k1*data.GetSamplingRate() ; j>0 ; j--){
				
					data.modifiedData[i] += data.originalData[i-j];
				}
				
				for(int j=0 ; j<=k1*data.GetSamplingRate() ; j++){
					
					data.modifiedData[i] += data.originalData[i+j];
				}
				
				data.modifiedData[i] = data.modifiedData[i] / (double)((k1+k2)*data.GetSamplingRate() + 1);
			}
			
			data.modifiedData = data.NormalizeData(data.modifiedData, data.originalData);
			data.PutDataFile(data.modifiedData, "normalizedModifiedData"+ k1 +".txt");
			
			k1 += 5;
			k2 = k1;
		}
		
		// # OUTPUT #
		
		data.originalData = data.NormalizeData(data.originalData, data.originalData);
		data.PutDataFile(data.originalData, "normalizedOriginalData.txt");
	}
}
