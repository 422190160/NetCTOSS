package com.tarena.entity;

import java.util.List;

/**
 * ��ɫ����ʵ����
 * @author Administrator
 *
 */
public class Role {
	private Integer role_id;
	private String name;
	/**
	 * ģ��ID,���ڱ���ʱ���ձ������һ��ģ��IDֵ
	 */
	private List<Integer> moduleIds;
	/**
	 * �������ԣ����ڷ�װ��Ӧ�Ķ��ģ��,��ѯʱʹ��
	 */
	private List<Module> modules;
	
	public List<Integer> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(List<Integer> moduleIds) {
		this.moduleIds = moduleIds;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
