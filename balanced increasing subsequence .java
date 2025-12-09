import java.util.*;

public class balance 
{
    public static int endingindex (int arr[], int n)
    {
        if (n==0)
        {
            return 1;
        }

        int mx = 1;
        for (int i=0;i<n;i++)
        {
            if(arr[i] < arr[n])
            {
                mx = Math.max(mx, 1 + endingindex(arr, i));
            }
        }

        return mx;
    }

    public static int list (int [] arr)
    {
        int n = arr.length;
        int res = 1;
        for(int idx = 1;idx < n;idx ++)
        {
            res = Math.max(res, endingindex(arr, idx));
        }

        return res;
    }

    public static void main (String [] args)
    {
        int [] arr = {10,22,9,33,21,50,41,60};
        System.out.println(list(arr));
    }
}