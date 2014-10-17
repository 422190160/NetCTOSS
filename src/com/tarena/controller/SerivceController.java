package com.tarena.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.dao.AccountDAO;
import com.tarena.dao.CostDAO;
import com.tarena.dao.ServiceDAO;
import com.tarena.entity.Account;
import com.tarena.entity.Cost;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;

@Controller
@RequestMapping("/service")
@SessionAttributes("servicePage")
public class SerivceController extends BaseController{
	@Resource
	private ServiceDAO serviceDAO;
	@Resource
	private AccountDAO accountDAO;
	@Resource
	private CostDAO costDAO;
	
	@RequestMapping("/findService.do")
	public String find(ServicePage page, Model model) {
		//��ѯ����ǰҳ����
		List<Map<String, Object>> list = 
				serviceDAO.findByPage(page);
		model.addAttribute("services", list);
		//��ѯ������
		page.setRows(serviceDAO.findRows(page));
		model.addAttribute("servicePage", page);
		return "service/service_list";
	}
	
	@RequestMapping("/startService.do")
	@ResponseBody
	public Map<String, Object> updateStart(int id) {
		Map<String, Object> result = 
			new HashMap<String, Object>();
		//�ж������˺��Ƿ�ͨ
		Service service = serviceDAO.findById(id);
		Account account = 
			accountDAO.findById(service.getAccount_id());
		if(account.getStatus().equals("0")) {
			//��ͨ�����˺ţ�����ͨ��ǰҵ���˺�
			serviceDAO.start(id);
			result.put("success", true);
			result.put("message", "��ͨ�ɹ�.");
			//{"success":true,"message":"��ͨ�ɹ�."}			
		} else {
			//û�п�ͨ�����˺ţ�������ͨ��ǰҵ���˺�
			result.put("success", false);
			result.put("message", "�����˺�δ��ͨ�����ܿ�ͨ��ҵ���˺�.");
		}
		return result;
	}
	
	@RequestMapping("/toAddService.do")
	public String toAdd(Model model){
		//��ѯ����ص��ʷ����ݣ�������ʼ������ѡ
		List<Cost> list = costDAO.findAll();
		model.addAttribute("costs", list);
		return "service/add_service";
	}
	
	@RequestMapping("/addService.do")
	public String add(Service service){
		//����Ĭ��ֵ
		service.setStatus("0");
		service.setCreate_date((new Timestamp(System.currentTimeMillis())));
		serviceDAO.save(service);	
		return "redirect:findService.do";
	}
	
	@RequestMapping("/searchAccount.do")
	@ResponseBody
	public Account searchAccount(String idcard_no){
		//{"account_id":1,"real_name":"����",...}
		return accountDAO.findByIdcard_no(idcard_no);
	}
}
