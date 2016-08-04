package com.xiaody.application.job.task;

public class JobTask extends BaseTask {

	public void execute() {
		LOGGER.info("job task start.....");
		for (int i = 0; i < 100; i++) {
			LOGGER.info("i=" + i);
		}
		LOGGER.info("job stask end....");
	}

}
