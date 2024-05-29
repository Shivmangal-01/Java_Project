package beanclass;

import java.io.Serializable;

public class ShowResult implements Serializable {

	private String PName;
	private int count;
	private int Total;
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
}
