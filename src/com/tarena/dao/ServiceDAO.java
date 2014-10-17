package com.tarena.dao;


import java.util.List;
import java.util.Map;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;
@MyBatisDAO
public interface ServiceDAO {
	/**
	 * ��ҳ��ѯҵ���˺�
	 * @return
	 */
	List<Map<String, Object>> findByPage(ServicePage page);
	/**
	 * ��ѯ������������������
	 * @return
	 */
	int findRows(ServicePage page);
	/**
	 * ��ͨ
	 */
	void start(int id);
	/**
	 * ����id����ҵ���˺�
	 * @param id
	 * @return
	 */
	Service findById(int id);
	/**
	 * �����ҵ���˺�
	 * @param service
	 */
	void save(Service service);
	

}
