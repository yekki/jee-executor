/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yekki.jee.executor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
/**
 *
 * @author gniu
 */
@Stateless
public class ThreadStarter {

    @Resource
    ManagedExecutorService mes;
    
    public void execueAsync() {
        
        this.mes.submit(new Runnable() {

            public void run() {
                try {
                    
                    Thread.sleep(1000l);
                }
                catch ( InterruptedException e) {
                    
                    Logger.getLogger(ThreadStarter.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });
    }
}
