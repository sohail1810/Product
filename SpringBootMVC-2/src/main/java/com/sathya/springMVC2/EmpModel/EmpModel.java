package com.sathya.springMVC2.EmpModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
 
public class EmpModel {
	private String empName;
	private String empDept;
	private double empSal;
	private double empBonus;
	private double empDa;
	private double empHra;
	private String empComp;
	
	
	

}
