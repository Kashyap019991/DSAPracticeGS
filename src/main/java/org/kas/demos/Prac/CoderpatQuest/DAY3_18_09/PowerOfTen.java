package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

public class PowerOfTen
{
  /**
   * Returns true if x is a power-of-10.
   * A number is a power of 10 if it is a positive integer that can be
   * expressed as 10^n for some non-negative integer n.
   *
   * @param x The integer to check.
   * @return true if x is a power of 10, false otherwise.
   */
  public static boolean isPowerOf10(int x)
  {
    // Powers of 10 are always positive.
    // 0 and negative numbers cannot be powers of 10.
    if (x <= 0) {
      return false;
    }

    // Repeatedly divide x by 10 as long as it's divisible.
    // A number that is a power of 10 will eventually become 1.
    while( x % 10 == 0) {
      x /= 10;
    }

    // If the final result is 1, the original number was a power of 10.
    // For example, 100 -> 10 -> 1.
    // The number 1 itself is 10^0, so it passes this check immediately.
    return x == 1;
  }

  public static boolean doTestsPass()
  {
    // List of numbers that are powers of 10.
    int[] isPowerList = {1, 10, 100, 1000, 1000000000};
    
    // List of numbers that are not powers of 10.
    int[] isNotPowerList = {3, 0, 101, -10, 20, 999999999};

    for(int i : isPowerList)
    {
      if(!isPowerOf10(i))
      {
        System.out.println("Test failed for: " + i);
        return false;
      }
    }

    for(int i : isNotPowerList)
    {
      if(isPowerOf10(i))
      {
        System.out.println("Test failed for: " + i);
        return false;
      }
    }

    System.out.println("All tested passed");
    return true;
  };


  public static void main(String args[])
  {
    doTestsPass();
  }
}