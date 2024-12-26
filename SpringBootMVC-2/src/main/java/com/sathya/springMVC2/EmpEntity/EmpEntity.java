package com.sathya.springMVC2.EmpEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmpEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
    private String empName;
	private String empDept;
	private double empSal;
	private double empBonus;
	private double empDa;
	private double empHra;
	private String empComp;
	private double bonusAmount;
	private double daAmount;
	private double hraAmount;
	private double totalSal;
	
	

}
