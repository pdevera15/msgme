package com.ccy.msgme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ccy.msgme.document.CompanyDocument;

/**
 * For test connection purpose
 */
public interface CompanyRepository extends MongoRepository<CompanyDocument, String>{
    List<CompanyDocument> findAll();
    
    @Query("{name:'?0'}")
    CompanyDocument findCompanyByName(String name);
}
