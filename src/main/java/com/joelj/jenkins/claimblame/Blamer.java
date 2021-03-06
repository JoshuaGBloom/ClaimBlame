package com.joelj.jenkins.claimblame;

import hudson.model.Saveable;
import hudson.model.User;

import java.io.IOException;
import java.util.Set;

/**
 * User: joeljohnson
 * Date: 4/11/12
 * Time: 7:56 PM
 */
public interface Blamer {
	void setCulprit(String testName, User user);
	User getCulprit(String testName);

	void setStatus(String testName, Status status);
	Status getStatus(String testName);

	void save() throws IOException;
	void load();

	/**
	 * Invoked immediately after creation. This should never be called by the user.
	 * @param jobName The name of the job that is being tracked.
	 */
	void setJobName(String jobName);

	Set<String> getTests();

	void startTransaction();

	void endTransaction() throws IOException;
}
