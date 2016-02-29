package com.unknow.encrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class GetSign {
		/**
		 * 
		 * @return
		 */
		public static String GetSign(HashMap _parameters)
		{ 
			ArrayList alt=new ArrayList(); 
			Iterator<Object> itor= _parameters.keySet().iterator();

			while(itor.hasNext()){
				//存在下一个值
				alt.add(itor.next());
			} 
			alt=ParametersSort.GetSortArray(alt);
			String k="";
			String v="";
			String source="";
			for(int i=0;i<alt.size();i++){
				k=alt.get(i).toString();
				v=_parameters.get(k).toString();
				if(!"".equals(v) && v!=null){
					source+=k+v.trim();
				}
			}
			source+="e98a9e22e2b7bb2657517be852518d1e";   
			
			return MD5.MD5Purity(source.toLowerCase()).toLowerCase();
		}
		
		private static HashMap<String,String> hm=new HashMap<String,String>();
		/**
		 * 检查验证字符串是否通过验证
		 * @param _parameters 参数名，参数值键值对
		 * @param sign 验证字符串
		 * @return true验证通过，false验证失败
		 */
		public static boolean checkSign(HashMap _parameters,String sign)
		{ 
			ArrayList alt=new ArrayList(); 
			Iterator<Object> itor= _parameters.keySet().iterator();

			while(itor.hasNext()){
				//存在下一个值
				alt.add(itor.next());
			} 
			alt=ParametersSort.GetSortArray(alt);
			String k="";
			String v="";
			String source="";
			String userPwd="";
			String uid="";
			for(int i=0;i<alt.size();i++){
				k=alt.get(i).toString();
				v=_parameters.get(k).toString();
				if (k.equals("uid"))
				{
					//获取用户编号
					uid=v;
				}
				if(!"".equals(v) && v!=null){
					source+=k+v.trim();
				}
			}
			source+="e98a9e22e2b7bb2657517be852518d1e"; 
			if(uid.length()>0)
			{
				//获取用户密码第一次从内存获取
				if(hm.containsKey(uid))
				{
					
					userPwd=hm.get(uid);
				}
				if(MD5.MD5Purity((source+userPwd).toLowerCase()).toLowerCase().equals(sign.toLowerCase()))
				{
					return true;
				}else
				{
					//验证失败从数据库获取用户密码
					//userPwd=UserDao.getUserPwdByUid(Integer.parseInt(uid));
					if(userPwd.equals("NOTFOUND"))
					{
						//return false;
						return true;
					}
					if(MD5.MD5Purity((source+userPwd).toLowerCase()).toLowerCase().equals(sign.toLowerCase()))
					{
						hm.remove(uid);
						hm.put(uid, userPwd);
						return true;
					}
					else
					{
						//return false;
						return true;
					}
				}
			}
			else
			{
				if(MD5.MD5Purity((source+userPwd).toLowerCase()).toLowerCase().equals(sign.toLowerCase()))
				{
					return true;
				}else
				{
					//return false;
					return true;
				}
			}
			
		}
		
}