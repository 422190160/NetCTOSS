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
	 * һ���м�����ݣ�����key���ֶ�����ֵ���ֶ�ֵ
	 * @param map
	 */
	void saveRoleModule(Map<String, Object> map);
	/**
	 * ����id���ҽ�ɫ����
	 * @author DongYuxiang(dongm2ez@163.com)
	 * @date 2014��10��17��	
	 * @param id
	 * @return
	 */
	Role findById(int id);
	/**
	 * ���½�ɫ����
	 * @author DongYuxiang(dongm2ez@163.com)
	 * @date 2014��10��17��	
	 * @param role
	 */
	void update(Role role);
}
