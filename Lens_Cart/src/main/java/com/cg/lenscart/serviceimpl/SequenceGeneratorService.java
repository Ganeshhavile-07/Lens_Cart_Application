package com.cg.lenscart.serviceimpl;


import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.lenscart.model.DbSequenceCustomer;
import com.cg.lenscart.model.DbSequenceFrame;
import com.cg.lenscart.model.DbSequenceGlass;
import com.cg.lenscart.model.DbSequenceLenses;
import com.cg.lenscart.model.DbSequenceProduct;
import com.cg.lenscart.model.DbSequenceSunGlasses;


@Service
public class SequenceGeneratorService {
   
	
	  @Autowired
	    private MongoOperations mongoOperations;


	  public int getSequenceNumberForFrame(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceFrame counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceFrame.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	  
	  public int getSequenceNumberForProduct(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceProduct counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceProduct.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    
	    public int getSequenceNumberForGlass(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",1000);
	        //modify in document
	        //login id will start from 1000
	        DbSequenceGlass counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceGlass.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
//	    
	    public int getSequenceNumberForGlasses(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",2000);
	        //modify in document
	        //planter id will start from 100
	        DbSequenceGlass counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceGlass.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
//	    
//	    
	    public int getSequenceNumberForCustomer(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceCustomer counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceCustomer.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    public int getSequenceNumberForLenses(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceLenses counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceLenses.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    public int getSequenceNumberForSunGlasses(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceSunGlasses counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceSunGlasses.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    
}
