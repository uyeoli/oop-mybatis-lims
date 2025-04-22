package lims.api.approve.enums;

import lims.api.config.mybatis.typehandler.EnumeratedValueType;

public enum ApproverType implements EnumeratedValueType {

    DRAFTED,
    APPROVE,
    REJECT;

    @Override
    public String value() {
        return this.name();
    }

}
