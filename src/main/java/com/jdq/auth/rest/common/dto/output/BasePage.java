package com.jdq.auth.rest.common.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author jindiqing
 */
@Getter
@Setter
@Accessors(chain = true)
public abstract class BasePage {

    protected int page = 1;

    protected int limit = 20;
}
