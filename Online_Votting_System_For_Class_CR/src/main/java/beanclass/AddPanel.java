package beanclass;

import java.io.Serializable;

public class AddPanel implements Serializable {
  
	private String panelName;
	private String panelSymbol;
	private String canditeName;
	private String education;
	private String gender;
	
	
//	public long getPanelId() {
//		return panelId;
//	}
	
	public String getPanelName() {
		return panelName;
	}
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}
	public String getPanelSymbol() {
		return panelSymbol;
	}
	public void setPanelSymbol(String panelSymbol) {
		this.panelSymbol = panelSymbol;
	}
	public String getCanditeName() {
		return canditeName;
	}
	public void setCanditeName(String canditeName) {
		this.canditeName = canditeName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
//	public Boolean getGender() {
//		return gender;
//	}
//	public void setGender(Boolean gender) {
//		this.gender = gender;
//	}
	
	
}
