create or replace procedure testProcedure2()
    language plpgsql
as
$$
BEGIN
    update "testTable" set name = 87 where name is not null;
END;
$$;

alter procedure testProcedure2() owner to wfo_user;

select testProcedure2();