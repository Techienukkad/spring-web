package com.techienuaakd.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("offersDAO")
public class OffersDAO {

	private NamedParameterJdbcTemplate namedJdbc;

	/*
	 * @Autowired public void setDataSource(DataSource jdbc) { this.jdbc = new
	 * JdbcTemplate(jdbc); }
	 */

	
	@Autowired
	public void setDataSource(DataSource namedjdbc) {
		this.namedJdbc = new NamedParameterJdbcTemplate(namedjdbc);
	}

	public OffersDAO() {
		super();
		System.out.println("Offers DAO");
	}

	public List<Offer> getAllOffers() {

		return namedJdbc.query("select * from offers", new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Offer offers = new Offer();
				offers.setId(rs.getInt("id"));
				offers.setName(rs.getString("name"));
				offers.setEmail(rs.getString("email"));
				offers.setText(rs.getString("text"));
				return offers;
			}
		});
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return namedJdbc.queryForObject("select * from offers where id = :id ", params, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Offer offers = new Offer();
				offers.setId(rs.getInt("id"));
				offers.setName(rs.getString("name"));
				offers.setEmail(rs.getString("email"));
				offers.setText(rs.getString("text"));
				return offers;
			}
		});
	}

	public boolean deleteOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return namedJdbc.update("delete from offers where id = :id ", params) == 1;
	}

	public boolean addOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return namedJdbc.update("insert into offers(name,email,text) values(:name,:email,:text)", params) == 1;
	}

	public boolean updateOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return namedJdbc.update("update offers set name=:name,email=:email,text=:text where id=:id", params) == 1;
	}

	@Transactional
	public int[] addAllOffer(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return namedJdbc.batchUpdate("insert into offers(name,email,text) values(:name,:email,:text)", params);

	}
}
