/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db.tables.records;


import games.classifier.manager.infrastructure.adapters.db.tables.Databasechangelog;

import java.time.LocalDateTime;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DatabasechangelogRecord extends TableRecordImpl<DatabasechangelogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.databasechangelog.id</code>.
     */
    public DatabasechangelogRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.databasechangelog.author</code>.
     */
    public DatabasechangelogRecord setAuthor(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.author</code>.
     */
    public String getAuthor() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.databasechangelog.filename</code>.
     */
    public DatabasechangelogRecord setFilename(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.filename</code>.
     */
    public String getFilename() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.databasechangelog.dateexecuted</code>.
     */
    public DatabasechangelogRecord setDateexecuted(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.dateexecuted</code>.
     */
    public LocalDateTime getDateexecuted() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.databasechangelog.orderexecuted</code>.
     */
    public DatabasechangelogRecord setOrderexecuted(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.orderexecuted</code>.
     */
    public Integer getOrderexecuted() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.databasechangelog.exectype</code>.
     */
    public DatabasechangelogRecord setExectype(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.exectype</code>.
     */
    public String getExectype() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.databasechangelog.md5sum</code>.
     */
    public DatabasechangelogRecord setMd5sum(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.md5sum</code>.
     */
    public String getMd5sum() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.databasechangelog.description</code>.
     */
    public DatabasechangelogRecord setDescription(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.description</code>.
     */
    public String getDescription() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.databasechangelog.comments</code>.
     */
    public DatabasechangelogRecord setComments(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.comments</code>.
     */
    public String getComments() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.databasechangelog.tag</code>.
     */
    public DatabasechangelogRecord setTag(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.tag</code>.
     */
    public String getTag() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.databasechangelog.liquibase</code>.
     */
    public DatabasechangelogRecord setLiquibase(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.liquibase</code>.
     */
    public String getLiquibase() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.databasechangelog.contexts</code>.
     */
    public DatabasechangelogRecord setContexts(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.contexts</code>.
     */
    public String getContexts() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.databasechangelog.labels</code>.
     */
    public DatabasechangelogRecord setLabels(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.labels</code>.
     */
    public String getLabels() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.databasechangelog.deployment_id</code>.
     */
    public DatabasechangelogRecord setDeploymentId(String value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.databasechangelog.deployment_id</code>.
     */
    public String getDeploymentId() {
        return (String) get(13);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DatabasechangelogRecord
     */
    public DatabasechangelogRecord() {
        super(Databasechangelog.DATABASECHANGELOG);
    }

    /**
     * Create a detached, initialised DatabasechangelogRecord
     */
    public DatabasechangelogRecord(String id, String author, String filename, LocalDateTime dateexecuted, Integer orderexecuted, String exectype, String md5sum, String description, String comments, String tag, String liquibase, String contexts, String labels, String deploymentId) {
        super(Databasechangelog.DATABASECHANGELOG);

        setId(id);
        setAuthor(author);
        setFilename(filename);
        setDateexecuted(dateexecuted);
        setOrderexecuted(orderexecuted);
        setExectype(exectype);
        setMd5sum(md5sum);
        setDescription(description);
        setComments(comments);
        setTag(tag);
        setLiquibase(liquibase);
        setContexts(contexts);
        setLabels(labels);
        setDeploymentId(deploymentId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised DatabasechangelogRecord
     */
    public DatabasechangelogRecord(games.classifier.manager.infrastructure.adapters.db.tables.pojos.Databasechangelog value) {
        super(Databasechangelog.DATABASECHANGELOG);

        if (value != null) {
            setId(value.getId());
            setAuthor(value.getAuthor());
            setFilename(value.getFilename());
            setDateexecuted(value.getDateexecuted());
            setOrderexecuted(value.getOrderexecuted());
            setExectype(value.getExectype());
            setMd5sum(value.getMd5sum());
            setDescription(value.getDescription());
            setComments(value.getComments());
            setTag(value.getTag());
            setLiquibase(value.getLiquibase());
            setContexts(value.getContexts());
            setLabels(value.getLabels());
            setDeploymentId(value.getDeploymentId());
            resetChangedOnNotNull();
        }
    }
}
