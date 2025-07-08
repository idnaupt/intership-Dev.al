INSERT INTO public.student (
  id, emri, email, birth_date, phone_number, pike
) VALUES
  (1, 'Arben', 'arben@example.com', '2000-05-15', '+1234567890', 85)
	/*mbushja e tabeles me te dhena*/
	
ALTER TABLE public.student
RENAME TO studentet;
/*riemertim i tabeles*/

SELECT *
FROM student
WHERE LOWER(emri) LIKE 'a%';
/*emrat e stiudenteve qe fillojne me a*/



-- 1  Selekto te gjithe kurset  dhe studentet 
SELECT * FROM public.kursi;
SELECT * FROM public.studentet;

--2 selekto kush eshte mbi 25 vjec
SELECT *
FROM public.studentet
WHERE birth_date <= CURRENT_DATE - INTERVAL '25 years';









