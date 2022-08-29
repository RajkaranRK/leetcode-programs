package com.rk;

public class GKH
{
    static int MAX = 26;

    // Function to return the lexicographically
// smallest string after swapping all the
// occurrences of any two characters
    static String smallestStr(char []str, int n)
    {
        int i, j = 0;

        // To store the first index of
        // every character of str
        int []chk = new int[MAX];
        for (i = 0; i < MAX; i++)
            chk[i] = -1;

        // Store the first occurring
        // index every character
        for (i = 0; i < n; i++)
        {

            // If current character is appearing
            // for the first time in str
            if (chk[str[i] - 'a'] == -1)
                chk[str[i] - 'a'] = i;
        }

        // Starting from the leftmost character
        for (i = 0; i < n; i++)
        {
            boolean flag = false;

            // For every character smaller than str[i]
            for (j = 0; j < str[i] - 'a'; j++)
            {

                // If there is a character in str which is
                // smaller than str[i] and appears after it
                if (chk[j] > chk[str[i] - 'a'])
                {
                    flag = true;
                    break;
                }
            }

            // If the required character pair is found
            if (flag)
                break;
        }

        // If swapping is possible
        if (i < n-1)
        {

            // Characters to be swapped
            char ch1 = str[i];
            char ch2 = (char) (j + 'a');

            // For every character
            for (i = 0; i < n; i++)
            {

                // Replace every ch1 with ch2
                // and every ch2 with ch1
                if (str[i] == ch1)
                    str[i] = ch2;

                else if (str[i] == ch2)
                    str[i] = ch1;
            }
        }

        return String.valueOf(str);
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "bdea";
        int n = str.length();

        System.out.println(smallestStr(
                str.toCharArray(), n));
    }
}
