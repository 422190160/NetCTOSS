package com.tarena.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.dao.CostDAO;
import com.tarena.entity.Cost;
import com.tarena.entity.page.CostPage;
/**
 * �ʷ�ģ�������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cost")
@SessionAttributes("costPage")
public class CostController extends BaseController {
	@Resource
	private CostDAO costDAO;
	
//	@RequestMapping("/findCost.do")
//	public String find(Model model) {
//		//����DAO��ѯȫ�����ʷ�����
//		List<Cost> list = costDAO.findAll();
//		//�����ݴ��ݸ�JSPҳ��
//		model.addAttribute("costs", list);
//		//ƥ��JSP
//		return "cost/cost_list";
//	}
	
	@RequestMapping("/findCost.do")
	public String execute(CostPage costPage,Model model){
		//��ѯ������������������ҳ��
		int rows = costDAO.findRows();
		costPage.setRows(rows);
		//����DAO��ѯĳһҳ���ʷ�����
		List<Cost> list = costDAO.findPage(costPage);
		//������
		model.addAttribute("costPage",costPage);
		model.addAttribute("costs",list);
		//ƥ��JSP
		return "cost/cost_list";
	}
	
	@RequestMapping("/toAddCost.do")
	public String toAdd(){
		//ֱ��ת��������ҳ��
		return "cost/add_cost";
	}
	
	@RequestMapping("/addCost.do")
	public String add(Cost cost){
		//����Ĭ��ֵ
		cost.setStatus("1");
		cost.setCreatime(new Timestamp(System.currentTimeMillis()));
		//��������
		costDAO.save(cost);
		//�ض��򵽲�ѯ
		return "redirect:findCost.do";		
	}
	
	@RequestMapping("/toUpdateCost.do")
	public String toUpdate(int id,Model model){
		Cost cost = costDAO.findById(id);
		model.addAttribute("cost",cost);
		//ת���޸�ҳ��
		return "cost/update_cost";
	}
	
	@RequestMapping("/updateCost.do")
	public String update(Cost cost){
		costDAO.update(cost);
		return "redirect:findCost.do";
	}
	
	@RequestMapping("/deleteCost.do")
	public String delete(@RequestParam("id")int id){
		costDAO.deleteById(id);
		return "redirect:findCost.do";
	}
	
	

}
