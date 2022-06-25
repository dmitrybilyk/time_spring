CREATE TABLE events (
                        eventid VARCHAR(255) NOT NULL,
                        eventdata JSON NOT NULL,
                        version INTEGER DEFAULT 0 NOT NULL,
                        CONSTRAINT events_pk PRIMARY KEY (eventid)
);

CREATE TABLE labels (
                        labelid     BIGINT                 NOT NULL DEFAULT 1,
                        version     INTEGER DEFAULT 0      NOT NULL,
                        type        CHARACTER(1)           NOT NULL,
                        name        CHARACTER VARYING(255) NOT NULL,
                        description CHARACTER VARYING(255),
                        CONSTRAINT label__pkey PRIMARY KEY (labelid),
                        CONSTRAINT labels_unique UNIQUE (type, name)
)


    INSERT INTO events (eventid, eventdata, VERSION) VALUES ('tag:3001', '{"type":"TAG","created":"2022-05-25T10:11:15.226355Z","createdBy":{"userId":"3b31e8cc-ff51-4a95-a715-14bf0561f277","enabled":false,"created":0},"eventId":"364a96c0-9cb4-4d86-9304-044890d95ac3","labels":[{"labelId":10}],"comment":"No pain! No pain!"}', 1);