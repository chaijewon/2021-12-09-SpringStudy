package com.sist.dao2;

import java.util.List;

public class EmpDAO {
    private EmpMapper mapper;
	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
	public List<EmpVO> empdeptJoinData()
	{
		return mapper.empdeptJoinData();
	}
}
