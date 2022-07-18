package com.capgemini.jwt.mongodb.controllers.security.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.capgemini.jwt.mongodb.model.DbSequenceCart;
import com.capgemini.jwt.mongodb.model.DbSequenceCustomer;
import com.capgemini.jwt.mongodb.model.DbSequenceFrame;
import com.capgemini.jwt.mongodb.model.DbSequenceGlass;
import com.capgemini.jwt.mongodb.model.DbSequenceLenses;
import com.capgemini.jwt.mongodb.model.DbSequencePayment;
import com.capgemini.jwt.mongodb.model.DbSequenceProduct;
import com.capgemini.jwt.mongodb.model.DbSequenceSunGlasses;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {


    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumberForCart(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",50);
        //modify in document
        //login id will start from 50
        DbSequenceCart pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceCart.class);
        return !Objects.isNull(pro) ? pro.getSeq() :1;
    }
    public int getSequenceNumberForPayment(String sequenceName) {
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
        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
    }
    
    public int getSequenceNumberForSunGlasses(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",50);
        //modify in document
        //login id will start from 50
        DbSequenceSunGlasses pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceSunGlasses.class);
        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
    }
    
    public int getSequenceNumberForProduct(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",100);
        //modify in document
        //login id will start from 100
        DbSequenceProduct pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceProduct.class);
        return !Objects.isNull(pro) ? pro.getSeq() :1;
    }
    public int getSequenceNumberForCustomer(String sequenceName) {
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
        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
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
    
    public int getSequenceNumberForGlass(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",100);
        //modify in document
        //login id will start from 100
        DbSequenceGlass pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceGlass.class);
        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
    }
    
    public int getSequenceNumberForLenses(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",100);
        //modify in document
        //login id will start from 100
        DbSequenceLenses pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceLenses.class);
        return (int) (!Objects.isNull(pro) ? pro.getSeq() :1);
    }
}