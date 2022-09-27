grammar test;
prog:	(expr ';')+ EOF ;
expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
    |	'(' expr ')'
    | 'put(' expr ')'
    ;
NEWLINE : [ \r\n]+ -> skip;
INT     : [0-9]+ ;