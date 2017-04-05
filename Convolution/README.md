#Convolution

@File: Convolution.java
    Convolves 300ms of an audio signal (originalData.txt) with a rectangular window of 10ms.
    
@File: DataProcessing.java
    Get data parameters.
    Handles file i/o.

@File: matlabPlot.m
    Plots original and convolved signals.
  
@Input:
    Audio samples: 300ms of audio signal sampled at 8kHz -> 2400 samples.
  
@Output:
    Audio file (normalizedOriginalData.txt) normalized at MAX{|originalData.txt|}.
    Colvolved signal (normalizedModifiedData.txt) normalized at MAX{|originalData.txt|}.
  
@Mathematical Description:

  Convolution:

             ∞                           { y[n] = convolved signal
      y[n] = Σ s[k]w[n-k]         where: { s[k] = audio signal 
            k=-∞                         { w[n-k] = rectangular window
            
  Rectangular Window:
  
      w[n] = { 1 ∀ 0 ≤ n < N-1    where: N = Window Length
             { 0 otherwise 
  
