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

package com.amazonaws.services.datapipeline.model.transform;

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
import com.amazonaws.services.datapipeline.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * PutPipelineDefinitionRequest Marshaller
 */
public class PutPipelineDefinitionRequestMarshaller
        implements
        Marshaller<Request<PutPipelineDefinitionRequest>, PutPipelineDefinitionRequest> {

    public Request<PutPipelineDefinitionRequest> marshall(
            PutPipelineDefinitionRequest putPipelineDefinitionRequest) {

        if (putPipelineDefinitionRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<PutPipelineDefinitionRequest> request = new DefaultRequest<PutPipelineDefinitionRequest>(
                putPipelineDefinitionRequest, "DataPipeline");
        request.addHeader("X-Amz-Target", "DataPipeline.PutPipelineDefinition");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (putPipelineDefinitionRequest.getPipelineId() != null) {
                jsonWriter.key("pipelineId").value(
                        putPipelineDefinitionRequest.getPipelineId());
            }

            com.amazonaws.internal.SdkInternalList<PipelineObject> pipelineObjectsList = (com.amazonaws.internal.SdkInternalList<PipelineObject>) putPipelineDefinitionRequest
                    .getPipelineObjects();
            if (!pipelineObjectsList.isEmpty()
                    || !pipelineObjectsList.isAutoConstruct()) {
                jsonWriter.key("pipelineObjects");
                jsonWriter.array();
                for (PipelineObject pipelineObjectsListValue : pipelineObjectsList) {
                    if (pipelineObjectsListValue != null) {

                        PipelineObjectJsonMarshaller.getInstance().marshall(
                                pipelineObjectsListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.SdkInternalList<ParameterObject> parameterObjectsList = (com.amazonaws.internal.SdkInternalList<ParameterObject>) putPipelineDefinitionRequest
                    .getParameterObjects();
            if (!parameterObjectsList.isEmpty()
                    || !parameterObjectsList.isAutoConstruct()) {
                jsonWriter.key("parameterObjects");
                jsonWriter.array();
                for (ParameterObject parameterObjectsListValue : parameterObjectsList) {
                    if (parameterObjectsListValue != null) {

                        ParameterObjectJsonMarshaller.getInstance().marshall(
                                parameterObjectsListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.SdkInternalList<ParameterValue> parameterValuesList = (com.amazonaws.internal.SdkInternalList<ParameterValue>) putPipelineDefinitionRequest
                    .getParameterValues();
            if (!parameterValuesList.isEmpty()
                    || !parameterValuesList.isAutoConstruct()) {
                jsonWriter.key("parameterValues");
                jsonWriter.array();
                for (ParameterValue parameterValuesListValue : parameterValuesList) {
                    if (parameterValuesListValue != null) {

                        ParameterValueJsonMarshaller.getInstance().marshall(
                                parameterValuesListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
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
