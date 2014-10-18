package com.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class loginController extends BaseController{
	//��¼�ɹ�
	public final static int SUCCESS = 0;
	//�˺Ŵ���
	public final static int ADMIN_CODE_ERROR = 1;
	//�������
	public final static int PASSWORD_CODE_ERROR = 2;
	//��֤�����
	public final static int VERIFICATION_CODE_ERROR = 3;
	
	@RequestMapping("tologin.do")
	public String tologin(){
		return "login";
	}
}
