CREATE TABLE local.loan (
                          id bigint NOT NULL,
                          extended_end_date bytea,
                          initial_end_date bytea,
                          returned boolean NOT NULL,
                          start_date bytea,
                          book_id bigint,
                          user_id bigint
);


--
-- TOC entry 215 (class 1259 OID 196754)
-- Name: loan_id_seq; Type: SEQUENCE; Schema: local; Owner: -
--

CREATE SEQUENCE local.loan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 215
-- Name: loan_id_seq; Type: SEQUENCE OWNED BY; Schema: local; Owner: -
--

ALTER SEQUENCE local.loan_id_seq OWNED BY local.loan.id;

--
-- TOC entry 2750 (class 2604 OID 196759)
-- Name: loan id; Type: DEFAULT; Schema: local; Owner: -
--

ALTER TABLE ONLY local.loan ALTER COLUMN id SET DEFAULT nextval('local.loan_id_seq'::regclass);

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 215
-- Name: loan_id_seq; Type: SEQUENCE SET; Schema: local; Owner: -
--

SELECT pg_catalog.setval('local.loan_id_seq', 1, false);

--
-- TOC entry 2770 (class 2606 OID 196761)
-- Name: loan loan_pkey; Type: CONSTRAINT; Schema: local; Owner: -
--

ALTER TABLE ONLY local.loan
    ADD CONSTRAINT loan_pkey PRIMARY KEY (id);


