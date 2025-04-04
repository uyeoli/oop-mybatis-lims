package lims.api.approve.enums;

import lims.api.config.mybatis.typehandler.EnumeratedValueType;

public enum ApprovalRequestDomain  implements EnumeratedValueType {
    RECEIPT,
    RESULT_INPUT;

    @Override
    public String value() {
        return this.name();
    }
}
