public class SeperatingCash {
    private static int TwoThousand;
    private static int FiveHundred;
    private static int OneHundred;
    public SeperatingCash()
    {

    }
    public SeperatingCash(int TwoThousand, int FiveHundred, int OneHundred)
    {
        this.TwoThousand = TwoThousand;
        this.FiveHundred = FiveHundred;
        this.OneHundred = OneHundred;
    }
    public static int getTwoThousand()
    {
        return TwoThousand;
    }
    public void setTwoThousand(int TwoThousand)
    {
        this.TwoThousand = TwoThousand;
    }
    public static int getFiveHundred()
    {
        return FiveHundred;
    }
    public void setFiveHundred(int FiveHundred)
    {
        this.FiveHundred = FiveHundred;
    }
    public static int getOneHundred()
    {
        return OneHundred;
    }
    public void setOneHundred(int OneHundred)
    {
        this.OneHundred = OneHundred;
    }
}