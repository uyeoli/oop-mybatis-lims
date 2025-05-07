package lims.api.approve.enums;

import lims.api.config.mybatis.typehandler.EnumeratedValueType;

public enum ApproveYn implements EnumeratedValueType {

    Y,
    N;

    @Override
    public String value() {
        return this.name();
    }

}
