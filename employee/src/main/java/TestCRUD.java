import java.util.List;

import employe.dto.EmployeDTO;
import employe.service.EmployeService;
import employe.service.EmployeServiceImpl;

public class TestCRUD {
	
	
	public static void main(String args[]) {
		EmployeService employeService = new EmployeServiceImpl();
		EmployeDTO employe1 = new EmployeDTO();
		employe1.setNombre("Pedro");
		
		EmployeDTO employe2 = new EmployeDTO();
		employe1.setNombre("Carlos");
		
		employeService.save(employe1);
		employeService.save(employe2);
		
		
		List<EmployeDTO> lstEmploye = employeService.getAll();
		lstEmploye.forEach(System.out::println);
		
		EmployeDTO employe = employeService.getById(new Long(2));
		System.out.println(employe);
		
	}
}
