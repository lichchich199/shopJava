package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginationDto;

@Service
public interface PaginationService {
	public PaginationDto getPaginationInfo(int totalData, int limit, String currentPage);
	
}
