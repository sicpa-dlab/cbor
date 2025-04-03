package com.authlete.mdoc;

import com.authlete.cbor.*;

import java.net.URI;
import java.util.List;

public class IdentifierList extends CBORPairList {
    private static final CBORString LABEL_ID = new CBORString("id");
    private static final CBORString LABEL_URI = new CBORString("uri");
    private static final CBORString LABEL_CERTIFICATE = new CBORString("certificate");

    public IdentifierList(String id, URI uri, byte[] certificate) {
        super(createList(id, uri, certificate));
    }

    private static List<CBORPair> createList(String id, URI uri, byte[] certificate)
    {
        return new CBORPairsBuilder()
                .addUnlessNull(LABEL_ID, toValue(id))
                .addUnlessNull(LABEL_URI, toValue(uri))
                .addUnlessNull(LABEL_CERTIFICATE, toValue(certificate))
                .build();
    }

    private static CBORItem toValue(String value)
    {
        return new CBORString(value);
    }

    private static CBORItem toValue(URI value)
    {
        return new CBORTaggedItem(32, new CBORString(value.toString()));
    }

    private static CBORItem toValue(byte[] value)
    {
        return new CBORTaggedItem(24, new CBORByteArray(value));
    }
}
