package com.tarena.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.dao.RoleDAO;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;
/**
 * ��ɫģ�������
 * @author DongYuxiang(dongm2ez@163.com)
 * @date 2014��10��18��
 */
@Controller
@RequestMapping("/role")
@SessionAttributes("rolePage")
public class RoleController extends BaseController{
	@Resource
	private RoleDAO roleDAO;
	
	@RequestMapping("/findRole.do")
	public String find(RolePage page, Model model){
		//��ѯ��ǰҳ������
		List<Role> list = roleDAO.findByPage(page);
		model.addAttribute("roles",list);
		//��ѯ������
		page.setRows(roleDAO.findRows());
		model.addAttribute("rolePage",page);
		return "role/role_list";
	}
	
	@RequestMapping("/toAddRole.do")
	public String toAdd(Model model){
		//��ѯ��ȫ��ģ�飬���ڳ�ʼ��ģ��checkbox
		List<Module> list = roleDAO.findAllMoudles();
		model.addAttribute("modules",list);
		return "role/add_role";
	}
	
	@RequestMapping("/addRole.do")
	public String add(Role role){
		//������ɫ
		roleDAO.save(role);
		//������ɫģ���м��
		List<Integer> moduleIds = role.getModuleIds();
		if(moduleIds != null && moduleIds.size()>0){
			for(Integer moduleId:moduleIds){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_id", role.getRole_id());
				map.put("module_id", moduleId);
				roleDAO.saveRoleModule(map);
			}
		}
		return "redirect:findRole.do";
	}
	@RequestMapping("toUpdateRole.do")
	public String toUpdate(int id, Model model){
		//����id�����ɫ�����Ӧģ��
		Role role = roleDAO.findById(id);
		model.addAttribute("role",role);
		//��ѯ��ȫ��ģ�飬���ڳ�ʼ��ģ��checkbox
		List<Module> list = roleDAO.findAllMoudles();
		model.addAttribute("modules",list);
		return "role/update_role";
	}
	
	@RequestMapping("updateRole.do")
	public String update(Role role){
		//�޸Ľ�ɫ
		roleDAO.update(role);
		//ɾ����ɫ��Ӧ�м������
		roleDAO.deleteRoleModule(role.getRole_id());
		//���²����ɫ��Ӧ�м������
		List<Integer> moduleIds = role.getModuleIds();
		if(moduleIds != null && moduleIds.size() > 0){
			for(Integer moduleId : moduleIds){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_id", role.getRole_id());
				map.put("module_id", moduleId);
				roleDAO.saveRoleModule(map);
			}
		}
		return "redirect:findRole.do";
	}
}
