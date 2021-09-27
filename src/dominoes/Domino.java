package dominoes;

public interface Domino {
	public static final int MINIMUM_PIP_COUNT = 0;
	public static final int MAXIMUM_PIP_COUNT = 6;
	/*
    public static final String highLowString = "";
    public static final int[] sumDifference = new int[0];
    public static final Set<Integer> highLowSet = null;
    public static final String sumDifferenceString = "";
    public static final int lowPlus8TimesHigh = 0;
    public static final String lowDifferenceString = "";
    public static final List<Integer> highSum = null;*/
    
	//part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT //part of post: getLowPipCount() <= rv
	public int getHighPipCount();
	
	//part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT //part of post: rv <= getHighPipCount()
	public int getLowPipCount();
	
	
}
