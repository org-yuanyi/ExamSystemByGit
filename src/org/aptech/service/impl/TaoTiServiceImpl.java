package org.aptech.service.impl;

import java.sql.Connection;
import java.util.List;

import org.aptech.dao.TaoTiDao;
import org.aptech.dao.impl.TaoTiDaoImpl;
import org.aptech.pojo.TaoTi;
import org.aptech.service.TaoTiService;

public class TaoTiServiceImpl implements TaoTiService {

	private TaoTiDao td = new TaoTiDaoImpl();
	
	@Override
	public int addTaoTi(Connection con, TaoTi tt) {
		// TODO Auto-generated method stub
		return td.addTaoTi(con, tt);
	}

	@Override
	public int delTaoTi(Connection con, int taoTiId) {
		// TODO Auto-generated method stub
		return td.delTaoTi(con, taoTiId);
	}

	@Override
	public int updTaoTi(Connection con, TaoTi tt) {
		// TODO Auto-generated method stub
		return td.updTaoTi(con, tt);
	}

	@Override
	public List<TaoTi> getTaoTis() {
		// TODO Auto-generated method stub
		return td.getTaoTis();
	}
	
}
