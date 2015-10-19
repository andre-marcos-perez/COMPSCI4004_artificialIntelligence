/**
	Program: 		Ideal Delay
	Author: 		André Perez
	Contact: 		andre_mperez@hotmail.com
	Last Modified: 		18 October 2015
*/

public class IdealDelay {
		
	public static void main(String[] args){
		
		// # INPUT #
		
		DataProcessing data = new DataProcessing();
		data.GetDataParameters();
		data.GetDataFromFile();
		
		// # DATA PROCESSING #
		
			// - Ideal Delay:  5ms ->  40 samples forward
			// - Ideal Delay: 10ms ->  80 samples forward
			// - Ideal Delay: 15ms -> 120 samples forward
		
		int delay = 5;
		while(delay <= 15){
			
			for(int i=0, j=0 ; i<data.GetDataCounter(); i++){
				
				if(i<delay*data.GetSamplingRate()){
					
					data.modifiedData[i] = 0;
				}
				else{
					
					data.modifiedData[i] = data.originalData[j];
					j++;
				}
			}
			
			data.modifiedData = data.NormalizeData(data.modifiedData, data.originalData);
			data.PutDataFile(data.modifiedData, "normalizedModifiedData"+ delay +".txt");
			
			delay += 5;
		}
		
		// # OUTPUT #
		
		data.originalData = data.NormalizeData(data.originalData, data.originalData);
		data.PutDataFile(data.originalData, "normalizedOriginalData.txt");
	}
}
