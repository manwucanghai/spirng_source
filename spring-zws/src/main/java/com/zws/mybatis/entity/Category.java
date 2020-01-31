package com.zws.mybatis.entity;

/**
 * @author zhengws
 * @date 2020-01-29 22:31
 */
public class Category {
	private int id;
	private String title;
	private long imageId;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", title='" + title + '\'' +
				", imageId=" + imageId +
				", description='" + description + '\'' +
				'}';
	}
}
