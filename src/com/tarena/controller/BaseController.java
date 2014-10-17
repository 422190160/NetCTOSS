package com.tarena.controller;

import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.tarena.util.DateEditor;

/**
 *	Controller�ĸ��࣬���ڷ�װһЩ�������߼���
 */
public class BaseController {

	/**
	 * @InitBinderע��ĺ����ǣ�������ʼʱ�ȵ��ô˷�����
	 * Ȼ���ٵ���Controller��ҵ�񷽷���
	 */
	@InitBinder
  protected void initBinder(WebDataBinder binder) {
		//ע��һ���Զ���Ĵ�����
		//ʹ��DateEditor������Date���͵�����ת��
		//����SpringĬ�ϴ������ڵ����ͻ���DateEditor
		binder.registerCustomEditor(
				Date.class, new DateEditor());
  }	
	
}
