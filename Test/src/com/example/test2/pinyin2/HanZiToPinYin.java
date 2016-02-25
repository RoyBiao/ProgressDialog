package com.example.test2.pinyin2;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class HanZiToPinYin {
	
	
	
	
	
	/** 
	  * 字符串集合转换字符串(逗号分隔) 
	  * @author wyh 
	  * @param stringSet 
	  * @return 
	  */
	public static String makeStringByStringSet(Set<String>  StringSet)
	{
		StringBuilder str = new StringBuilder();
		int i =0;
		for(String s: StringSet)
		{
			if(i == StringSet.size())
			{
				str.append(s);
			}else
			{
				str.append(s +",");
			}
			i++;
		}
		return  str.toString().toLowerCase();
	}
	/**
	 * 返回一个字的拼音
	 * @param hanzi
	 * @return
	 */
	public static String toPinYin(char hanzi){
		HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
	    hanyuPinyin.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	    hanyuPinyin.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
	    hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
	    String[] pinyinArray=null;
	    try {
	    	//是否在汉字范围内
	    	if(hanzi>=0x4e00 && hanzi<=0x9fa5){
	    		pinyinArray = PinyinHelper.toHanyuPinyinStringArray(hanzi, hanyuPinyin);
	    	}
	    } catch (BadHanyuPinyinOutputFormatCombination e) {
	    	e.printStackTrace();
	    }
	    //将汉字返回
		return pinyinArray[0];
	}
	
	/**
	 * 返回一个字的拼音
	 * @param hanzi
	 * @return
	 */
	public static String toPinYin1(String hanzi){
		HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
	    hanyuPinyin.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	    hanyuPinyin.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//  无音调的
	    hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
	    char[]  t1= null;
	    t1 = hanzi.toCharArray();
	    String t4="";
	    String[] pinyinArray=null;
	    String[] t2 = new String[t1.length];
	    int t0 = t1.length;
	    try {
	       for(int i = 0;i<t0;i++)
	       {
	    	   if(Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
	    	   {
	    		   t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], hanyuPinyin);
	    		   t4 +=t2[0];
	    	   }else
	    	   {
	    		   t4 += Character.toString(t1[i]);
	    	   }
	       }
	    
	    } catch (BadHanyuPinyinOutputFormatCombination e) {
	    	e.printStackTrace();
	    }
	    //将汉字返回
		return t4;
	}
	
	/**
	 *  获取拼音集合 
     * @author wyh 
     * @param src 
    * @return Set<String>
	 */
	public static Set<String>  getpinyin(String src)
	{
		
		if(src!= null && !src.trim().equalsIgnoreCase(""))
		{
			char[] srcChar ;
			srcChar  =src.toCharArray();
			HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
			 hanyuPinyin.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			    hanyuPinyin.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
			    hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
			    String[][] temp = new String[src.length()][];  
			    
			    for(int i=0;i<srcChar.length;i++){  
			    	 char c = srcChar[i]; 
			    	  
			    	 if(String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
			    	 try {
						temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanyuPinyin);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	 }
			    	 else if(((int)c>= 65&&(int) c<=90) || ((int)c>=97 &&(int)c<=122))
			    	 {
			    		 temp[i] = new String[] {String.valueOf(srcChar[i])};
			    	 }
			    	 else
			    	 {
			    		 temp[i] = new String[]{""};
			    	 }
			    	 
			    }
			    	 String[]  pingyinArray = Exchange(temp);
			    	 Set<String>  pingyinSet  = new HashSet<String>();
			    	 for(int i =0 ;i<pingyinArray.length;i++)
			    	 {
			    		 pingyinSet.add(pingyinArray[i]);
			    	 }
			    	 return pingyinSet;		    
		}

		return null;
	}
	/**
	 * 递归 
	 * 
	 */
	public  static String[]  Exchange(String[][] str) {
		String[][] temp  =DoEchange(str);
		return temp[0];
	}
	/**
	 * 递归
	 * 
	 */
	private static String[][] DoEchange(String[][]  str)
	{
		int len  = str.length;
		if(len>=2)
		{
			int len1 = str[0].length;
			int len2 = str[1].length;
			int newlen  = len1*len2;
			String[] temp = new String[newlen];
			int Index = 0;
			for(int i =0 ;i<len1;i++)
			{
				for(int j=0;j<len2 ;j++)
				{
					temp[Index] = str[0][i] + str[1][j];
					Index++;
				}
			}
			String[][] newArray = new String[len-1][];
			for(int i= 2;i<len;i++){
				newArray[i-1] = str[i];
			}
			newArray[0] = temp;
			return DoEchange(newArray);
			
		}else
		{
			return  str;
		}
		
		
	}
	
}
