package ju.study.project.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ju.study.project.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name = "adminService")
	private AdminService adminService;


}












