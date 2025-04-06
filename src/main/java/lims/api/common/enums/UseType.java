package lims.api.common.enums;

import lims.api.config.mybatis.typehandler.EnumeratedValueType;

public enum UseType implements EnumeratedValueType {

    Y,
    N;


    @Override
    public String value() {
        return this.name();
    }
}
