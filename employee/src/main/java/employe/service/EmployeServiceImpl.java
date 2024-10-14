package employe.service;

import java.util.List;

import employe.dao.EmployeDao;
import employe.dto.EmployeDTO;
import employe.entity.Employe;


public class EmployeServiceImpl implements EmployeService{
	
	private EmployeDao employeDao = new EmployeDao();
	
	
	public List<EmployeDTO> getAll(){
		return employeDao.getAll();
	}
	
	public EmployeDTO getById(Long id) {
		return employeDao.getById(id);
	}
	
	public void save(EmployeDTO employeDTO) {
		Employe employe = new Employe();
		employe.setId(employeDTO.getId());
		employe.setNombre(employeDTO.getNombre());
		employeDao.save(employe);
	}
	
}