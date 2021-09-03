package com.mx.kikoya.services.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDAO {

	public static final Logger log = LoggerFactory.getLogger(GenericDAO.class);

	@Autowired
	protected JdbcTemplate template;

	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate;
}
