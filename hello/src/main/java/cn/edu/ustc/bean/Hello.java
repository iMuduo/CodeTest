package cn.edu.ustc.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import cn.edu.ustc.remote.HelloRemote;

@Stateless
@Remote(HelloRemote.class)
public class Hello implements HelloRemote
{

	@Override
	public String Talk(String name) {
		// TODO Auto-generated method stub
		return String.format("%s,Hello!", name);
	}
	
}