package com.example.webstarter.model;

import java.util.Arrays;

public class Chart {
	private String[] labels;
	private String[] data;
	
	public Chart() {
	}
	
	public Chart(String[] labels, String[] data) {
		this.labels = labels;
		this.data = data;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Chart [labels=" + Arrays.toString(labels) + ", data=" + Arrays.toString(data) + "]";
	}
}
