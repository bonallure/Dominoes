package dominoes;

import java.util.HashSet;
import java.util.Set;

public class DominoHighLowSetImpl_Mwamba implements Domino {

	private Set<Integer> highLowSet = new HashSet<Integer>(); 
	 
 	public DominoHighLowSetImpl_Mwamba(int highPipCount, int lowPipCount) 
 	{ 
 	 	this.highLowSet.add(highPipCount);
 	 	this.highLowSet.add(lowPipCount);
 	} 
 	public static final char SUM_DIFFERENCE_DELIMITER = ',';  	
 	
 	public static boolean isSumDifferenceString(String str) 
 	{ 
 		//System.out.println(str);
 		int stringSeparatorIndex = str.indexOf(SUM_DIFFERENCE_DELIMITER);
 	 	String sum = str.substring(0, stringSeparatorIndex).strip();
 	 	String difference = str.substring(stringSeparatorIndex+1).strip();
 	 	char sumChar = sum.charAt(0);
 	 	char differenceChar = difference.charAt(0);//if you have 1a as the difference this test will fail but we shouldn't be passed erroneous values.
 	 	boolean areValuesDigits = (Character.isDigit(sumChar) && Character.isDigit(differenceChar));
 	 	int sumDigit = Integer.parseInt(sum);
 	 	int differenceDigit = Integer.parseInt(difference);
 	 	int highPipCount; int lowPipCount;
 	 	boolean evenDifference = DominoHighLowImpl_Mwamba.isEven(differenceDigit);
 	 	int temp = sumDigit/2;
 	 	int temp2 = differenceDigit/2;
 	
 		highPipCount = temp;
 		lowPipCount = temp;
 		if(evenDifference) {
 			highPipCount += temp2;
 			lowPipCount -= temp2;
 		}
 		else {
 			highPipCount += (temp2+1);
 			lowPipCount -= temp2;
 		}
 		boolean sumGreaterThanOrEqualToDifference = sumDigit >= differenceDigit;
 		boolean isSumValid = (highPipCount + lowPipCount == sumDigit);
 		boolean isDifferenceValid = (highPipCount - lowPipCount == differenceDigit);
 	 	boolean isSumDifferenceString = (areValuesDigits && isSumValid && isDifferenceValid && sumGreaterThanOrEqualToDifference);
 	 	return isSumDifferenceString;
 	} 
	 
 	public DominoHighLowSetImpl_Mwamba(String sumDifferenceString) 
 	{ 
 	 	boolean isStringValid = isSumDifferenceString(sumDifferenceString);
 	 	if (! isStringValid) return;
 	 	int stringSeparatorIndex = sumDifferenceString.indexOf(SUM_DIFFERENCE_DELIMITER);
 	 	String sum = sumDifferenceString.substring(0, stringSeparatorIndex).strip();
 	 	String difference = sumDifferenceString.substring(stringSeparatorIndex+1).strip();
 	 	int sumDigit = Integer.parseInt(sum);
 	 	int differenceDigit = Integer.parseInt(difference);
 	 	int highPipCount; int lowPipCount;
 	 	boolean evenDifference = DominoHighLowImpl_Mwamba.isEven(differenceDigit);
 	 	int temp = sumDigit/2;
 	 	int temp2 = differenceDigit/2;
 		highPipCount = temp;
 		lowPipCount = temp;
 		if(evenDifference) {
 			highPipCount += temp2;
 			lowPipCount -= temp2;
 		}
 		else {
 			highPipCount += (temp2+1);
 			lowPipCount -= temp2;
 		}
 	 	this.highLowSet.add(highPipCount);
 	 	this.highLowSet.add(lowPipCount);
 	} 

 	public static boolean isLowPlus8TimesHighInteger(int k) 
 	{ 
 	 	HashSet<Integer> possiblePipCounts = createPossiblePipCounts();
 	 	boolean isLowPlus8TimesHighInteger = false;
 	 	for(int i = 6; i >= 0; i--) {
 	 		int temp = i*8;
 	 		int temp2 = k-temp;
 	 		if (possiblePipCounts.contains(temp2)) {
 	 			isLowPlus8TimesHighInteger = true;
 	 			break;
 	 		}
 	 	}
 	 	return isLowPlus8TimesHighInteger;
 	} 
	 
 	public DominoHighLowSetImpl_Mwamba(int lowPlus8TimesHigh) 
 	{ 
 		HashSet<Integer> possiblePipCounts = createPossiblePipCounts();
		int highPipCount;
		int lowPipCount;
		int temp = 0; int temp2 = 0;
		for(int i = 6; i >= 0; i--) {
 	 		temp = i*8;
 	 		temp2 = lowPlus8TimesHigh-temp;
 	 		if (possiblePipCounts.contains(temp2))break;
 	 	}
		highPipCount = temp / 8;
		lowPipCount = temp2;
 		this.highLowSet.add(highPipCount);
 		this.highLowSet.add(lowPipCount);
 	}

	@Override
	public int getHighPipCount() {
		Object[] highLowArray = this.highLowSet.toArray();
 		int tempPipCount = (int) highLowArray[0];
 	 	int highPipCount;
 		if (this.highLowSet.size()==1) {
 	 		highPipCount = tempPipCount;
 	 	}
 	 	else {
 	 		int test = tempPipCount - (int)highLowArray[1]; // to see which number is greater
 	 		if (test < 0) {
 	 			highPipCount = (int)highLowArray[1];
 	 		}
 	 		else {
 	 			highPipCount = tempPipCount;
 	 		}
 	 	}
		return highPipCount;
	}

	@Override
	public int getLowPipCount() {
		Object[] highLowArray = this.highLowSet.toArray();
 		int tempPipCount = (int) highLowArray[0];
 	 	int lowPipCount;
 		if (this.highLowSet.size()==1) {
 	 		lowPipCount = tempPipCount;
 	 	}
 	 	else {
 	 		int test = tempPipCount - (int)highLowArray[1]; // to see which number is greater
 	 		if (test < 0) {
 	 			lowPipCount = tempPipCount;
 	 		}
 	 		else {
 	 			lowPipCount = (int)highLowArray[1];
 	 		}
 	 	}		
 		return lowPipCount;
	} 
	static HashSet<Integer> createPossiblePipCounts(){
		HashSet<Integer> possiblePipCounts = new HashSet<Integer>(7);
 		for (int i = 0; i <= Domino.MAXIMUM_PIP_COUNT; i++) possiblePipCounts.add(i);
 		return possiblePipCounts;
	}

}
