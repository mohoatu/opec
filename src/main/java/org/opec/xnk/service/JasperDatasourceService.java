package org.opec.xnk.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.opec.xnk.domain.xnk_Nk_Hop_Dong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JasperDatasourceService {
	@Autowired
	private xnk_Nk_Hop_DongService xnk_Nk_Hop_DongService;
	
	/**
	 * Returns a data source that's wrapped within {@link JRDataSource}
	 * @return
	 */
	public JRDataSource getDataSource() {
		List<xnk_Nk_Hop_Dong> records = xnk_Nk_Hop_DongService.getAll();

		// Return wrapped collection
		return new JRBeanCollectionDataSource(records);
	}
}
