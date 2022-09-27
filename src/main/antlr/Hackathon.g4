grammar Hackathon;

@header{
package io.kestra.plugin.hackathon.rule.engine;
}

file: (rule)+ EOF;

rule: (typeMap|typeFilter) SEMICOLON NEWLINE*;

typeMap: put | rename | remove | filter;
typeFilter: filter;

expr: STRING
        | INT
        | DOUBLE
        | func
        | COMMENTS
        | LB expr RB
        ;


func: (put
    | remove
    | rename
    | getfield
    | concat
    | index
    | len
    | lastindexof
    | substring
    | doubeparse
    | dateformat
    | lookup
    | noop
    | filter
    | if);


/*
Support functions
*/

put: PUT LB expr COMMA expr RB;
remove: REMOVE LB expr RB;
rename: RENAME LB expr COMMA expr RB;
getfield: GETFIELD LB expr RB;

concat: CONCAT LB expr COMMA expr RB;
index: INDEX LB expr COMMA expr RB;
len: LEN LB expr COMMA expr RB;
lastindexof: LASTINDEXOF LB expr COMMA expr RB;
substring: SUBSTRING LB expr COMMA expr COMMA expr RB;
doubeparse: DOUBLEPARSE LB expr RB;
dateformat: DATEFORMAT LB expr COMMA expr COMMA expr RB;
lookup: LOOKUP LB expr COMMA expr COMMA expr RB;
noop: NOOP LB RB;

filter: FILTER LB predicate RB;

if: IF LB predicate ';' expr ':' expr RB;
predicate: expr operator expr;

operator: (EQ | GT | LT | NE);
EQ: '==';
NE: '!=';
GT: '>';
LT: '<';

/*
literal
*/
STRING: '"' ( '\\"' | . )*? '"' ; // match "foo", "\"", "x\"\"y", ...
INT: [0-9]+ ;
DOUBLE: [0-9]+ '.' [0-9]+; // match Double: '34.12'

/*
Function names
*/
PUT: 'put';
REMOVE: 'remove';
RENAME: 'rename';
GETFIELD: 'f';
CONCAT: 'concat';
INDEX: 'index';
LEN: 'len';
LASTINDEXOF: 'lastIndexOf';
SUBSTRING: 'subString';
DOUBLEPARSE: 'double';
DATEFORMAT: 'dateFormat';
LOOKUP: 'stthack';
NOOP: 'noop';
FILTER: 'filter';
IF: 'if';


COMMENTS: '//' .*? NEWLINE;
NEWLINE: '\r'? '\n' ;

SEMICOLON: ';';
LB: '(';
RB: ')';
COMMA: ',';
// Skip space, tab, new line
WS: [ \t\r\n]+ -> skip ;
