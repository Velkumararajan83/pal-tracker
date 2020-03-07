package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
	
	private long id = 0L;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the projectId
	 */
	public long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	public TimeEntry() {
		
	}
	public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
		super();
		setProjectId(projectId);
		setUserId(userId);
		setDate(date);
		setHours(hours);
	}
	
	public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
		super();
		setId(id);
		setProjectId(projectId);
		setUserId(userId);
		setDate(date);
		setHours(hours);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + hours;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));

		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		TimeEntry other = (TimeEntry) obj;

		if (date == null) {
			if (other.date != null)
				return false;

		} else if (!date.equals(other.date))
			return false;

		if (hours != other.hours)
			return false;

		if (id != other.id)
			return false;

		if (projectId != other.projectId)
			return false;

		if (userId != other.userId)
			return false;

		return true;

	}
}
