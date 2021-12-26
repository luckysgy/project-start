package com.projectstart.api.domain.specification;

import com.concise.component.ddd.AbstractSpecification;
import com.projectstart.api.domain.model.user.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:47
 */
public class OrderWindControlSpecification extends AbstractSpecification<UserId> {
    private static final Logger log = LoggerFactory.getLogger(OrderWindControlSpecification.class);
    @Override
    public boolean isSatisfiedBy(UserId userId) {
        log.info("风控检查安全");
        return false;
    }
}
