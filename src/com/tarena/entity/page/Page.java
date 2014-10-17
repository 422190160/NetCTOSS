package com.tarena.entity.page;
/**
 * ��ҳ��
 * @author Administrator
 *
 */
public class Page {
	//-----��ҳʱ��Ҫ���������-------
	//��ǰҳ�����û����ҳ�����룬Ĭ��Ϊ��1ҳ
	private int page = 1;
	
	//ÿҳ����������̶�ֵ
	private int pageSize = 5;
	
	//ҳ�涯̬����ҳ��ʱ��Ҫ��ֵ
	private int totalPage = 1;
	
	//������ҳ��������������
	private int rows;//������
	
	//----��ҳSQL����Ҫ������----
	private int begin;//��ʼ��
	private int end;//��ֹ��
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		if(rows % pageSize == 0){
			//�����������������ҳ������������
			totalPage=rows/pageSize;
		}else{
			//��������������ҳ����������+1
			totalPage=rows/pageSize+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getBegin() {
		begin=(page-1)*pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		end = page*pageSize+1;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	

	
}
