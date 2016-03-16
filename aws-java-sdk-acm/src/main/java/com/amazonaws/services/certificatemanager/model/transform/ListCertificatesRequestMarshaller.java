/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.certificatemanager.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.certificatemanager.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * ListCertificatesRequest Marshaller
 */
public class ListCertificatesRequestMarshaller implements
        Marshaller<Request<ListCertificatesRequest>, ListCertificatesRequest> {

    public Request<ListCertificatesRequest> marshall(
            ListCertificatesRequest listCertificatesRequest) {

        if (listCertificatesRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<ListCertificatesRequest> request = new DefaultRequest<ListCertificatesRequest>(
                listCertificatesRequest, "AWSCertificateManager");
        request.addHeader("X-Amz-Target", "CertificateManager.ListCertificates");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            java.util.List<String> certificateStatusesList = listCertificatesRequest
                    .getCertificateStatuses();
            if (certificateStatusesList != null) {
                jsonWriter.key("CertificateStatuses");
                jsonWriter.array();
                for (String certificateStatusesListValue : certificateStatusesList) {
                    if (certificateStatusesListValue != null) {
                        jsonWriter.value(certificateStatusesListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (listCertificatesRequest.getNextToken() != null) {
                jsonWriter.key("NextToken").value(
                        listCertificatesRequest.getNextToken());
            }
            if (listCertificatesRequest.getMaxItems() != null) {
                jsonWriter.key("MaxItems").value(
                        listCertificatesRequest.getMaxItems());
            }

            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
