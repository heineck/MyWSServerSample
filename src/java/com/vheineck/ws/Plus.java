/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vheineck.ws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author vheineck
 */
@WebService(serviceName = "Plus")
@Stateless()
@HandlerChain(file = "Plus_handler.xml")
public class Plus {

    @Resource
    private WebServiceContext ctx;
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        String usernameFromHeader = (String) ctx.getMessageContext().get("USERNAME");
        String passwordFromHeader = (String) ctx.getMessageContext().get("PASSWORD");
        
        System.out.println("Username[" + usernameFromHeader + "], Password[" + passwordFromHeader + "]");
        
        return "Hello[" + usernameFromHeader + "] " + txt + " !";
        
    }
}
