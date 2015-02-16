package org.simbiosis.ui.gwt.client;

import java.util.List;

import org.simbiosis.ui.gwt.shared.ShortMenuDv;

import com.google.gwt.user.client.Cookies;

public class SIMbiosisStatus {
	private String cookies = "simbiosis";
	private String session = "";
	private String userRealName;
	private String companyName;
	private String branchName;
	private String moduleName;
	private List<ShortMenuDv> menus;

	public SIMbiosisStatus() {
		session = Cookies.getCookie("simbiosis");
	}

	public String getCookies() {
		return cookies;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSession() {
		return session;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<ShortMenuDv> getMenus() {
		return menus;
	}

	public void setMenus(List<ShortMenuDv> menus) {
		this.menus = menus;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
