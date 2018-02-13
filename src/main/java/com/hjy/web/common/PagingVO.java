package com.hjy.web.common;

public class PagingVO {
	
		private int totalCount; //전체게시글개수
		private int currPage=1; //현재페이지번호
		private int countPerPage=5; // 한페이지에보여질게시글수
		private int countPerGroup=3; // 페이징그룹개수 [1][2][3]..[n]
		private int totalPage; //전체페이지개수
		private int startPageNum; //현재 페이징 그룹의 첫번째 페이지 번호
		private int lastPageNum; //현재 페이징그룹의 파지막째 페이지 번호
		private int offset;
		private int limit;
		

		public int getLimit() {
			return countPerPage;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		
		public int getCurrPage() {
			return currPage;
		}
		public void setCurrPage(int currPage) {
			this.currPage = currPage;
		}
		public int getCountPerPage() {
			return countPerPage;
		}
		public void setCountPerPage(int countPerPage) {
			this.countPerPage = countPerPage;
		}
		public int getCountPerGroup() {
			return countPerGroup;
		}
		public void setCountPerGroup(int countPerGroup) {
			this.countPerGroup = countPerGroup;
		}
		public int getTotalPage() {
			//수정
			this.totalPage = (totalCount/countPerPage) + ((totalCount%countPerPage) > 0? 1:0);
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getStartPageNum() {
			//수정
			this.startPageNum = ((currPage - 1)/countPerGroup)*countPerGroup + 1;
			return startPageNum;
		}
		public void setStartPageNum(int startPageNum) {
			this.startPageNum = startPageNum;
		}
		public int getLastPageNum() {
			//수정
			this.lastPageNum = startPageNum +countPerGroup -1 ;
			
			if(lastPageNum > getTotalPage()) {
				lastPageNum = getTotalPage();
			}
			return lastPageNum;
		}
		public void setLastPageNum(int lastPageNum) {
			this.lastPageNum = lastPageNum;
		}
		public int getOffset() {
			
			this.offset=(currPage-1)*countPerPage;
			
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
}
