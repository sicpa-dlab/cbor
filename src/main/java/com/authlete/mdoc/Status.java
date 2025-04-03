package com.authlete.mdoc;

import com.authlete.cbor.CBORPair;
import com.authlete.cbor.CBORPairList;
import com.authlete.cbor.CBORPairsBuilder;
import com.authlete.cbor.CBORString;

import java.util.List;

public class Status extends CBORPairList {
    private static final CBORString LABEL_STATUS_LIST = new CBORString("status_list");
    private static final CBORString LABEL_IDENTIFIER_LIST = new CBORString("identifier_list");

    public Status(StatusList statusList, IdentifierList identifierList) {
        super(createList(statusList, identifierList));
    }

    private static List<CBORPair> createList(StatusList statusList, IdentifierList identifierList)
    {
        return new CBORPairsBuilder()
                .add(LABEL_STATUS_LIST, statusList)
                .add(LABEL_IDENTIFIER_LIST, identifierList)
                .build();
    }
}
