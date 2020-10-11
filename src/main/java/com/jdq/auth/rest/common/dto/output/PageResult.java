package com.jdq.auth.rest.common.dto.output;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {

	private long count;

	private long size;

	private int pageIndex;

	private boolean hasElse;

	private List<T> items;

	public PageResult() {
	}

	public static <T> PageResult<T> getPageResult(Page<T> page) {
		PageResult<T> pageResult = new PageResult<T>();
		pageResult.setCount(page.getTotal());
		pageResult.setPageIndex(page.getPageNum());
		pageResult.setHasElse(page.getPageNum() < page.getPages());
		pageResult.setItems(page.getResult());
		pageResult.setSize(page.getResult().size());
		return pageResult;
	}

	public static <T> PageResult<T> getPageResult(PageInfo<T> pageInfo) {
		PageResult<T> pageResult = new PageResult<T>();
		pageResult.setCount(pageInfo.getTotal());
		pageResult.setPageIndex(pageInfo.getPageNum());
		pageResult.setHasElse(pageInfo.isHasNextPage());
		pageResult.setItems(pageInfo.getList());
		pageResult.setSize(pageInfo.getList().size());
		return pageResult;
	}
}

