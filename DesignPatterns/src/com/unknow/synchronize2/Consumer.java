package com.unknow.synchronize2;

class Consumer implements Runnable {
	private Info info = null;

	public Consumer(Info info) {
		this.info = info;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			this.info.get();
		}
	}
}