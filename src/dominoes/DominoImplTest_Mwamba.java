package dominoes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import dominoes.Domino;
import dominoes.DominoHighLowImpl_Mwamba;
import dominoes.DominoHighLowSetImpl_Mwamba;
import dominoes.DominoLowDifferenceStringImpl_Mwamba;

class DominoImplTest_Mwamba {
	Domino sixSix = new DominoHighLowImpl_Mwamba(6, 6);
	Domino sixFive = new DominoHighLowImpl_Mwamba(6, 5);
	// Domino fiveSix = new DominoHighLowImpl_Mwamba(5, 6);
	Domino zeroZero = new DominoHighLowImpl_Mwamba(0, 0);
	
	int sixSixHighPipCount = sixSix.getHighPipCount();
	int sixSixLowPipCount = sixSix.getLowPipCount();
	int sixFiveHighPipCount = sixFive.getHighPipCount();
	int sixFiveLowPipCount = sixFive.getLowPipCount();
	//int fiveSixHighPipCount = fiveSix.getHighPipCount();
	//int fiveSixLowPipCount = fiveSix.getLowPipCount();
	int zeroZeroHighPipCount = zeroZero.getHighPipCount();
	int zeroZeroLowPipCount = zeroZero.getLowPipCount();
	String validString1 = "2 :  3 ";
	String validString2 = "2:3";
	String invalidString1 = "7 :  5 ";
	String invalidString2 = "a :  5 ";
	String invalidString3 = "b:D";
	
	
	@Test
	void DominoHighLowImpl_Mwamba_Test() {
		

		String errorMessageSixSixHighPipCount = "actualHighPipCount = " + sixSixHighPipCount + " <> " + 6 + " = expectedPipCount!";
		assertTrue(errorMessageSixSixHighPipCount, 6 == sixSixHighPipCount);
		
		String errorMessageSixSixLowPipCount = "actualLowPipCount = " + sixSixLowPipCount + " <> " + 6 + " = expectedPipCount!";
		assertTrue(errorMessageSixSixLowPipCount, 6 == sixSixLowPipCount);
		
		String errorMessageSixFiveHighPipCount = "actualHighPipCount = " + sixFiveHighPipCount + " <> " + 6 + " = expectedPipCount!";
		assertTrue(errorMessageSixFiveHighPipCount, 6 == sixFiveHighPipCount);
		
		String errorMessageSixFiveLowPipCount = "actualLowPipCount = " + sixFiveLowPipCount + " <> " + 5 + " = expectedPipCount!";
		assertTrue(errorMessageSixFiveLowPipCount, 5 == sixFiveLowPipCount);
		
		//String errorMessageFiveSixHighPipCount = "actualHighPipCount = " + fiveSixHighPipCount + " <> " + 6 + " = expectedPipCount!";
		//assertTrue(errorMessageFiveSixHighPipCount, 6 == fiveSixHighPipCount);
		
		//String errorMessageFiveSixLowPipCount = "actualLowPipCount = " + fiveSixLowPipCount + " <> " + 5 + " = expectedPipCount!";
		//assertTrue(errorMessageFiveSixLowPipCount, 5 == fiveSixLowPipCount);
		
		String errorMessageZeroZeroHighPipCount = "actualHighPipCount = " + zeroZeroHighPipCount + " <> " + 0 + " = expectedPipCount!";
		assertTrue(errorMessageZeroZeroHighPipCount, 0 == zeroZeroHighPipCount);
		
		String errorMessageZeroZeroLowPipCount = "actualLowPipCount = " + zeroZeroLowPipCount + " <> " + 0 + " = expectedPipCount!";
		assertTrue(errorMessageZeroZeroLowPipCount, 0 == zeroZeroLowPipCount);
		System.out.println("we made it all the way through!");
	}
	
	@Test
	void isHighLowString_Test() {
		System.out.println("we made it all the way through again!");
		boolean isValidString1Valid = DominoHighLowImpl_Mwamba.isHighLowString(validString1);
		boolean isValidString2Valid = DominoHighLowImpl_Mwamba.isHighLowString(validString2);
		boolean isInvalidString1Valid = DominoHighLowImpl_Mwamba.isHighLowString(invalidString1);
		boolean isInvalidString2Valid = DominoHighLowImpl_Mwamba.isHighLowString(invalidString2);
		boolean isInvalidString3Valid = DominoHighLowImpl_Mwamba.isHighLowString(invalidString3);
		System.out.println("we made it all the way through here this time!");
		assertTrue(isValidString1Valid);
		assertTrue(isValidString2Valid);
		assertTrue(! isInvalidString1Valid);
		assertTrue(! isInvalidString2Valid);
		assertTrue(! isInvalidString3Valid);
	}
	
	@Test
	void DominoHighLowImplSumDifference_Test() {
		int sum1 = sixSix.getHighPipCount() + sixSix.getLowPipCount();
		int difference1 = sixSix.getHighPipCount() - sixSix.getLowPipCount();
		int sum2 = sixFive.getHighPipCount() + sixFive.getLowPipCount();
		int difference2 = sixFive.getHighPipCount() - sixFive.getLowPipCount();
		int[] sixSixSumDifference = new int[2];
		sixSixSumDifference[0] = sum1;
		sixSixSumDifference[1] = difference1;
		int[] sixFiveSumDifference2 = new int[2];
		sixFiveSumDifference2[0] = sum2;
		sixFiveSumDifference2[1] = difference2;
		Domino testDomino1 = new DominoHighLowImpl_Mwamba(sixSixSumDifference);
		Domino testDomino2 = new DominoHighLowImpl_Mwamba(sixFiveSumDifference2);
		
		assertTrue(6 == testDomino1.getHighPipCount());
		assertTrue(6 == testDomino1.getLowPipCount());
		assertTrue(6 == testDomino2.getHighPipCount());
		String errorMessageDomino2 = "actual = "+ testDomino2.getLowPipCount() + "<> expected = 5";
		assertTrue(errorMessageDomino2, 5 == testDomino2.getLowPipCount());
		System.out.println("Another one that we've gone through!");
	}
	
	@Test
	void DominoHighLowImplSet_Test() {
		Set<Integer> sixSixSet = new HashSet<Integer>();
		sixSixSet.add(sixSix.getHighPipCount());
		sixSixSet.add(sixSix.getLowPipCount());
		Set<Integer> sixFiveSet = new HashSet<Integer>();
		sixFiveSet.add(sixFive.getHighPipCount());
		sixFiveSet.add(sixFive.getLowPipCount());
		Domino sixSixTestDomino = new DominoHighLowImpl_Mwamba(sixSixSet);
		Domino sixFiveTestDomino = new DominoHighLowImpl_Mwamba(sixFiveSet);
		assertTrue(6 == sixSixTestDomino.getHighPipCount());
		assertTrue(6 == sixSixTestDomino.getLowPipCount());
		assertTrue(6 == sixFiveTestDomino.getHighPipCount());
		assertTrue(5 == sixFiveTestDomino.getLowPipCount());
		System.out.println("The last one that we've gone through!");
	}

	@Test
	void isSumDifferenceString_Test() {
		boolean isString1SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("9,1");//should pass
		boolean isString2SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("1,5");//shouldn't pass
		boolean isString3SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("1,0");//shouldn't pass
		boolean isString4SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("8,3");//shouldn't pass
		boolean isString5SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("7,1");//should pass
		boolean isString6SumDifference = DominoHighLowSetImpl_Mwamba.isSumDifferenceString("3,3");//should pass
		assertTrue("the first", isString1SumDifference);
		assertTrue("the second", ! isString2SumDifference);
		assertTrue("the third", ! isString3SumDifference);
		assertTrue("the forth", ! isString4SumDifference);
		assertTrue("the fifth", isString5SumDifference);
		assertTrue("the sixth", isString6SumDifference);
		System.out.println("New class but same winning energy!");
	}
	
	@Test
	void isLowPlus8TimesHighInteger_Test() {
		boolean is2Plus8Times5Valid = DominoHighLowSetImpl_Mwamba.isLowPlus8TimesHighInteger(2+8*5);
		boolean is7Plus8Times5Valid = DominoHighLowSetImpl_Mwamba.isLowPlus8TimesHighInteger(7+8*5);
		assertTrue("42 doesn't work", is2Plus8Times5Valid);
		assertTrue("47 works, but shouldn't", ! is7Plus8Times5Valid);
		System.out.println("low + 8*high is good.");
	}
	
	@Test
	void DominoHighLowSetImpl_Mwamba_Test() {
		Domino validDominoSet = new DominoHighLowSetImpl_Mwamba(2+8*5);
		//Domino invalidDominoSet = new DominoHighLowSetImpl_Mwamba(7+8*5);
		assertTrue("failed here", validDominoSet.getHighPipCount() == 5);
		assertTrue(validDominoSet.getLowPipCount() == 2);
		//assertTrue("invalid set", invalidDominoSet.getHighPipCount() == (Integer) null);
		//assertTrue(invalidDominoSet.getLowPipCount() == (Integer) null);
	}
	
	@Test
	void DominoLowDifferenceStringImpl_Mwamba_Test() {
		Domino fiveTwoDomino = new DominoLowDifferenceStringImpl_Mwamba(42);
		Domino twoTwoDomino = new DominoLowDifferenceStringImpl_Mwamba(18);
		assertTrue("5 2 high is no good", fiveTwoDomino.getHighPipCount() == 5);
		assertTrue("5 2 low is no good", fiveTwoDomino.getLowPipCount() == 2);
		assertTrue("2 2 high is no good", twoTwoDomino.getHighPipCount() == 2);
		assertTrue("2 2 low is no good", twoTwoDomino.getLowPipCount() == 2);
		System.out.println("Ohlala, new class still doing it big!");
		
		ArrayList<Integer> fiveTwoDominoHighSum = new ArrayList<Integer>(2);
		ArrayList<Integer> twoTwoDominoHighSum = new ArrayList<Integer>(2);
		fiveTwoDominoHighSum.add(0,fiveTwoDomino.getHighPipCount());
		fiveTwoDominoHighSum.add(1, fiveTwoDomino.getHighPipCount()+fiveTwoDomino.getLowPipCount());
		twoTwoDominoHighSum.add(0, twoTwoDomino.getHighPipCount());
		twoTwoDominoHighSum.add(1, twoTwoDomino.getHighPipCount()+twoTwoDomino.getLowPipCount());
		Domino fiveTwoDomino2 = new DominoLowDifferenceStringImpl_Mwamba(fiveTwoDominoHighSum);
		Domino twoTwoDomino2 = new DominoLowDifferenceStringImpl_Mwamba(twoTwoDominoHighSum);
		assertTrue(fiveTwoDomino2.getHighPipCount() == 5);
		assertTrue(fiveTwoDomino2.getLowPipCount() == 2);
		assertTrue(twoTwoDomino2.getHighPipCount() == 2);
		assertTrue(twoTwoDomino2.getLowPipCount() == 2);
		System.out.println("Allez, c'est bel et bien fini!");
	}
	
}
