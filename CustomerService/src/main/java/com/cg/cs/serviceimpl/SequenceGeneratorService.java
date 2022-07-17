package com.cg.cs.serviceimpl;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.cs.model.DbSequenceCustomer;

//@Service means the class consist of all business related logic
@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public Long getSequenceNumberForCustomer(String sequenceName) {
		// get sequence no
		Query query = new Query(Criteria.where("id").is(sequenceName));
		// update the sequence no
		Update update = new Update().inc("seq", 100);
		// modify in document
		// customer id will start from 200
		DbSequenceCustomer counter = mongoOperations.findAndModify(query, update,
				options().returnNew(true).upsert(true), DbSequenceCustomer.class);

		return (long) (!Objects.isNull(counter) ? counter.getSeq() : 1);
	}

}
