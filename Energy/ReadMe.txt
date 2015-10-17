********************************************************************************************************
********************************************************************************************************
*********************************************# dekoperez #**********************************************
********************************************************************************************************
********************************************************************************************************

Contact: 		

  andre_mperez@hotmail.com

Folder Description:

  java file
    
    Short time analysis: Calculates the Energy (see mathematical description)
    of an audio signal 300ms long(originalData.txt) using a rectangular window of 30ms.
    
    Handles file i/o.
    
  matlab file
  
    plots both signals
  
Input:

  Audio samples: 300ms of audio signal sampled at 8kHz -> 2400 samples.
  
Output:

  Audio file (normalizedOriginalData.txt) normalized at MAX{|originalData.txt|}.
  Energy signal (normalizedModifiedData.txt) normalized at MAX{|modifiedData.txt|}.
  
Mathematical Description:

  Short term Energy:
             ∞                           { y[n] = energy signal
      y[n] = Σ s[k]²w[n-k]        where: { s[k] = audio signal 
            k=-∞                         { w[n-k] = rectangular window
            
  Rectangular Window:
  
      w[n] = { 1 ∀ 0 ≤ n< N-1     where: N = Window Length
             { 0 otherwise 
  
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
********************************************************************************************************
