INSERT INTO public.kursi(
	id, emri, kursi, kohezgjatja, create_table, update_table)
	VALUES (23, 'idna', 'Java', '2025-07-01 09:00:00', '2025-07-01', '2025-07-02 10:00:00'),
  (12, 'Mario', 'Python', '2025-07-02 10:00:00', '2025-07-02', '2025-07-03 11:00:00'),
  (13, 'tani', 'SQL', '2025-07-03 11:00:00', '2025-07-03', '2025-07-04 09:30:00'),
  (14, 'Ina', 'JavaScript', '2025-07-04 08:30:00', '2025-07-04', '2025-07-05 08:30:00'),
  (15, 'Besa', 'HTML', '2025-07-05 10:00:00', '2025-07-05', '2025-07-06 11:00:00'),
  (16, 'Luan', 'CSS', '2025-07-06 13:00:00', '2025-07-06', '2025-07-07 14:00:00'),
  (17, 'Mira', 'C++', '2025-07-07 14:00:00', '2025-07-07', '2025-07-08 15:00:00'),
  (18, 'Gerta', 'PHP', '2025-07-08 15:00:00', '2025-07-08', '2025-07-09 16:00:00'),
  (19, 'Ardi', 'Ruby', '2025-07-09 16:00:00', '2025-07-09', '2025-07-10 17:00:00'),
  (40,'Erza', 'Go', '2025-07-10 17:00:00', '2025-07-10', '2025-07-11 18:00:00');

/* ketu me poshte eshte shkruar kodi per shtimin e nje tabele*/


ALTER TABLE kursi
ADD COLUMN programming_language VARCHAR(10);
/*shtimi i rrjeshtit*/

--2 kush ka ndodh mes kohes per 9 dite pasi i bera te gjitha me te njejten vit
SELECT *
FROM kursi
WHERE kohezgjatja::date BETWEEN '2025-07-01' AND '2025-07-09';



