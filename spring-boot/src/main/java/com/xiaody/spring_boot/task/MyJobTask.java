package com.xiaody.spring_boot.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class MyJobTask extends BaseTask {

	@Autowired
	private ThreadPoolTaskExecutor myExecutor;

	@Scheduled(cron = "0 2 2 * * ?")
	public void execute() {
		LOGGER.info("job task start.....");
		for (int i = 0; i < 10; i++) {
			myExecutor.execute(new MyThread("" + i));
		}
		LOGGER.info("job stask end....");
	}

	class MyThread implements Runnable {

		private String command;

		public MyThread(String command) {
			this.command = command;
		}

		@Override
		public void run() {
			LOGGER.info(Thread.currentThread().getName() + " start.... command=" + command);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info(Thread.currentThread().getName() + " end");
		}
	}

}
