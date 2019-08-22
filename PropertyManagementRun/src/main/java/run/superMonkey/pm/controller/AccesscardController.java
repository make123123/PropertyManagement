package run.superMonkey.pm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.AccesscardService;
import run.superMonkey.pm.service.impl.AccesscardServiceImpl;
import run.superMonkey.pm.utils.ResultMessage;

/*客户服务：出入证的增删查改*/
@RestController
@RequestMapping("/customerservice/accesscard")
public class AccesscardController {
		@Autowired
		private AccesscardService as=null;
		
		@RequestMapping("/add")
		public ResultMessage<AccesscardEntity> add(
				@RequestParam(required=false)String cardno,//RequestParam 设置各值不能为空
				@RequestParam(required = false)String carno,
				@RequestParam(required = false)double customerno,
				@RequestParam(required = false)String vechicletype,
				@RequestParam(required = false)String grantno,
				@RequestParam(required = false)String cardtype,
				@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date granttime,
				@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date overduetime)throws Exception{
				AccesscardEntity accesscardEntity=new AccesscardEntity();
				accesscardEntity.setCardno(cardno);
				accesscardEntity.setCardtype(cardtype);
				accesscardEntity.setCarno(carno);
				accesscardEntity.setCustomerno(customerno);
				accesscardEntity.setGrantno(grantno);
				accesscardEntity.setGranttime(granttime);
				accesscardEntity.setOverduetime(overduetime);
				accesscardEntity.setVechicletype(vechicletype);
				as.register(accesscardEntity);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
				System.out.println(cardno);
			return new ResultMessage<AccesscardEntity>("Accpet","增加出入证成功！");
		}
		//查看该证件是否已经存在
				@GetMapping("/checkidexist")
				public boolean checkIdExist(String cardno) throws Exception{
					System.out.println(cardno);
					System.out.println( !as.checkIdExist(cardno));
					return !as.checkIdExist(cardno);
				}
		
		@RequestMapping("/get/listall")
		public List<AccesscardEntity> getListByAll()throws Exception{
			List<AccesscardEntity> result=as.getListByAll();
			return result;
		}
		@RequestMapping("/get")
		public AccesscardEntity getListByNo(
				@RequestParam(required = false)String cardno)throws Exception{
				return as.getbyNo(cardno);
		}
		//分页查找
		@RequestMapping("/get/list")
		public ResultMessage<AccesscardEntity> getListByPage(
				@RequestParam(required = false,defaultValue ="")String grantno,
				@RequestParam(required = false,defaultValue ="") String cardtype,
				@RequestParam(required = false,defaultValue ="") String carno,
			    @RequestParam(required = false,defaultValue = "1") int page,
			    @RequestParam(required = false,defaultValue ="10") int rows)throws Exception{
			ResultMessage<AccesscardEntity> result=new ResultMessage<AccesscardEntity>("Accept","取得车辆出入证列表分页成功");
		    result.setCount(as.getCountByCondition(grantno,cardtype,carno));
		    result.setPageCount(as.getPageCountByCondition(grantno,cardtype, carno, rows));
			result.setList(as.getListByPage(grantno,cardtype,carno,page,rows));
			result.setPage(page);
			result.setRows(rows);
			return result;
		}
		
		@RequestMapping("/delete")
		public ResultMessage<AccesscardEntity> delete(@RequestParam(required = false)String cardno) throws Exception{
			AccesscardEntity access=as.getbyNo(cardno);
			
			System.out.println(cardno);
			as.delete(access);
			ResultMessage<AccesscardEntity> result=new ResultMessage<AccesscardEntity>("Accept","删除车辆出入证成功");
			return result;
		}
}
