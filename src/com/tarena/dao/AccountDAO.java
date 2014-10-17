package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;
/**
 * Account�������
 * @author Administrator
 *
 */
@MyBatisDAO
public interface AccountDAO {
	/**
	 * ��ҳ��ѯ�����˺�
	 * @param page
	 * @return
	 */
	List<Account> findByPage(AccountPage page);
	/**
	 * ��ѯ����������������������
	 * @param page
	 * @return
	 */
	int findRows(AccountPage page);
	/**
	 * ��ָ���������˺�����Ϊ��̬ͣ
	 * @param id
	 */
	void pause(int id);
	/**
	 * ��ָ�������˺�����Ϊ��ͨ״̬
	 * @param id
	 */
	void start(int id);
	/**
	 * ���������˺�
	 * @param account
	 */
	void save(Account account);
	/**
	 * ����id��ѯ�����˺�
	 * @param id
	 * @return
	 */
	Account findById(int id);
	/**
	 * �������֤�Ų�ѯ�����˺�
	 * @param idcard_no
	 * @return
	 */
	Account findByIdcard_no(String idcard_no);
}
