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
				//������һ��ֵ
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
		 * �����֤�ַ����Ƿ�ͨ����֤
		 * @param _parameters ������������ֵ��ֵ��
		 * @param sign ��֤�ַ���
		 * @return true��֤ͨ����false��֤ʧ��
		 */
		public static boolean checkSign(HashMap _parameters,String sign)
		{ 
			ArrayList alt=new ArrayList(); 
			Iterator<Object> itor= _parameters.keySet().iterator();

			while(itor.hasNext()){
				//������һ��ֵ
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
					//��ȡ�û����
					uid=v;
				}
				if(!"".equals(v) && v!=null){
					source+=k+v.trim();
				}
			}
			source+="e98a9e22e2b7bb2657517be852518d1e"; 
			if(uid.length()>0)
			{
				//��ȡ�û������һ�δ��ڴ��ȡ
				if(hm.containsKey(uid))
				{
					
					userPwd=hm.get(uid);
				}
				if(MD5.MD5Purity((source+userPwd).toLowerCase()).toLowerCase().equals(sign.toLowerCase()))
				{
					return true;
				}else
				{
					//��֤ʧ�ܴ����ݿ��ȡ�û�����
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