********************************************************************************************************
********************************************************************************************************
*********************************************# dekoperez #**********************************************
********************************************************************************************************
********************************************************************************************************

Contact: 		

  andre_mperez@hotmail.com

Folder Description:

  IdealDelay.java
    
    Delays a 300ms of an audio signal (originalData.txt) 5, 10 and 15ms.
  
  DataProcessing.java
    
    Get data parameters.
    Handles file i/o.
    
  matlabPlot.m
  
    Plots both signals
  
Input:

  Audio samples: 300ms of audio signal sampled at 8kHz -> 2400 samples.
  
Output:

  Audio samples (normalizedOriginalData.txt) normalized at MAX{|originalData.txt|}.
  Audio samples delayed 5ms (normalizedModifiedData5.txt) normalized at MAX{|originalData.txt|}.
  Audio samples delayed 10ms (normalizedModifiedData10.txt) normalized at MAX{|originalData.txt|}.
  Audio samples delayed 15ms (normalizedModifiedData15.txt) normalized at MAX{|originalData.txt|}.
  
Mathematical Description:

  Delayed Function:
                                         { y[n] = delayed signal
      y[n] = s[n-β]               where: { s[n-β] = audio signal 
                                         { β = (delay in seconds) * (sampling rate)

********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
