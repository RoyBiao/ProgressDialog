/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ry.diary.common.task2;

import java.util.concurrent.Executor;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn
 * 名称：AbTaskPool.java 
 * 描述：用andbase线程池
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-5-23 上午10:10:53
 */

public class AbTaskPool{
	
	/** 单例对象 The http pool. */
	private static AbTaskPool abTaskPool = null; 
	
	/** 线程执行器. */
	public static Executor mExecutorService = null;
	/**
	 * 构造线程池.
	 */
    protected AbTaskPool() {
        mExecutorService = AbThreadFactory.getExecutorService();
    } 
	
	/**
	 * 单例构造图片下载器.
	 *
	 * @return single instance of AbHttpPool
	 */
    public static AbTaskPool getInstance() { 
    	if (abTaskPool == null) { 
    		abTaskPool = new AbTaskPool(); 
        } 
        return abTaskPool;
    } 
    
    @SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){
    	public void handleMessage(Message msg) {
    		System.out.println("Queue handle:"+Thread.currentThread().getName());
    		mExecutorService.execute((Runnable) msg.obj);
    	};
    };
    /**
     * 线程队列
     * @param runnable 任务
     */
    public synchronized void executeQueue(Runnable runnable){
//    	Message msg=Message.obtain();
//    	msg.obj=runnable;
//    	handler.sendMessage(msg);
    	System.out.println("Queue handle:"+Thread.currentThread().getName());
    	mExecutorService.execute(runnable);
    }
    
    /**
     * 线程池
     * @param runnable 任务
     */
    public void executePool(Runnable runnable){
    	mExecutorService.execute(runnable);
    }
    
    
	
}
