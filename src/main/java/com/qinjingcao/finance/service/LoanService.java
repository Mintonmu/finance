package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.Loan;

import java.util.List;

public interface LoanService {

    Integer insertLoan(Loan loan);

    List<Loan> selectLoanByLoanId(Integer loanId);

    List<Loan> selectAllLoanByApplyStatusAsc();

    List<Loan> selectAllExamedLoan();

    Loan selectLoanById(Integer id);

    Integer updateLoan(Loan loan);
}
