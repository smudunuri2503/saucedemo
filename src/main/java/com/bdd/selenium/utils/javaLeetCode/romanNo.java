package com.bdd.selenium.utils.javaLeetCode;

public class romanNo {
    public static void main(String[] args)
    {
        int num=1994;
        int[] val=new int[4];
        int pos=0;
         String roman="";
        while(num>0)
        {
            val[pos]=num%10;
            num=num/10;
            pos++;
        }
        for(int i=val.length-1;i>=val.length;i--)
        {
            if(i+1==4)
            {
                for(int j=0;j<val[i];j++)
                {
                    roman+="M";
                }
            }
            else if(i+1==3)
            {
                if(val[i]>5)
                {
                    roman+="D";
                    for(int j=0;j<val[i]-5;j++)
                    {
                        roman+="C";
                    }
                }
                else
                {
                    for(int j=0;j<val[i];j++)
                    {
                        roman+="C";
                    }
                }
            }
            else if(i+1==2)
            {
                if(val[i]>5)
                {
                    roman+="L";
                    for(int j=0;j<val[i]-5;j++)
                    {
                        roman+="X";
                    }
                }
                else
                {
                    for(int j=0;j<val[i];j++)
                    {
                        roman+="X";
                    }
                }
            }
            else if(i+1==1)
            {
                if(val[i]>5)
                {
                    roman+="V";
                    for(int j=0;j<val[i]-5;j++)
                    {
                        roman+="I";
                    }
                }
                else
                {
                    for(int j=0;j<val[i];j++)
                    {
                        roman+="I";
                    }
                }
            }
        }
        System.out.println(roman);
    }
}