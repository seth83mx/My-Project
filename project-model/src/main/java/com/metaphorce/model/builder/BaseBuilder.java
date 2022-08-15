package com.metaphorce.model.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBuilder<B, P> {
	
	public	List<P> listBean2PO(List<B> listBean) {
		List<P> listaEntity = new ArrayList<P>() ;
		for ( B bean : listBean ) {
			P entity = bean2po(bean) ;
			listaEntity.add(entity) ;
		}
		return listaEntity ;
	}
	
	public	List<B> listaPO2Bean(List<P> listEntity) {
		List<B> listBean = new ArrayList<B>() ;
		for ( P entity : listEntity ) {
			B bean = po2bean(entity) ;
			listBean.add(bean) ;
		}
		return listBean ;
	}
	
	public	abstract P bean2po(B bean) ;
	
	public 	abstract B po2bean(P po) ;

}
