package com.wi4solutions.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.asteriskjava.manager.response.ManagerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.wi4solutions.asterisk.Action;
import com.wi4solutions.asterisk.ActiveCallsComand;
import com.wi4solutions.asterisk.AsteriskInvoker;
import com.wi4solutions.asterisk.CommandFailedException;
import com.wi4solutions.asterisk.CommandNotFoundException;
import com.wi4solutions.asterisk.LoginCommand;
import com.wi4solutions.asterisk.LogoutCommand;
import com.wi4solutions.asterisk.ReloadCommand;
import com.wi4solutions.asterisk.RestartCommand;
import com.wi4solutions.domain.ActiveCall;
import com.wi4solutions.service.util.RandomUtil;

@Repository
public class AsteriskRepositoryImp  implements AsteriskRepository{

	@Autowired
	AsteriskInvoker asteriskInvoker ;
	public static final LoginCommand loginCommand = new LoginCommand();
	public static final ActiveCallsComand activeCallsCommand = new ActiveCallsComand();
	public static final RestartCommand restartCommand = new RestartCommand();
	public static final ReloadCommand reloadCommand = new ReloadCommand();
	
	public static final LogoutCommand logoutCommand = new LogoutCommand();
	
//	@Override
//	public List<ActiveCall> findAll() {
//		List<ActiveCall> activeCalls = new ArrayList();
//		ActiveCall a = new ActiveCall();
//		for(int i = 0; i < 10 ; i++) {
//			a = new ActiveCall();
//			a.setNumber(RandomUtil.generatePassword());
//			a.setOriginator(RandomUtil.generatePassword());
//			a.setAni(RandomUtil.generatePassword());
//			a.setDni(RandomUtil.generatePassword());
//			a.setDuration(RandomUtil.generatePassword());
//			a.setGateway(RandomUtil.generatePassword());
//			a.setId(RandomUtil.generatePassword());
//			a.setDuration(RandomUtil.generatePassword());
//			a.setStatus(RandomUtil.generatePassword());
//			activeCalls.add(a);
//		}
//		return activeCalls;
//	}
	
	
	@Override
	public String findAll(){
		List<ActiveCall> activeCalls ;
		try {
			asteriskInvoker.connect();
			asteriskInvoker.invoke(loginCommand);
			asteriskInvoker.invoke(activeCallsCommand);
			asteriskInvoker.invoke(logoutCommand);
		} catch (Exception e) {
			throw new CommandFailedException();
		}
		int code = asteriskInvoker.getCode();
		if(code == 1)
			throw new CommandFailedException();
		
//		activeCalls = lines.stream().map(((line) -> this.getActiveCall(line))).collect(Collectors.toList());
		return activeCallsCommand.getResponseString();
	}

	@Override
	public List<ActiveCall> findAll(Sort sort) {
		return null;
	}
	
	public void reloadServer() {
		try {
			asteriskInvoker.connect();
			asteriskInvoker.invoke(loginCommand);
			asteriskInvoker.invoke(reloadCommand);
			asteriskInvoker.invoke(logoutCommand);
		} catch (Exception e) {
			throw new CommandFailedException();
		}
		int code = asteriskInvoker.getCode();
		if(code == 1)
			throw new CommandFailedException();
		
	}
	
	public void restartServer() {
		try {
			asteriskInvoker.connect();
			asteriskInvoker.invoke(loginCommand);
			asteriskInvoker.invoke(restartCommand);
			asteriskInvoker.invoke(logoutCommand);
		} catch (Exception e) {
			throw new CommandFailedException();
		}
		int code = asteriskInvoker.getCode();
		if(code == 1)
			throw new CommandFailedException();
		
	}
	
	

}
