package com.mybank.emi.service;

import com.mybank.emi.model.EmiModel;

public class EmiService {
	
	public void EmiCalculator(EmiModel emiModel) {
		
		double emi;
		emi = ((emiModel.getPrinciple() + (emiModel.getPrinciple() * emiModel.getRoi() * emiModel.getTerm())) / (emiModel.getTerm()*12));
		//(P + (P x T x R)) / (T x 12)
		emiModel.setEmi(emi);
		
	}

}
