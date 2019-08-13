package run.superMonkey.pm.controller.admin.api;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import run.superMonkey.pm.model.paramter.LoginParam;
import run.superMonkey.pm.security.token.AuthToken;
import run.superMonkey.pm.service.AdminService;


/**
 * 登陆页面
 * @author 彭俊豪Administrator
 *
 */
@Controller
@RequestMapping("/api/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
	
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	
	 	@PostMapping("login")
	    @ApiOperation("Login")
	    public AuthToken auth(@RequestBody @Valid LoginParam loginParam) {
	        return adminService.authenticate(loginParam);
	    }
	
	
	
}
