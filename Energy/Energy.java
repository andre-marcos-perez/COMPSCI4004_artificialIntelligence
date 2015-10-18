/**
	Program: 		Energy
	Author: 		André Perez
	Contact: 		andre_mperez@hotmail.com
	Last Modified: 	        18 October 2015
*/

public class Energy {
		
	public static void main(String[] args){
		
		// # INPUT #
		
		DataProcessing data = new DataProcessing();
		data.GetDataParameters();
		data.GetDataFromFile();
		
		// # DATA PROCESSING #
		
			// - Energy
		
		int windowLength = 30;
		for(int i=0 ; i<data.GetDataCounter() ; i++){
			
			data.modifiedData[i] = 0;
			for(int k=0 ; k<windowLength*data.GetSamplingRate() ; k++){
				
				if((i-k) >= 0){
					
					data.modifiedData[i] += Math.pow(data.originalData[i-k], 2);
				}
			}
		}
		
		// # OUTPUT #
		
		data.modifiedData = data.NormalizeData(data.modifiedData, data.modifiedData);
		data.PutDataFile(data.modifiedData, "normalizedModifiedData.txt");
		
		data.originalData = data.NormalizeData(data.originalData, data.originalData);
		data.PutDataFile(data.originalData, "normalizedOriginalData.txt");		
	}
}
