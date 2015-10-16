********************************************************************************************************
********************************************************************************************************
*********************************************# dekoperez #**********************************************
********************************************************************************************************
********************************************************************************************************

Contact: 		

  andre_mperez@hotmail.com

Folder Description:

  java file
    
    Averages a 300ms of an audio signal (originalData.txt) 5, 10 and 15ms.
    For each samples, calculates the average of the signal between k1 and k2 (k1 ≤ k < k2).
    Handles file i/o.
    
  matlab file
  
    plots both signals
  
Input:

  Audio samples: 300ms of audio signal sampled at 8kHz -> 2400 samples.
  
Output:

  Audio samples (normalizedOriginalData.txt) normalized at MAX{|originalData.txt|}.
  Audio samples averaged for k1=k2=5ms (normalizedModifiedData5.txt) normalized at MAX{|originalData.txt|}.
  Audio samples averaged for k1=k2=10ms (normalizedModifiedData10.txt) normalized at MAX{|originalData.txt|}.
  Audio samples averaged for k1=k2=15ms (normalizedModifiedData15.txt) normalized at MAX{|originalData.txt|}.
  
Mathematical Description:

  Moving Average:
                     n+k2                { y[n] = averaged signal
      y[n] =___1___   Σ s[k]      where: { s[k] = audio signal 
            k1+k2+1  k=n-k1              { k1 & k2 = (length in seconds) * (sampling rate)
            

********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
