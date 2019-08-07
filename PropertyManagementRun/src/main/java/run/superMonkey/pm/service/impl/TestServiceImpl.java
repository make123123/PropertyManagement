package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.TestMapper;
import run.superMonkey.pm.model.entity.Test;
import run.superMonkey.pm.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	
	@Autowired
	private TestMapper tm;
	
	@Override
	public List<Test> queryAll() {
		
		return tm.queryAll();
	}

}
