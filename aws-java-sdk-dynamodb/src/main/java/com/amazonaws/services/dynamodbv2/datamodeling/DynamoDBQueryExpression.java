/*
 * Copyright 2011-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;

/**
 * A query expression.
 */
public class DynamoDBQueryExpression <T> {

    private boolean consistentRead = true;
    private boolean scanIndexForward = true;
    private T hashKeyValues;
    private Map<String, Condition> rangeKeyConditions;
    private Map<String, AttributeValue> exclusiveStartKey;
    private Integer limit;
    private String indexName;
    private Map<String, Condition> queryFilter;
    private String conditionalOperator;
    /**
     * Evaluates the query results and returns only the desired values.
     * <p>
     * The condition you specify is applied to the items queried; any items that
     * do not match the expression are not returned.
     */
    private String filterExpression;
    /**
     * One or more substitution variables for simplifying complex expressions.
     */
    private java.util.Map<String, String> expressionAttributeNames;

    /**
     * One or more values that can be substituted in an expression.
     */
    private java.util.Map<String, AttributeValue> expressionAttributeValues;

    /**
     * Returns whether this query uses consistent reads.
     */
    public boolean isConsistentRead() {
        return consistentRead;
    }

    /**
     * Sets whether this query uses consistent reads.
     */
    public void setConsistentRead(boolean consistentRead) {
        this.consistentRead = consistentRead;
    }

    /**
     * Sets whether this query uses consistent reads and returns a pointer to
     * this object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withConsistentRead(boolean consistentRead) {
        this.consistentRead = consistentRead;
        return this;
    }

    /**
     * Returns whether this query scans forward.
     */
    public boolean isScanIndexForward() {
        return scanIndexForward;
    }

    /**
     * Sets whether this query scans forward.
     */
    public void setScanIndexForward(boolean scanIndexForward) {
        this.scanIndexForward = scanIndexForward;
    }

    /**
     * Sets whether this query scans forward and returns a pointer to this
     * object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withScanIndexForward(boolean scanIndexForward) {
        this.scanIndexForward = scanIndexForward;
        return this;
    }

    /**
     * Returns the exclusive start key for this query.
     */
    public Map<String, AttributeValue> getExclusiveStartKey() {
        return exclusiveStartKey;
    }

    /**
     * Sets the exclusive start key for this query.
     */
    public void setExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
    }

    /**
     * Sets the exclusive start key for this query and returns a pointer to this
     * object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
        return this;
    }

    /**
     * Returns the maximum number of items to retrieve in each service request
     * to DynamoDB.
     * <p>
     * Note that when calling {@code DynamoDBMapper.query}, multiple requests
     * are made to DynamoDB if needed to retrieve the entire result set. Setting
     * this will limit the number of items retrieved by each request, NOT
     * the total number of results that will be retrieved. Use
     * {@code DynamoDBMapper.queryPage} to retrieve a single page of items from
     * DynamoDB.
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the maximum number of items to retrieve in each service request to
     * DynamoDB.
     * <p>
     * Note that when calling {@code DynamoDBMapper.query}, multiple requests
     * are made to DynamoDB if needed to retrieve the entire result set. Setting
     * this will limit the number of items retrieved by each request, NOT
     * the total number of results that will be retrieved. Use
     * {@code DynamoDBMapper.queryPage} to retrieve a single page of items from
     * DynamoDB.
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Sets the maximum number of items to retrieve in each service request to
     * DynamoDB and returns a pointer to this object for method-chaining.
     * <p>
     * Note that when calling {@code DynamoDBMapper.query}, multiple requests
     * are made to DynamoDB if needed to retrieve the entire result set. Setting
     * this will limit the number of items retrieved by each request, NOT
     * the total number of results that will be retrieved. Use
     * {@code DynamoDBMapper.queryPage} to retrieve a single page of items from
     * DynamoDB.
     */
    public DynamoDBQueryExpression<T> withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Gets the hash key value(s) for this query. All hash key attributes for
     * the table must be specified with this key object.
     */
    public T getHashKeyValues() {
        return hashKeyValues;
    }


    /**
     * Sets the hash key value(s) for this query. All hash key attributes for
     * the table must be specified with this key object.
     *
     * Note 1: Currently the DynamoDBMapper supports only one value per hash key.
     * Note 2: Currently the Amazon DynamoDB supports only one hash key per
     *         table/index.
     */
    public void setHashKeyValues(T hashKeyValues) {
        this.hashKeyValues = hashKeyValues;
    }

    /**
     * Sets the hash key value(s) for this query. All hash key attributes for
     * the table must be specified with this key object.
     */
    public DynamoDBQueryExpression<T> withHashKeyValues(T hashKObject) {
        setHashKeyValues(hashKObject);
        return this;
    }

    /**
     * Gets the range key condition for this query. All range key attributes for
     * the table must be specified by attribute name in the map.
     */
    public Map<String, Condition> getRangeKeyConditions() {
        return rangeKeyConditions;
    }

    /**
     * Sets the range key condition for this query. All range key attributes for
     * the table must be specified by attribute name in the map.
     * 
     * @param rangeKeyConditions a map from key name to condition
     * 	        NOTE: The current DynamoDB service only allows up to one
     *          range key condition per query. Providing more than one
     *          range key condition will result in an AmazonClientException.
     */
    public void setRangeKeyConditions(Map<String, Condition> rangeKeyConditions) {
        this.rangeKeyConditions = rangeKeyConditions;
    }

    /**
     * Sets the range key condition for this query. All range key attributes for
     * the table must be specified by attribute name in the map.
     * 
     * @param rangeKeyConditions a map from key name to condition
     *         NOTE: The current DynamoDB service only allows up to one range
     *         key condition per query. Providing more than one range key
     *         condition will result in an AmazonClientException.
     */
    public DynamoDBQueryExpression<T> withRangeKeyConditions(Map<String, Condition> rangeKeyConditions) {
        setRangeKeyConditions(rangeKeyConditions);
        return this;
    }

    /**
     * Sets one range key condition for this query, using the attribute name of
     * the range key. All range key attributes for the table must be specified
     * by using {@link DynamoDBRangeKey} or {@link DynamoDBIndexRangeKey} annotations
     * before executing the query.
     * <dl>
     *   <dt>If the attribute is the primary range key</dt>
     *   <dd>users should NOT set any index name for this query.</dd>
     *   <dt>If the attribute is an index range key</dt>
     * 	 <dd>
     *       {@link DynamoDBMapper} will automatically set the index name if the
     *       range key is annotated as only used by one local secondary index,
     *       otherwise users must set the index name manually by either
     *       {@link DynamoDBQueryExpression#setIndexName(String)} or
     *       {@link DynamoDBQueryExpression#withIndexName(String)}.
     *   </dd>
     * </dl>
     *
     * @param rangeKeyAttributeName
     * 	        This can be either the primary range key of the table or an
     *          index range key.
     *
     * @param rangeKeyCondition
     * 	        Condition specified on the given range key for this query.
     */
    public DynamoDBQueryExpression<T> withRangeKeyCondition(String rangeKeyAttributeName, Condition rangeKeyCondition) {
        if ( rangeKeyConditions == null )
            rangeKeyConditions = new HashMap<String, Condition>();
        rangeKeyConditions.put(rangeKeyAttributeName, rangeKeyCondition);
        return this;
    }

    /**
     * Returns the name of the index to be used by this query.
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * Sets the name of the index to be used by this query. The hash key
     * and/or range key of the index must be specified by adding
     * {@link DynamoDBIndexHashKey} or {@code DynamoDBIndexRangeKey}
     * annotations to the appropriate getter methods of the mapped
     * object.
     */
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    /**
     * Sets the name of the index to be used by this query. The hash key
     * and/or range key of the index must be specified by adding
     * {@link DynamoDBIndexHashKey} or {@code DynamoDBIndexRangeKey}
     * annotations to the appropriate getter methods of the mapped
     * object.
     * <p>
     * Returns a pointer to this object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withIndexName(String indexName) {
        setIndexName(indexName);
        return this;
    }

    /**
     * Returns the query filter applied on this query.
     */
    public Map<String, Condition> getQueryFilter() {
        return queryFilter;
    }

    /**
     * Sets the query filter applied on this query.
     */
    public void setQueryFilter(Map<String, Condition> queryFilter) {
        this.queryFilter = queryFilter;
    }

    /**
     * Sets the query filter applied on this query.
     * <p>Returns a pointer to this object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withQueryFilter(Map<String, Condition> queryFilter) {
        setQueryFilter(queryFilter);
        return this;
    }

    /**
     * Adds a new condition to the the query filter.
     * <p>Returns a pointer to this object for method-chaining.
     *
     * @param attributeName
     *            The name of the attribute on which the specified condition
     *            operates.
     * @param condition
     *            The filter condition applied on the attribute.
     */
    public DynamoDBQueryExpression<T> withQueryFilterEntry(String attributeName, Condition condition) {
        if (queryFilter == null) {
            queryFilter = new HashMap<String,Condition>();
        }
        queryFilter.put(attributeName, condition);
        return this;
    }

    /**
     * Returns the logical operator on the query filter conditions.
     */
    public String getConditionalOperator() {
        return conditionalOperator;
    }

    /**
     * Sets the logical operator on the query filter conditions.
     */
    public void setConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }

    /**
     * Sets the logical operator on the query filter conditions.
     * <p>Returns a pointer to this object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withConditionalOperator(String conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * Sets the logical operator on the query filter conditions.
     */
    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
    }

    /**
     * Sets the logical operator on the query filter conditions.
     * <p>Returns a pointer to this object for method-chaining.
     */
    public DynamoDBQueryExpression<T> withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * Evaluates the query results and returns only the desired values.
     * <p>
     * The condition you specify is applied to the items queried; any items that
     * do not match the expression are not returned.
     *
     * @return Evaluates the query results and returns only the desired values.
     *         <p>
     *         The condition you specify is applied to the items queried; any
     *         items that do not match the expression are not returned.
     * @see QueryRequest#getFilterExpression()
     */
    public String getFilterExpression() {
        return filterExpression;
    }

    /**
     * Evaluates the query results and returns only the desired values.
     * <p>
     * The condition you specify is applied to the items queried; any items that
     * do not match the expression are not returned.
     *
     * @param filterExpression
     *            Evaluates the query results and returns only the desired
     *            values.
     *            <p>
     *            The condition you specify is applied to the items queried; any
     *            items that do not match the expression are not returned.
     * @see QueryRequest#setFilterExpression(String)
     */
    public void setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
    }

    /**
     * Evaluates the query results and returns only the desired values.
     * <p>
     * The condition you specify is applied to the items queried; any items that
     * do not match the expression are not returned.
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param filterExpression
     *            Evaluates the query results and returns only the desired
     *            values.
     *            <p>
     *            The condition you specify is applied to the items queried; any
     *            items that do not match the expression are not returned.
     *
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see QueryRequest#withFilterExpression(String)
     */
    public DynamoDBQueryExpression<T> withFilterExpression(
            String filterExpression) {
        this.filterExpression = filterExpression;
        return this;
    }

    /**
     * One or more substitution variables for simplifying complex expressions.
     *
     * @return One or more substitution variables for simplifying complex
     *         expressions.
     * @see QueryRequest#getExpressionAttributeNames()
     */
    public java.util.Map<String, String> getExpressionAttributeNames() {

        return expressionAttributeNames;
    }

    /**
     * One or more substitution variables for simplifying complex expressions.
     *
     * @param expressionAttributeNames
     *            One or more substitution variables for simplifying complex
     *            expressions.
     * @see QueryRequest#setExpressionAttributeNames(Map)
     */
    public void setExpressionAttributeNames(
            java.util.Map<String, String> expressionAttributeNames) {
        this.expressionAttributeNames = expressionAttributeNames;
    }

    /**
     * One or more substitution variables for simplifying complex expressions.
     *
     * @param expressionAttributeNames
     *            One or more substitution variables for simplifying complex
     *            expressions.
     *
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see QueryRequest#withExpressionAttributeNames(Map)
     */
    public DynamoDBQueryExpression<T> withExpressionAttributeNames(
            java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    /**
     * One or more substitution variables for simplifying complex expressions.
     * The method adds a new key-value pair into ExpressionAttributeNames
     * parameter, and returns a reference to this object so that method calls
     * can be chained together.
     *
     * @param key
     *            The key of the entry to be added into
     *            ExpressionAttributeNames.
     * @param value
     *            The corresponding value of the entry to be added into
     *            ExpressionAttributeNames.
     *
     * @see QueryRequest#addExpressionAttributeNamesEntry(String, String)
     */
    public DynamoDBQueryExpression<T> addExpressionAttributeNamesEntry(
            String key, String value) {
        if (null == this.expressionAttributeNames) {
            this.expressionAttributeNames = new java.util.HashMap<String, String>();
        }
        if (this.expressionAttributeNames.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys ("
                    + key.toString() + ") are provided.");
        this.expressionAttributeNames.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeNames.
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     */
    public DynamoDBQueryExpression<T> clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    /**
     * One or more values that can be substituted in an expression.
     *
     * @return One or more values that can be substituted in an expression.
     *
     * @see QueryRequest#getExpressionAttributeValues()
     */
    public java.util.Map<String, AttributeValue> getExpressionAttributeValues() {

        return expressionAttributeValues;
    }

    /**
     * One or more values that can be substituted in an expression.
     *
     * @param expressionAttributeValues
     *            One or more values that can be substituted in an expression.
     *
     * @see QueryRequest#setExpressionAttributeValues(Map)
     */
    public void setExpressionAttributeValues(
            java.util.Map<String, AttributeValue> expressionAttributeValues) {
        this.expressionAttributeValues = expressionAttributeValues;
    }

    /**
     * One or more values that can be substituted in an expression.
     *
     * @param expressionAttributeValues
     *            One or more values that can be substituted in an expression.
     *
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see QueryRequest#withExpressionAttributeValues(Map)
     */
    public DynamoDBQueryExpression<T> withExpressionAttributeValues(
            java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    /**
     * One or more values that can be substituted in an expression. The method
     * adds a new key-value pair into ExpressionAttributeValues parameter, and
     * returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param key
     *            The key of the entry to be added into
     *            ExpressionAttributeValues.
     * @param value
     *            The corresponding value of the entry to be added into
     *            ExpressionAttributeValues.
     *
     * @see QueryRequest#addExpressionAttributeValuesEntry(String,
     *      AttributeValue)
     */
    public DynamoDBQueryExpression<T> addExpressionAttributeValuesEntry(
            String key, AttributeValue value) {
        if (null == this.expressionAttributeValues) {
            this.expressionAttributeValues = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.expressionAttributeValues.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys ("
                    + key.toString() + ") are provided.");
        this.expressionAttributeValues.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeValues.
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     */
    public DynamoDBQueryExpression<T> clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
}
