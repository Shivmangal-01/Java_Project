package beanclass;

import java.io.Serializable;

public class User implements Serializable {

	private String vote;
	private String vId;
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	
	//private Integer 
}
