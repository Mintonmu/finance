package com.qinjingcao.finance.common;

import com.qinjingcao.finance.entity.Loan;
import com.qinjingcao.finance.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 定时任务
 */
@Configuration
@EnableScheduling
public class Scheduled {

    private Logger log = LoggerFactory.getLogger(Scheduled.class);

    @Autowired
    private LoanService loanService;

   @org.springframework.scheduling.annotation.Scheduled(cron = "0 0 23 * * ?")
    public  void test() throws Exception{
       List<Loan> list = loanService.selectAllExamedLoan();
       for (Loan loan : list) {
           Date loantime = loan.getLoantime();
           Integer term = loan.getTerm();
           Date date = new Date();
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           String loantimes = format.format(loantime);
           String currentDate = format.format(date);
           System.out.println((date.getTime() - loantime.getTime()) / (24 * 60 * 60 * 1000) + "天");
           if((date.getTime() - loantime.getTime()) / (24 * 60 * 60 * 1000)>term){
               loan.setLoanstatus(1);
               Integer result = loanService.updateLoan(loan);
               log.info(loan.getUser().getUsername()+"逾期了");
           }
       }
       log.info("定时任务执行完成->->");
    }

}
