package com.cg.jwt.security.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.jwt.models.DbSequenceCart;
import com.cg.jwt.models.DbSequenceCustomer;
import com.cg.jwt.models.DbSequenceFrame;
import com.cg.jwt.models.DbSequenceGlass;
import com.cg.jwt.models.DbSequenceLenses;
import com.cg.jwt.models.DbSequencePayment;
import com.cg.jwt.models.DbSequenceProduct;


@Service
public class SequenceGeneratorService {
	 @Autowired
	    private MongoOperations mongoOperations;

	    public long getSequenceNumberForGlass(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",50);
	        //modify in document
	        //login id will start from 50
	        DbSequenceGlass pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceGlass.class);
	        return !Objects.isNull(pro) ? pro.getSeq() :1;
	    }
	    
	    public long getSequenceNumberForLenses(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",50);
	        //modify in document
	        //login id will start from 50
	        DbSequenceLenses pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceLenses.class);
	        return !Objects.isNull(pro) ? pro.getSeq() :1;
	    }
	    
	    public long getSequenceNumberForPayment(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",50);
	        //modify in document
	        //login id will start from 50
	        DbSequencePayment pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequencePayment.class);
	        return !Objects.isNull(pro) ? pro.getSeq() :1;
	    }
	    
	    public long getSequenceNumberForCart(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //login id will start from 100
	        DbSequenceCart pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceCart.class);
	        return !Objects.isNull(pro) ? pro.getSeq() :1;
	    }
	    
	    public long getSequenceNumberForCustomer(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //login id will start from 100
	        DbSequenceCustomer pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceCustomer.class);
	        return !Objects.isNull(pro) ? pro.getSeq() :1;
	    }
	    public int getSequenceNumberForFrame(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //login id will start from 100
	        DbSequenceFrame pro = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceFrame.class);
	        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
	    }
	}