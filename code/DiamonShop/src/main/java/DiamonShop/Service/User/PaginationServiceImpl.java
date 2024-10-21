package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginationDto;

@Service
public class PaginationServiceImpl implements PaginationService{

	public PaginationDto getPaginationInfo(int totalData, int limit, String currentPage) {
		PaginationDto paginationDto = new PaginationDto();
		
		paginationDto.setLimit(limit);
		paginationDto.setTotalPage(getTotalPage(totalData, limit));
		paginationDto.setCurrentPage(checkCurrentPage(convertStringToInt(currentPage, 1), paginationDto.getTotalPage()));
		paginationDto.setStart(getStartIndexData(paginationDto.getCurrentPage(), limit));
		paginationDto.setEnd(getEndIndexData(paginationDto.getStart(), totalData, limit));
		
		return paginationDto;
	}
	
	private int convertStringToInt(String input, int valueDefault) {
		int result = valueDefault;
		try {
			result = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Exception convert int");
		}
		
		return result;
	}


	private int getEndIndexData(int start, int totalData, int limit) {
		return start + limit > totalData ? totalData : start + limit;
	}

	private int getStartIndexData(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1 ;
	}

	private int checkCurrentPage(int currentPage, int totalPage) {
		return currentPage <= 0 ? 1 : currentPage > totalPage && totalPage != 0 ? totalPage : currentPage ;
	}

	private int getTotalPage(int totalData, int limit) {
		return totalData % limit == 0 ? totalData/limit : totalData/limit + 1;
	}

}
