package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Cost;
import com.tarena.entity.page.Page;
/**
 * cost�������
 * @author Administrator
 *
 */
@MyBatisDAO
public interface CostDAO {
	/**
	 * ��ѯ�����ʷ�����
	 * @return
	 */
	List<Cost> findAll();
	/**
	 * ����һ���ʷ�����
	 * @param cost
	 */
	void save(Cost cost);
	/**
	 * ����ID��ѯ�ʷ�����
	 * @param id
	 * @return
	 */
	Cost findById(int id);
	/**
	 * �����ʷ�����
	 * @param cost
	 */
	void update(Cost cost);
	/**
	 * ɾ���ʷ�����
	 * @param id
	 */
	void deleteById(int id);
	/**
	 * ��÷�ҳ����
	 * @param page
	 * @return
	 */
	List<Cost> findPage(Page page);
	/**
	 * �������������
	 * @return
	 */
	int findRows();
}

