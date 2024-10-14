package employe.service;

import java.util.List;

import employe.dto.EmployeDTO;

public interface EmployeService {
	
	public List<EmployeDTO>getAll();
	public EmployeDTO getById(Long id);
	public void save(EmployeDTO employe);
}
