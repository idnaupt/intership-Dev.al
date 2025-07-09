SELECT *
FROM kursi
INNER JOIN studentet ON studentet.emri=kursi.emri;
/*ketu eshte join per dy tabela qe kan emrt te njejta stydentesh*/
CREATE TABLE student_kursia (
    student_id SERIAL PRIMARY KEY,
    student_emri VARCHAR(100) NOT NULL,
    kursi_id INTEGER,
    CONSTRAINT fk_kursi
        FOREIGN KEY (kursi_id)
        REFERENCES kursi(id)
);
/*KRIJIMI I NJE TABELE TJ ME FOREIGN KEY */
CREATE TABLE student_kursi (
    student_id INT NOT NULL,
    kursi_id INT NOT NULL,
    PRIMARY KEY (student_id, kursi_id),
    FOREIGN KEY (student_id) REFERENCES studentet(id),
    FOREIGN KEY (kursi_id) REFERENCES kursi(id)
);

/*krijimi i lidhjes many to many
