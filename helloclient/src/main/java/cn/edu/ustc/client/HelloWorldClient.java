package cn.edu.ustc.client;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cn.edu.ustc.remote.HelloRemote;

/**
 * Hello world!
 *
 */
public class HelloWorldClient 
{
    public static void main( String[] args ) throws NamingException
    {
    	String result=GetService().Talk("JBOSS");
        System.out.printf("Result: %s\n", result);
    }
    public static HelloRemote GetService() throws NamingException {
		Hashtable<String, String> jnidProps=new Hashtable<String,String>();
		jnidProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context=new InitialContext(jnidProps);
		String jnid=String.format("ejb:/%s/%s!%s", "hello","Hello",HelloRemote.class.getName());
		return (HelloRemote)context.lookup(jnid);
	}
}
