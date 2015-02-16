package org.simbiosis.ui.login.shared;

import java.util.ArrayList;
import java.util.List;

public class SessionDto {
	private int status;
	private String name;
	private UserDv user;
	private String module;
	private List<MenuDv> menus = new ArrayList<MenuDv>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<MenuDv> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuDv> menus) {
		this.menus = menus;
	}

	public UserDv getUser() {
		return user;
	}

	public void setUser(UserDv user) {
		this.user = user;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
