package com.tarena.dao;

import java.util.List;
import java.util.Map;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;
/**
 * Role�������
 * @author Administrator
 *
 */
@MyBatisDAO
public interface RoleDAO {
	/**
	 * ��ҳ��ѯ��ɫ��Ϣ
	 * @return
	 */
	List<Role> findByPage(RolePage page);
	/**
	 * ��ѯ��ɫ������
	 * @return
	 */
	int findRows();
	/**
	 * ��ѯȫ��ģ������
	 * @return
	 */
	List<Module> findAllMoudles();
	/**
	 * �����ɫ����
	 * @param module
	 */
	void save(Role role);
	/**
	 * �����ɫģ���м������
	 * @param map
	 * һ���м�����ݣ�����key���ֶ�����ֵ���ֶ�ֵ
	 */
	void saveRoleModule(Map<String, Object> map);
}
