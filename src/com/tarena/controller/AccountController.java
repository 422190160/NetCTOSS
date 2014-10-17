package com.tarena.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.dao.AccountDAO;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;
/**
 * �����˺�ģ�������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/account")
@SessionAttributes("accountPage")
public class AccountController extends BaseController{
	@Resource
	private AccountDAO accountDAO;
	/**
	 * Spring����page����Ĺ���
	 * 1.�鿴session���Ƿ���page����������ֱ��ʹ�ö���
	 * 2.��session�в��������������new�¶���
	 * 3.�������л�ȡ���������ø�����
	 * 
	 * ע�⣺
	 * 	���ʸ÷���ʱ��Spring�����ȳ��Դ�session��
	 * 	ȡ�ö����ֵ��ȡֵ�������£�
	 * 	session.getAttribute("accountPage");
	 * 	��Spring���Բ������ͣ�����ĸСд��Ϊkey��
	 * 	session��ȡֵ����ôΪ�˱�֤�ܹ�ȡ�����ֵ��
	 * 	������session������ʱ������Ӧ����������������ĸСд����
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAccount.do")
	public String find(AccountPage page, Model model){
		//��ѯ����ǰҳ�����ݣ����ݸ�ҳ��
		List<Account> list = accountDAO.findByPage(page);
		model.addAttribute("accounts",list);
		//��ѯ�������������õ�page�У���page���ݸ�ҳ��
		page.setRows(accountDAO.findRows(page));
		//Ĭ������£�Spring�Ὣ���ݷ���request����ҳ��
		//��ͨ��ע��@SessionAttributes����ĳ����ʱ,Spring�ͻ�ʹ��session��ҳ�洫������
		model.addAttribute("accountPage",page);
		return "account/account_list";
	}
	
	@RequestMapping("/pauseAccount.do")
	public String updatePause(int id){
		accountDAO.pause(id);
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/startAccount.do")
	public String updateStart(int id){
		accountDAO.start(id);
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/toAddAccount.do")
	public String toAdd(){
		return "account/add_account";
	}
	
	@RequestMapping("/addAccount.do")
	public String add(Account account){
		//����Ĭ��ֵ
		account.setStatus("1");
		account.setCreate_date(new Timestamp(System.currentTimeMillis()));
		accountDAO.save(account);
		return "redirect:findAccount.do";
	}
}
