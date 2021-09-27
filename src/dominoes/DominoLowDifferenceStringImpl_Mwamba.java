package dominoes;

import java.util.HashSet;
import java.util.List;

public class DominoLowDifferenceStringImpl_Mwamba implements Domino{
	private String lowDifferenceString; 
 	private static final char LOW_DIFFERENCE_DELIMITER = '*';  
 	
 	//pre: DominoHighLowSetImpl_Mwamba.isLowPlus8TimesHighInteger(lowPlus8TimesHigh) == true	
 	//post: lowDifferenceString.length()= 3
 	//		lowDifferenceString.charAt(1).equals('*') == true
 	public DominoLowDifferenceStringImpl_Mwamba(int lowPlus8TimesHigh) 
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
 		int difference = highPipCount - lowPipCount;
 		this.lowDifferenceString = Integer.toString(lowPipCount)+LOW_DIFFERENCE_DELIMITER+Integer.toString(difference);
 	} 
 	public static final int INDEX_OF_HIGH = 0; 
 	public static final int INDEX_OF_SUM = 1; 
	 
	//pre: highSum == ArrayList<Integer>(2)  	
 	//post: lowDifferenceString.length()= 3
 	//		lowDifferenceString.charAt(1).equals('*') == true
 	public DominoLowDifferenceStringImpl_Mwamba(List<Integer> highSum) 
 	{ 
 		if(highSum.size() != 2) return;
 		int highPipCount = highSum.get(INDEX_OF_HIGH);
 		int sum = highSum.get(INDEX_OF_SUM);
 		int lowPipCount = sum - highPipCount;
 		int difference = highPipCount - lowPipCount;
 		this.lowDifferenceString = Integer.toString(lowPipCount)+LOW_DIFFERENCE_DELIMITER+Integer.toString(difference);
 	}

	@Override
	public int getHighPipCount() {
		int stringSeparatorIndex = this.lowDifferenceString.indexOf(LOW_DIFFERENCE_DELIMITER);
 	 	String low = this.lowDifferenceString.substring(0, stringSeparatorIndex).strip();
 	 	String difference = this.lowDifferenceString.substring(stringSeparatorIndex+1).strip();
 	 	int lowPipCount = Integer.parseInt(low);
 	 	int differenceDigit = Integer.parseInt(difference);
 	 	int highPipCount = lowPipCount + differenceDigit;
		return highPipCount;
	}

	@Override
	public int getLowPipCount() {
		int stringSeparatorIndex = this.lowDifferenceString.indexOf(LOW_DIFFERENCE_DELIMITER);
 	 	String low = this.lowDifferenceString.substring(0, stringSeparatorIndex).strip();
 	 	int lowPipCount = Integer.parseInt(low);
		return lowPipCount;
	} 
	static HashSet<Integer> createPossiblePipCounts(){
		HashSet<Integer> possiblePipCounts = new HashSet<Integer>(7);
 		for (int i = 0; i <= Domino.MAXIMUM_PIP_COUNT; i++) possiblePipCounts.add(i);
 		return possiblePipCounts;
	}
}
