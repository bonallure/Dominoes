package dominoes;

import java.util.Set;

public class DominoHighLowImpl_Mwamba implements Domino{
	private int highPipCount;
    private int lowPipCount;

    public DominoHighLowImpl_Mwamba (int highPipCount, int lowPipCount)
    {
    	this.highPipCount = highPipCount;
    	this.lowPipCount = lowPipCount;
    }
    
    public static final char HIGH_LOW_STRING_SEPARATOR = ':'; 
	 
 	public static boolean isHighLowString(String str) 
 	{ 
 		boolean isHighLowString = false;
 	 	int stringSeparatorIndex = str.indexOf(HIGH_LOW_STRING_SEPARATOR);
 	 	String highString = str.substring(0, stringSeparatorIndex).strip();
 	 	String lowString = str.substring(stringSeparatorIndex+1).strip();
 	 	char highChar = highString.charAt(0);
 	 	char lowChar = lowString.charAt(0);
 
 	 	if (highString.length() != 1 || lowString.length() != 1 || ! Character.isDigit(highChar) || ! Character.isDigit(lowChar)) return isHighLowString;
 	 	int highCharDigit = Integer.parseInt(highString);
 	 	int lowCharDigit = Integer.parseInt(lowString);
 	 	boolean isHighValid = highCharDigit >= MINIMUM_PIP_COUNT && highCharDigit <= MAXIMUM_PIP_COUNT;
 	 	boolean isLowValid = lowCharDigit >= MINIMUM_PIP_COUNT && lowCharDigit <= MAXIMUM_PIP_COUNT;
 	 	isHighLowString = isHighValid && isLowValid;
 	 	return isHighLowString;
 	} 

 	public DominoHighLowImpl_Mwamba(String highLowString) 
 	{ 
 		boolean isValid = DominoHighLowImpl_Mwamba.isHighLowString(highLowString);
 		if (! isValid) return;
 	 	int stringSeparatorIndex = highLowString.indexOf(HIGH_LOW_STRING_SEPARATOR);
 		String highChar = highLowString.substring(0, stringSeparatorIndex).strip();
 	 	String lowChar = highLowString.substring(stringSeparatorIndex+1).strip();
 	 	 	 	
 	 	int highCharDigit = Integer.parseInt(highChar);
 	 	int lowCharDigit = Integer.parseInt(lowChar);
 	 	
 	 	this.highPipCount = highCharDigit;
 	 	this.lowPipCount = lowCharDigit;
 	} 
	
 	public static final int INDEX_OF_SUM = 0;  	
 	public static final int INDEX_OF_DIFFERENCE = 1;  	

 	//part of pre: sumDifference.length == 2 
 	//part of pre: sumDifference[INDEX_OF_SUM] >= 
 	//   sumDifference[INDEX_OF_DIFFERENCE]  
 	public DominoHighLowImpl_Mwamba(int[] sumDifference) 
 	{ 
 	 	int sum = sumDifference[INDEX_OF_SUM];
 	 	int difference = sumDifference[INDEX_OF_DIFFERENCE];
 	 	int highPipCount; int lowPipCount;
 	 	boolean evenSum = isEven(sum);
 	 	int temp = sum/2;
 	 	
 	 	if(evenSum) {
 	 		highPipCount = temp;
 	 		lowPipCount = temp;
 	 	}
 	 	else {
 	 		highPipCount = temp+1;
 	 		lowPipCount = temp;
 	 	}
 	 	while(difference != (highPipCount-lowPipCount)) {
 	 		highPipCount ++;
 	 		lowPipCount --;
 	 		
 	 	}
 	 	this.highPipCount = highPipCount;
 	 	this.lowPipCount = lowPipCount;
 	} 

 	//part of pre: 1<= highLowSet.size() <= 2  	
 	//part of pre: ! highLowSet.contains(null) 
 	public DominoHighLowImpl_Mwamba(Set<Integer> highLowSet) 
 	{ 
 		Object[] highLowArray = highLowSet.toArray();
 		int tempPipCount = (int) highLowArray[0];
 	 	
 		if (highLowSet.size()==1) {
 	 		this.highPipCount = tempPipCount;
 	 		this.lowPipCount = tempPipCount;
 	 	}
 	 	else {
 	 		int temp2PipCount = (int)highLowArray[1];
 	 		int test = tempPipCount - temp2PipCount; // to see which number is greater
 	 		if (test < 0) {
 	 			this.highPipCount = temp2PipCount;
 	 			this.lowPipCount = tempPipCount;
 	 		}
 	 		else {
 	 			this.lowPipCount = temp2PipCount;
 	 			this.highPipCount = tempPipCount;
 	 		}
 	 	}
 	} 
 	public static boolean isEven(int pipCount) {
 		boolean isEven = pipCount % 2 == 0;
 		return isEven;
 	}

	@Override
	public int getHighPipCount() {
		return this.highPipCount;
	}

	@Override
	public int getLowPipCount() {
		return this.lowPipCount;
	}
}
