package com.sathya.springMVC2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springMVC2.EmpEntity.EmpEntity;
import com.sathya.springMVC2.EmpModel.EmpModel;
import com.sathya.springMVC2.EmpRepository.EmpRepository;

@Service
public class EmpService
{
	@Autowired
	EmpRepository empRepository;

	public void saveEmpDetails(EmpModel empModel) {
		// TODO Auto-generated method stub
		double bonusAmount;
		bonusAmount=empModel.getEmpSal()*empModel.getEmpBonus()/100;
		double hraAmount;
		hraAmount=empModel.getEmpSal()*empModel.getEmpHra()/100;
		double daAmount;
		daAmount=empModel.getEmpSal()*empModel.getEmpDa()/100;
		double totalSal;
		totalSal=empModel.getEmpSal()+bonusAmount+hraAmount+daAmount;
		EmpEntity empEntity=new EmpEntity();
		empEntity.setEmpName(empModel.getEmpName());
		empEntity.setEmpDept(empModel.getEmpDept());
		empEntity.setEmpComp(empModel.getEmpComp());
		empEntity.setEmpSal(empModel.getEmpSal());
		empEntity.setEmpBonus(empModel.getEmpBonus());
		empEntity.setEmpDa(empModel.getEmpDa());
		empEntity.setEmpHra(empModel.getEmpHra());
		empEntity.setBonusAmount(bonusAmount);
		empEntity.setHraAmount(hraAmount);
		empEntity.setDaAmount(daAmount);
		empEntity.setTotalSal(totalSal);
		empRepository.save(empEntity);
		
		
		
	}

	public List<EmpEntity> getAllEmployeeDetails() 
	{
		List<EmpEntity> employees=empRepository.findAll();
		return employees;
		
	}

	public EmpEntity searchEmpById(Long empId)
	{
		Optional<EmpEntity> optionalData=empRepository.findById(empId);
	if(optionalData.isPresent())
	{
		EmpEntity emp=optionalData.get();
		return emp;
	}
	else
	{
		return null;	}
	}
	

	public void deleteByEmpId(Long empId)
	{
		empRepository.findById(empId);
	}
	
	
	
	

}
